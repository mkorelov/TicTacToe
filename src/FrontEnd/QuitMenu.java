///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               QuitMenu.java
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
class QuitMenu extends VBox {

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    QuitMenu() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text text = new Text("Are you sure you want to quit? (You will lose all progress)");
        text.setWrappingWidth(300);
        Font font = new Font(19);
        text.setFont(font);

        this.getChildren().addAll(text);
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
class QuitMenuFooter extends HBox {
    private Button yesButton;
    private Button noButton;

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    QuitMenuFooter() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        yesButton = new Button("Yes");
        noButton = new Button("No");

        this.getChildren().addAll(yesButton, noButton);
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
    Button getYesButton() {
        return this.yesButton;
    }

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    Button getNoButton() {
        return this.noButton;
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
class QuitMenuHeader extends HBox {

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    QuitMenuHeader() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text titleText = new Text("Quit Menu");

        this.getChildren().addAll(titleText);
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
class QuitMenuFrame extends BorderPane {
    private QuitMenu menu;
    private QuitMenuFooter footer;
    private QuitMenuHeader header;

    private Button yesButton;
    private Button noButton;

    private Stage oldStage;

    /**
     * (Write a succinct description of this method here.)
     *
     * @param (parameter name) (Describe the first parameter here)
     * @param (parameter name) (Do the same for each additional parameter)
     * @return (description of the return value)
     */
    QuitMenuFrame(Stage stage) {
        menu = new QuitMenu();
        footer = new QuitMenuFooter();
        header = new QuitMenuHeader();

        oldStage = stage;

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        yesButton = footer.getYesButton();
        noButton = footer.getNoButton();

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
        yesButton.setOnAction(e -> {
            Stage currStage = (Stage) yesButton.getScene().getWindow();
            currStage.close();
            MainMenuFrame root = new MainMenuFrame();
            oldStage.setTitle("Tic-Tac-Toe App");
            oldStage.setScene(new Scene(root, 700, 700));
            oldStage.setResizable(false);
            oldStage.show();
        });

        noButton.setOnAction(e -> {
            Stage currStage = (Stage) noButton.getScene().getWindow();
            currStage.close();
        });
    }
}