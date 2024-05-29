///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               RuleMenu.java
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
class RuleMenu extends VBox {

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    RuleMenu() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text titleText = new Text("Here are the rules of Tic-Tac-Toe:");
        titleText.setWrappingWidth(300);
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");

        Text firstRule = new Text("1. Two Players take turns selecting a square and marking it with their symbol (X/O).");
        firstRule.setWrappingWidth(300);
        Font font = new Font(19);
        firstRule.setFont(font);

        Text secondRule = new Text("2.The first Player to get three boxes in a row wins the game. This can be achieved vertically, horizontally, or diagonally.");
        secondRule.setWrappingWidth(300);
        secondRule.setFont(font);

        Text thirdRule = new Text("3. If all the boxes are full and there is no winner, the game ends in a draw.");
        thirdRule.setWrappingWidth(300);
        thirdRule.setFont(font);

        this.getChildren().addAll(titleText, firstRule, secondRule, thirdRule);
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
class RuleMenuHeader extends HBox {

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    RuleMenuHeader() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Rule Menu");
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
class RuleMenuFooter extends HBox {
    private Button backButton;

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    RuleMenuFooter() {
        this.setPrefSize(300, 200);
        this.setStyle("-fx-background-color: #F0F8FF;");

        backButton = new Button("Back");

        this.getChildren().addAll(backButton);
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
}

/**
 * (Write a succinct description of this class here. You should avoid
 * wordiness and redundancy.)
 *
 * Bugs: (a list of bugs and other problems)
 *
 * @author (your name)
 */
class RuleMenuFrame extends BorderPane {
    private RuleMenuHeader header;
    private RuleMenuFooter footer;
    private RuleMenu menu;

    private Button backButton;

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    RuleMenuFrame() {
        header = new RuleMenuHeader();
        footer = new RuleMenuFooter();
        menu = new RuleMenu();

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        backButton = footer.getBackButton();

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
    }
}