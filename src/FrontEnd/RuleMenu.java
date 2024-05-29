///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    (name of main application class)
// File:               (name of this class's file)
// Quarter:            (course) Spring 2020
//
// Author:             (your name and email address)
// Instructor's Name:  (name of your instructor)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       (name of your pair programming partner)
// Email:              (email address of your programming partner)
// Instructor's Name:  (name of your partner's instructor)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   Avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
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

    RuleMenuFooter() {
        this.setPrefSize(300, 200);
        this.setStyle("-fx-background-color: #F0F8FF;");

        backButton = new Button("Back");

        this.getChildren().addAll(backButton);
        this.setAlignment(Pos.CENTER);
    }

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

    void addListeners() {
        backButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            currStage.close();
        });
    }
}