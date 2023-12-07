/**
@author Ethan Owen Taruc (236196)
@version 12/8/2023
**/
/*
I have not discussed the Java language code in my program
with anyone other than my instructor or the teaching assistants
assigned to this course.
I have not used Java language code obtained from another student,
or any other unauthorized source, either modified or unmodified.
If any Java language code or documentation used in my program
was obtained from another source, such as a textbook or website,
that has been clearly noted with a proper citation in the comments
of my program.
*/

import java.util.*;

/**
 * The GameMaster class represents the game master who manages the game.
 * It keeps track of players, deck, turn counter, and game progress.
 */
public class GameMaster {
    private Player p1;
    private Player p2;
    private boolean didWin;
    private int turnCounter;
    private List<Card> deck;

    /**
     * Constructs a GameMaster object with two players.
     *
     * @param a The first player.
     * @param b The second player.
     */
public GameMaster(Player a, Player b) {
        p1 = a;
        p2 = b;
        didWin = false;
        turnCounter = 1;
        deck = new ArrayList<Card>();
        assembleDeck();
    }
    
    /**
     * The assembleDeck() method is a private method.
     * It is given entirely to the student.
     * It must NOT be modified.
     */
    private void assembleDeck() {
        deck.add(new Card("Dragon", "Aquira", 174, 26));
        deck.add(new Card("Ghost", "Brawn", 130, 48));
        deck.add(new Card("Fairy", "Cerulea", 162, 29));
        deck.add(new Card("Dragon", "Demi", 147, 28));
        deck.add(new Card("Ghost", "Elba", 155, 37));
        deck.add(new Card("Fairy", "Fye", 159, 42));
        deck.add(new Card("Dragon", "Glyede", 129, 26));
        deck.add(new Card("Ghost", "Hydran", 163, 35));
        deck.add(new Card("Fairy", "Ivy", 146, 45));
        deck.add(new Card("Dragon", "Jet", 170, 24));
        deck.add(new Card("Ghost", "Kineti", 139, 21));
        deck.add(new Card("Fairy", "Levi", 160, 43));
        deck.add(new Card("Dragon", "Meadow", 134, 29));
        deck.add(new Card("Ghost", "Naidem", 165, 26));
        deck.add(new Card("Fairy", "Omi", 145, 21));
        deck.add(new Card("Dragon", "Puddles", 170, 34));
        deck.add(new Card("Ghost", "Quarrel", 151, 29));
        deck.add(new Card("Fairy", "Raven", 168, 32));
        deck.add(new Card("Dragon", "Surge", 128, 27));
        deck.add(new Card("Ghost", "Takiru", 140, 26));
        deck.add(new Card("Fairy", "Ustelia", 163, 47));
        deck.add(new Card("Dragon", "Verwyn", 145, 25));
        deck.add(new Card("Ghost", "Wyverin", 158, 32));
        deck.add(new Card("Fairy", "Xios", 155, 27));
        deck.add(new Card("Dragon", "Yora", 159, 44));
        deck.add(new Card("Ghost", "Zulu", 125, 46));
    }

        /**
     * Gets the name of the current player.
     *
     * @return The name of the current player.
     */
    public String getPlayerNames() {
        if (turnCounter % 2 != 0) {
            return p1.getName();
        }
        return p2.getName();
    }

        /**
     * Main method that dictates the game flow
     *
     * @param action either swap or attack.
     * @return The result of the action.
     */
    public String play(String action) {
        String r = "";
        Card a = deck.get(0);
        Card b = deck.get(1);
        if (action.equalsIgnoreCase("SWAP")) {
            if (turnCounter % 2 != 0) {
                r += "  " + p1.getName() + " swaps out " + p1.getActiveCard().getName() + "...\n";
                p1.swap();
                r += "  " + p1.getActiveCard().getName() + " is now active with " + p1.getActiveCard().getHealth()
                        + " health.\n";
            } else {
                r += "  " + p2.getName() + " swaps out " + p2.getActiveCard().getName() + "...\n";
                p2.swap();
                r += "  " + p2.getActiveCard().getName() + " is now active with " + p2.getActiveCard().getHealth()
                        + " health.\n";
            }

        } else if (action.equalsIgnoreCase("ATTACK")) {
            if (turnCounter % 2 != 0) {
                r += "  " + p1.getName() + " attacks with " + p1.getActiveCard().getName() + ".\n";
                r += dealDamage(p2.getActiveCard(), p1.getActiveCard()) + "\n";
                if (p2.getActiveCard().getHealth() <= 0) {
                    r += "  " + p2.getName() + " discards " + p2.getActiveCard().getName() + ".\n";
                    p2.discard();
                    if (deck.size() > 1) {
                        if ((a.getHealth() * a.getPower()) > b.getHealth() * b.getPower()) {
                            p2.drawCard(a);
                            r += "  " + p2.getName() + " draws " + a.getName() + ".\n";
                            deck.add(b);
                            deck.remove(a);
                            deck.remove(b);
                        } else {
                            p2.drawCard(b);
                            r += "  " + p2.getName() + " draws " + b.getName() + ".\n";
                            deck.add(a);
                            deck.remove(b);
                            deck.remove(a);
                        }
                        topShifter();
                    } else if (deck.size() == 1) {
                        p2.drawCard(a);
                        r += "  " + p2.getName() + " draws " + a.getName() + ".\n";
                        deck.remove(a);
                    } else {
                        r += "  The deck is empty.\n";
                    }
                    p1.claimToken();
                    r += "  " + p1.getName() + " gets a token!\n";
                }
            } else {
                r += "  " + p2.getName() + " attacks with " + p2.getActiveCard().getName() + ".\n";
                r += dealDamage(p1.getActiveCard(), p2.getActiveCard()) + "\n";
                if (p1.getActiveCard().getHealth() <= 0) {
                    r += "  " + p1.getName() + " discards " + p1.getActiveCard().getName() + ".\n";
                    p1.discard();
                    if (deck.size() > 1) {
                        if ((a.getHealth() * a.getPower()) > b.getHealth() * b.getPower()) {
                            p1.drawCard(a);
                            r += "  " + p1.getName() + " draws " + a.getName() + ".\n";
                            deck.add(b);
                            deck.remove(a);
                            deck.remove(b);
                        } else {
                            p1.drawCard(b);
                            r += "  " + p1.getName() + " draws " + b.getName() + ".\n";
                            deck.add(a);
                            deck.remove(b);
                            deck.remove(a);
                        }
                        topShifter();
                    } else if (deck.size() == 1) {
                        p1.drawCard(a);
                        r += "  " + p1.getName() + " draws " + a.getName() + ".\n";
                        deck.remove(a);
                    } else {
                        r += "  The deck is empty.\n";
                    }
                    p2.claimToken();
                    r += "  " + p2.getName() + " gets a token!\n";
                }
            }
        }
        turnCounter++;
        return r;
    }
        /**
     * Gets the current player's turn.
     *
     * @return The current player to act.
     */
    public String pTurn() {
        String r = "";
        if (turnCounter % 2 != 0) {
            r += "It's " + p1.getName() + "'s turn.";
        } else {
            r += "It's " + p2.getName() + "'s turn.";
        }
        return r;
    }

