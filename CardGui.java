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

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The CardGui class represents the graphical user interface for the Card Battles game.
 * It provides methods to set up the GUI, handle user input, and display game information.
 */
public class CardGui {
    private JFrame frame; // The main frame of the GUI.
    private JPanel panel1; // The main panel of the GUI.
    private JLabel nameLabel1; // Label for Player 1 name.
    private JLabel nameLabel2; // Label for Player 2 name.
    private JLabel atOrSw; // Label for Attack or Swap.
    private JButton attack; // Button for Attack action.
    private JButton swap; // Button for Swap action.
    private JButton startButton; // Button to start the game.
    private JTextField UserInput1; // Text field for Player 1 name input.
    private JTextField UserInput2; // Text field for Player 2 name input.
    private JTextArea console; // Text area to display game information.
    private JLabel playerTurnLabel; // Label to display current player's turn.
    private int width; // Width of the GUI frame.
    private int height; // Height of the GUI frame.
    private GameMaster gm; // The game master object that controls the game logic.

    /**
     * Constructs a CardGui object.
     * Initializes the GUI components and sets default values for width and height.
     */
    public CardGui() {
        frame = new JFrame("Card Battles");
        panel1 = new JPanel();
        nameLabel1 = new JLabel("Player 1:");
        nameLabel2 = new JLabel("Player 2:");
        UserInput1 = new JTextField(20);
        UserInput2 = new JTextField(20);
        atOrSw = new JLabel("Attack or Swap?");
        attack = new JButton("Attack");
        swap = new JButton("Swap");
        startButton = new JButton("Start Game");
        playerTurnLabel = new JLabel("Press start to play");
        console = new JTextArea(45, 57);
        console.setEditable(false);
        width = 600;
        height = 800;
    }

    /**
     * Sets up the GUI by adding components to the frame and making it visible.
     */
    public void setGui() {
        frame.setSize(width, height);
        panel1.add(nameLabel1);
        panel1.add(UserInput1);
        panel1.add(nameLabel2);
        panel1.add(UserInput2);
        panel1.add(atOrSw);
        panel1.add(attack);
        panel1.add(swap);
        panel1.add(startButton);
        panel1.add(playerTurnLabel);
        panel1.add(console);
        frame.add(panel1);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    /**
     * Used to get the name of player 1
     * 
     * @return The input from Player 1 text field.
     */
    private String getP1() {
        return UserInput1.getText();
    }

    /**
     * Used to get the name of player 2
     * 
     * @return The input from Player 2 text field.
     */
    private String getP2() {
        return UserInput2.getText();
    }

    /**
     * Sets the text of the playerTurnLabel to the given turnInfo.
     * also used to diplay other text to that part
     * 
     * @param turnInfo The information about the current player's turn.
     */
    private void setPlayerTurnLabel(String turnInfo) {
        playerTurnLabel.setText(turnInfo);
    }

    /**
     * displays the result
     * 
     * @param a The string to be displayed in the console text area.
     */
    public void setTextField(String a) {
        console.setText(a);
    }

    /**
     * Adds action listeners to the attack and swap buttons.
     * Handles the button clicks by calling the appropriate methods of the GameMaster object.
     */
    public void spOrAt() {
        ActionListener Listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object o = e.getSource();
                if (!gm.hasWinner()) {
                    if (o == attack) {
                        console.setText(gm.play("attack"));
                    } else if (o == swap) {
                        console.setText(gm.play("swap"));
                    }
                    String a = "             " + gm.pTurn();
                    setPlayerTurnLabel(a);
                } else {
                    console.setText(gm.gameReport());
                    setPlayerTurnLabel("Play again?");
                }
            }
        };
        attack.addActionListener(Listener);
        swap.addActionListener(Listener);
    }

    /**
     * Adds an action listener to the startButton.
     * Handles the button click by creating Player objects, GameMaster object, and initializing the game.
     */
    public void Start() {
        ActionListener Listener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String player1 = getP1();
                String player2 = getP2();
                Player p1 = new Player(player1);
                Player p2 = new Player(player2);
                gm = new GameMaster(p1, p2);
                String rs = "";
                rs += gm.dealCard();
                String a = "             " + gm.pTurn();
                setPlayerTurnLabel(a);
                console.setText(rs);
                setPlayerTurnLabel("Welcome " + getP1() + " and " + getP2() + " to Card Battles!");
            }
        };
        startButton.addActionListener(Listener2);
    }
}



