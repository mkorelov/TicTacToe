///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               MainMenu.java
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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

/**
 * This class contains the components in the center of the Main Menu screen.
 * The two instance variables are both buttons, where one is to start a game
 * and the other is to look at the rules.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class MainMenu extends VBox {
    private Button startButton;
    private Button ruleButton;

    /**
     * The default constructor of the center component of the Main Menu 
     * screen.
     */
    MainMenu() {
        this.setPrefSize(800, 750);
        this.setStyle("-fx-background-color: #F0F8FF;");
        
        String path = "src/playbutton.png";
        Image image = new Image(new File(path).toURI().toString());
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(280);
        imageView.setFitHeight(280);
        startButton = new Button();
        startButton.setGraphic(imageView);

        startButton.setPrefHeight(300);
        startButton.setPrefWidth(300);

        ruleButton = new Button("Rules");
        ruleButton.setPrefHeight(50);
        ruleButton.setPrefWidth(300);
        Font font = new Font(25);
        ruleButton.setFont(font);

        this.getChildren().addAll(startButton, ruleButton);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * Getter method for the start button.
     *
     * @return Returns the start button from the center of the Main Menu 
     * screen.
     */
    Button getStartButton() {
        return this.startButton;
    }

    /**
     * Getter method for the rule button.
     *
     * @return Returns the rule button from the center of the Main Menu 
     * screen.
     */
    Button getRuleButton() {
        return this.ruleButton;
    }
}

/**
 * This class contains the components at the top of the Main Menu screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class MainMenuHeader extends HBox {

    /**
     * The default constructor of the top component of the Main Menu screen.
     */
    MainMenuHeader() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Main Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * This class contains the components at the bottom of the Main Menu screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class MainMenuFooter extends HBox {

    /**
     * The default constructor of the bottom component of the Main Menu screen.
     */
    MainMenuFooter() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * This class combines all the components of the Main Menu screen. It has 
 * all the same instance variables as the other classes, but also an 
 * additional one for each individual component of the screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class MainMenuFrame extends BorderPane {
    private MainMenuHeader header;
    private MainMenuFooter footer;
    private MainMenu menu;

    private Button startButton;
    private Button ruleButton;

    /**
     * The default constructor of the entire Game Over Menu screen.
     */
    MainMenuFrame() {
        header = new MainMenuHeader();
        footer = new MainMenuFooter();
        menu = new MainMenu();

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        startButton = menu.getStartButton();
        ruleButton = menu.getRuleButton();

        addListeners();
    }

    /**
     * Performs a response after a button is clicked on the Main Menu
     * screen.
     */
    void addListeners() {
        startButton.setOnAction(e -> {
            Stage currStage = (Stage) startButton.getScene().getWindow();

            GameBoardFrame root = new GameBoardFrame();

            currStage.setTitle("Tic-Tac-Toe App");
            currStage.setScene(new Scene(root, 700, 700));
            currStage.setResizable(false);
            currStage.show();
        });

        ruleButton.setOnAction(e -> {
            Stage newStage = new Stage();
            RuleMenuFrame root = new RuleMenuFrame();
            newStage.setTitle("Tic-Tac-Toe App");
            newStage.setScene(new Scene(root, 300, 300));
            newStage.setResizable(false);
            newStage.show();
        });
    }
}