///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               PauseMenu.java
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
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
class PauseMenu extends VBox {
    private Button backButton;
    private Button quitButton;
    private Button ruleButton;

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    PauseMenu() {
        this.setPrefSize(300, 200);
        this.setStyle("-fx-background-color: #F0F8FF;");

        backButton = new Button("Back");
        backButton.setPrefHeight(40);
        backButton.setPrefWidth(60);

        quitButton = new Button("Quit");
        quitButton.setPrefHeight(40);
        quitButton.setPrefWidth(60);

        ruleButton = new Button("Rules");
        ruleButton.setPrefHeight(40);
        ruleButton.setPrefWidth(60);

        this.getChildren().addAll(ruleButton, quitButton, backButton);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    Button getBackButton() {
        return this.backButton;
    }

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    Button getQuitButton() {
        return this.quitButton;
    }

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    Button getRuleButton() {
        return this.ruleButton;
    }
}

/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
class PauseMenuHeader extends HBox {

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    PauseMenuHeader() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Pause Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
class PauseMenuFooter extends HBox {

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    PauseMenuFooter() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
class PauseMenuFrame extends BorderPane {
    private PauseMenuHeader header;
    private PauseMenuFooter footer;
    private PauseMenu menu;

    private Stage oldStage;

    private Button backButton;
    private Button quitButton;
    private Button ruleButton;

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    PauseMenuFrame(Stage stage) {
        header = new PauseMenuHeader();
        footer = new PauseMenuFooter();
        menu = new PauseMenu();

        oldStage = stage;

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        backButton = menu.getBackButton();
        quitButton = menu.getQuitButton();
        ruleButton = menu.getRuleButton();

        addListeners();
    }

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    void addListeners() {
        backButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            currStage.close();
        });

        quitButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            QuitMenuFrame root = new QuitMenuFrame(oldStage);
            currStage.setTitle("Tic-Tac-Toe App");
            currStage.setScene(new Scene(root, 300, 300));
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
