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

// import java.util.Scanner;

/**
 * Class that contains the main method to be run
 */
public class GameConsole {

    /**
     * The main method.
     * It creates an instance of the CardGui class and starts the game.
     *
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args){
         CardGui gui = new CardGui();
         gui.setGui();
         gui.Start();
         gui.spOrAt();
    }
}
//  public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Welcome to Card Battles!");

//         System.out.print("Enter Player 1 name: ");
//         String player1Name = scanner.nextLine();
//         Player player1 = new Player(player1Name);

//         System.out.print("Enter Player 2 name: ");
//         String player2Name = scanner.nextLine();
//         Player player2 = new Player(player2Name);

//         GameMaster gameMaster = new GameMaster(player1, player2);
//         System.out.println(gameMaster.dealCard() + "\n" + gameMaster.pTurn() + "\n");

//         while (!gameMaster.hasWinner()) {
//             System.out.print("Attack or Swap? ");
//             String action = scanner.next();

//             System.out.println(gameMaster.play(action));
//         }

//         System.out.println(gameMaster.gameReport());

//         scanner.close();
//     }
// }

