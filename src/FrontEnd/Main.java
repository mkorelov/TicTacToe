///////////////////////////////////////////////////////////////////////////////
//
// Title:              TicTacToe
// Files:              Game.java, GameBoard.java, GameOverMenu.java,
//                     MainMenu.java, PauseMenu.java, QuitMenu.java,
//                     RuleMenu.java
//
// Date:               May 29, 2024
// Author:             Michael Korelov
// Email:              korelovmichael@gmail.com
//
///////////////////////////////////////////////////////////////////////////////
//
// Online sources:   UCSD CSE 110 Professor Miranda Lab 1
//
//////////////////////////// 80 columns wide //////////////////////////////////

package FrontEnd;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class contains the main method to run the application.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
public class Main extends Application {

    /**
     * Method that displays the initial screen for the app.
     *
     * @param Stage primaryStage The app's display that will be populated
     * with the Main Menu.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainMenuFrame root = new MainMenuFrame();
        primaryStage.setTitle("Tic-Tac-Toe App");
        primaryStage.setScene(new Scene(root, 700, 700));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    /**
     * This is the main method that runs the application.
     *
     * @param String[] args Array that holds any argument passed in.
     */
    public static void main(String[] args) {
        launch(args);
    }
}