    /**
     * Checks if the target card has resistance against the in-play card.
     *
     * @param type1 The type of the target card.
     * @param type2 The type of the in-play card.
     * @return true if the target card has resistance, false otherwise.
     */
    public boolean checkResistance(String type1, String type2) {
        if ((type1 == "Dragon") && (type2 == "Ghost") ||
                ((type1 == "Ghost") && (type2 == "Fairy")) ||
                ((type1 == "Fairy") && (type2 == "Dragon"))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the target card has weakness against the in-play card.
     *
     * @param type1 The type of the target card.
     * @param type2 The type of the in-play card.
     * @return true if the target card has weakness, false otherwise.
     */
    public boolean checkWeakness(String type1, String type2) {
        if (((type1 == "Dragon") && (type2 == "Fairy")) ||
                ((type1 == "Fairy") && (type2 == "Ghost")) ||
                ((type1 == "Ghost") && (type2 == "Dragon"))) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Shifts the top card of the deck to the bottom until a non-null card is found.
     */
    private void topShifter() {
        while (deck.get(0) == (null)) {
            for (int i = 1; i < deck.size(); i++) {
                deck.set(i - 1, deck.get(i));
            }
            deck.remove(deck.size() - 1);
        }
    }

    /**
     * Deals a card from the deck to the players.
     *
     * @return The result of dealing the card.
     */
    public String dealCard() {
        String result = "";
        int a = 0;
        while (!p1.handIsFull() || !p2.handIsFull()) {
            if (turnCounter % 2 != 0) {
                p1.drawCard(deck.get(a));
                result += p1.getName() + " draws " + deck.get(a).getName() + ".\n";
                deck.remove(a);
            } else {
                p2.drawCard(deck.get(a));
                result += p2.getName() + " draws " + deck.get(a).getName() + ".\n";
                deck.remove(a);
            }
            topShifter();
            turnCounter++;
        }

        result += "\n" + p1.getName() + "'s hand is full.\n";
        result += "\n" + p2.getName() + "'s hand is full.\n";
        return result;
    }

    /**
     * Deals damage to the target card based on the active card.
     *
     * @param target  The target card to receive damage.
     * @param inPlay  The active card that deals damage.
     * @return The report on the damage dealt
     */
    public String dealDamage(Card target, Card inPlay) {
        int damage = inPlay.getPower();
        int finDam;
        String s = "";

        if (checkWeakness(target.getType(), inPlay.getType())) {
            s += "      " + target.getType() + " is weak to " + inPlay.getType() + ".\n";
            finDam = damage * 2;
            target.takeDamage(finDam);
        } else if (checkResistance(target.getType(), inPlay.getType())) {
            s += "      " + target.getType() + " is resistant to " + inPlay.getType() + ".\n";
            finDam = damage / 2;
            target.takeDamage(finDam);
        } else {
            finDam = damage;
            target.takeDamage(finDam);
        }
        s += "  " + inPlay.getName() + " deals " + finDam + " damage on " + target.getName() + ".\n";
        s += "  " + target.getName() + " has " + target.getHealth() + " health left.";
        return s;
    }

    /**
     * Checks if there is a winner in the game.
     *
     * @return true if there is a winner, false otherwise.
     */
    public boolean hasWinner() {
        if (p1.getTokens() == 3 || p2.getTokens() == 3) {
            didWin = true;
        } else {
            didWin = false;
        }
        return didWin;
    }

    /**
     * Generates a game report with the winner and game summary.
     *
     * @return The game report.
     */
    public String gameReport() {
        String a = "";
        if (p1.getTokens() == 3) {
            a = p1.getName() + " wins!!!";
        } else if (p2.getTokens() == 3) {
            a = p2.getName() + " wins!!!";
        }

        String b = "---=== GAME SUMMARY ===---\n" +
                "This game lasted " + (turnCounter - 1) + " turns.\n" +
                p1.statusReport() + "\n" + p2.statusReport();

        String finalReport = a + "\n\n" + b;
        return finalReport;
    }
}

