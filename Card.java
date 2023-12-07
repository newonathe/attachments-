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
 * The Card class represents a card in a card game.
 */
public class Card {
    private String CardName;
    private String CardType;
    private int Health;
    private int AttackPower;

    /**
     * Constructs a Card object with the specified type, name, health, and attack power.
     *
     * @param t the type of the card
     * @param n the name of the card
     * @param h the health of the card
     * @param p the attack power of the card
     */
    public Card (String t, String n, int h, int p) {
        CardType = t;
        CardName = n;
        Health = h;
        AttackPower = p;
    }

    /**
     * Returns the name of the card.
     *
     * @return the name of the card
     */
    public String getName() {
        return CardName;
    }

    /**
     * @return the type of the card
     */
    public String getType() {
        return CardType;
    }
    
    /**
     * @return the health of the card
     */
    public int getHealth() {
        return Health;
    }

    /**
     * @return the attack power of the card
     */
    public int getPower() {
        return AttackPower;
    }

    /**
     * Reduces the health of the card by the specified amount.
     *
     * @param d the amount of damage to be taken
     */
    public void takeDamage(int d) {
        Health -= d;
    }
}