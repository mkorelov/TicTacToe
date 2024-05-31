///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               GameOverMenu.java
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

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.*;

/**
 * This class contains the components in the center of the Game Over Menu
 * screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class GameOverMenu extends VBox{

    /**
     * The constructor of the center component of the Game Over Menu 
     * screen.
     * 
     * @param int n Determines which mesage to display based on winner.
     */
    GameOverMenu(int n) {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        String message = "";
        if (n == -1) {
            message = "It's a Draw";
        } else if (n == 0) {
            message = "Player 1 Wins";
        } else if (n == 1) {
            message = "Player 2 Wins";
        }
        Text text = new Text(message);
        text.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(text);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * This class contains the components at the top of the Game Over Menu
 * screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class GameOverHeader extends HBox {

    /**
     * The default constructor of the top component of the Game Over Menu 
     * screen.
     */
    GameOverHeader() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Game Over Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * This class contains the components at the bottom of the Game Over Menu
 * screen. There are two instance variables, which are buttons. One is to 
 * play again and the other is to return to the main menu.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class GameOverFooter extends HBox{
    private Button playButton;
    private Button backButton;

    /**
     * The default constructor of the bottom component of the Game Over Menu 
     * screen.
     */
    GameOverFooter() {
        this.setPrefSize(300, 200);
        this.setStyle("-fx-background-color: #F0F8FF;");

        playButton = new Button("Play Again");
        backButton = new Button("Back");

        this.getChildren().addAll(backButton, playButton);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Getter method for the play button.
     *
     * @return Returns the play button from the bottom of the Game Over Menu 
     * screen.
     */
    Button getPlayButton() {
        return this.playButton;
    }

    /**
     * Getter method for the back button.
     *
     * @return Returns the back button from the bottom of the Game Over Menu 
     * screen.
     */
    Button getBackButton() {
        return this.backButton;
    }
}

/**
 * This class combines all the components of the Game Over Menu screen. 
 * It has all the same instance variables as the other classes, but also an 
 * additional one for each individual component of the screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class GameOverFrame extends BorderPane {
    private GameOverMenu menu;
    private GameOverHeader header;
    private GameOverFooter footer;

    private Button playButton;
    private Button backButton;

    /**
     * The constructor of the entire Game Over Menu screen.
     * 
     * @param int n Informs of the winner of the previous game.
     */
    GameOverFrame(int n) {
        menu = new GameOverMenu(n);
        header = new GameOverHeader();
        footer = new GameOverFooter();

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        playButton = footer.getPlayButton();
        backButton = footer.getBackButton();

        addListeners();
    }

    /**
     * Performs a response after a button is clicked on the Game Over Menu
     * screen.
     */
    void addListeners() {
        playButton.setOnAction(e -> {
            Stage currStage = (Stage) playButton.getScene().getWindow();
            GameBoardFrame root = new GameBoardFrame();
            currStage.setTitle("Tic-Tac-Toe App");
            currStage.setScene(new Scene(root, 700, 700));
            currStage.setResizable(false);
            currStage.show();
        });

        backButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            MainMenuFrame root = new MainMenuFrame();
            currStage.setTitle("Tic-Tac-Toe App");
            currStage.setScene(new Scene(root, 700, 700));
            currStage.setResizable(false);
            currStage.show();
        });
    }
}