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
 * This class contains the components in the center of the Pause Menu screen.
 * There are three instance variables, which are all buttons. One button will
 * show the rules, another one returns to main menu, and the last one closes
 * this menu.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class PauseMenu extends VBox {
    private Button backButton;
    private Button quitButton;
    private Button ruleButton;

    /**
     * The default constructor of the center component of the Pause Menu 
     * screen.
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
     * Getter method for the back button.
     *
     * @return Returns the back button from the center of the Pause Menu 
     * screen.
     */
    Button getBackButton() {
        return this.backButton;
    }

    /**
     * Getter method for the quit button.
     *
     * @return Returns the quit button from the center of the Pause Menu 
     * screen.
     */
    Button getQuitButton() {
        return this.quitButton;
    }

    /**
     * Getter method for the rule button.
     *
     * @return Returns the rule button from the center of the Pause Menu 
     * screen.
     */
    Button getRuleButton() {
        return this.ruleButton;
    }
}

/**
 * This class contains the components at the top of the Pause Menu screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class PauseMenuHeader extends HBox {

    /**
     * The default constructor of the top component of the Pause Menu screen.
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
 * This class contains the components at the bottom of the Pause Menu 
 * screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class PauseMenuFooter extends HBox {

    /**
     * The default constructor of the bottom component of the Pause Menu 
     * screen.
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
 * This class combines all the components of the Pause Menu screen. It has 
 * all the same instance variables as the other classes, but also an 
 * additional one for each individual component of the screen. There is 
 * also an additional one that keeps track of the previous screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
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
     * The constructor of the entire Pause Menu screen.
     * 
     * @param Stage stage The app's display that will be populated
     * with another screen.
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
     * Performs a response after a button is clicked on the Pause Menu
     * screen.
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
