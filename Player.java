
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

/**
 * The Player class represents a player in a game.
 * It keeps track of the player's name, tokens, hand of cards, and hand status.
 */
public class Player {
    private String Player;
    private int tokens;
    private Card [] hand;
    private boolean handIsFull;

    /**
     * Constructs a Player object with the given name.
     * Initializes the player's tokens to 0, hand to an empty array of Cards, and handIsFull to false.
     * @param n the name of the player
     */
    public Player (String n) {
        Player = n;
        tokens = 0;
        hand = new Card[5];
        handIsFull = false;
    }

    /**
     * Draws a card and adds it to the player's hand.
     * If the hand is not full, it searches for an empty slot in the hand array and adds the card.
     * @param c the card to be drawn
     */
    public void drawCard(Card c) {
        if (!handIsFull()) {
            for (int i = 0; i < 5; i++) {
                if (hand[i] == null) {
                    hand[i] = c;
                    if (i == 4) {
                        handIsFull = true;
                    }
                    break;
                }
            }
        }
    }

    /**
     * Discards the first card in the player's hand and shifts the remaining cards.
     * The first card in the hand array is set to null, and the handIsFull flag is set to false.
     */
    public void discard() {
        for (int i = 0; i <= 3; i++) {
            hand[i] = hand[i + 1];
        }
        hand[4] = null;
        handIsFull = false;
    }
    
    /**
     * Finds the index of the card in the player's hand with the maximum product of health and power.
     * @return the index of the card with the maximum product, or -1 if no such card exists
     */
    private int findCard() {
        int maxIndex = -1;
        int maxProduct = -1;
        for (int i = 1; i < hand.length; i++) {
            int product = hand[i].getHealth() * hand[i].getPower();
            if (product > maxProduct) {
                maxProduct = product;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    /**
     * Swaps the first card in the player's hand with the card at the specified index.
     * @return a string indicating the result of the swap
     */
    public String swap() {
        String b = null;
        int index = findCard();
        if (index > -1) {
            Card a = hand[0];
            hand[0] = hand[index];
            hand[index] = a;
            b = hand[0].getName() + " is now active with " + hand[0].getHealth() + " health.";
        } else if (index == -1) {
            b = getName() + " has no other card to swap with. Turn forfeited.";
        }
        return b;
    }

    /**
     * Claims a token for the player.
     * Increments the tokens count by 1.
     */
    public void claimToken() {
        tokens ++;
    }

    /**
     * Returns the active card in the player's hand.
     * @return the active card
     */
    public Card getActiveCard() {
        return hand[0];
    }

    /**
     * Returns the name of the player.
     * @return the name of the player
     */
    public String getName() {
        return Player;
    }

    /**
     * Returns the number of tokens the player has.
     * @return the number of tokens
     */
    public int getTokens() {
        return tokens;
    }

    /**
     * Checks if the player's hand is full.
     * @return true if the hand is full, false otherwise
     */
    public boolean handIsFull() {
        for (Card card : hand) {
            if (card == null) {
                handIsFull = false; // If any slot is empty, the hand is not full
            } else {
                handIsFull = true;
            }
        }
        return handIsFull; // All slots are filled
    }

    /**
     * Generates a status report for the player, including the name and the cards in the hand.
     * @return the status report
     */
    public String statusReport() {
        String report = getName().toUpperCase() + "\n";
        for (Card c : hand) {
            report += "     " + c.getName() + " : " + c.getHealth() + "\n";
        }
        return report;
    }
}

 