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
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
public class Main extends Application {    
    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
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
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    public static void main(String[] args) {
        launch(args);
    }
}