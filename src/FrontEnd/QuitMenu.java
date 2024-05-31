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
 * This class contains the components in the center of the Quit Menu screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class QuitMenu extends VBox {

    /**
     * The default constructor of the center component of the Quit Menu screen.
     */
    QuitMenu() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        String str = "Are you sure you? (You will lose all progress)";
        Text text = new Text(str);
        text.setWrappingWidth(300);
        Font font = new Font(19);
        text.setFont(font);

        this.getChildren().addAll(text);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * This class contains the components at the top of the Quit Menu screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class QuitMenuHeader extends HBox {

    /**
     * The default constructor of the top component of the Quit Menu screen.
     */
    QuitMenuHeader() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text titleText = new Text("Quit Menu");

        this.getChildren().addAll(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

/**
 * This class contains the components at the bottom of the Quit Menu screen.
 * The instance variables are two buttons, which represent yes and no.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class QuitMenuFooter extends HBox {
    private Button yesButton;
    private Button noButton;

    /**
     * The default constructor of the bottom component of the Quit Menu 
     * screen.
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
     * Getter method for the yes button.
     *
     * @return Returns the yes button from the bottom of the Quit Menu 
     * screen.
     */
    Button getYesButton() {
        return this.yesButton;
    }

    /**
     * Getter method for the no button.
     *
     * @return Returns the no button from the bottom of the Quit Menu 
     * screen.
     */
    Button getNoButton() {
        return this.noButton;
    }
}

/**
 * This class combines all the components of the Quit Menu screen. It has 
 * all the same instance variables as the other classes, but also an 
 * additional one for each individual component of the screen. There is 
 * also an additional one that keeps track of the previous screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class QuitMenuFrame extends BorderPane {
    private QuitMenu menu;
    private QuitMenuFooter footer;
    private QuitMenuHeader header;

    private Button yesButton;
    private Button noButton;

    private Stage oldStage;

    /**
     * The constructor of the entire Quit Menu screen.
     * 
     * @param Stage stage The app's display that will be populated
     * with another screen.
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
     * Performs a response after a button is clicked on the Quit Menu
     * screen.
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