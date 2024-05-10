package FrontEnd;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.text.*;

class PauseMenu extends VBox {
    private Button backButton;
    private Button saveButton;
    private Button quitButton;

    PauseMenu() {
        this.setPrefSize(800, 750);
        this.setStyle("-fx-background-color: #F0F8FF;");

        backButton = new Button("Back");
        saveButton = new Button("Save");
        quitButton = new Button("Quit");

        this.getChildren().addAll(backButton, saveButton, quitButton);
        this.setAlignment(Pos.CENTER);
    }

    Button getBackButton() {
        return this.backButton;
    }

    Button getSaveButton() {
        return this.saveButton;
    }

    Button getQuitButton() {
        return this.quitButton;
    }
}

class PauseMenuHeader extends HBox {
    PauseMenuHeader() {

    }
}

class PauseMenuFooter extends HBox {
    PauseMenuFooter() {

    }
}

class PauseMenuFrame extends BorderPane {
    private PauseMenuHeader header;
    private PauseMenuFooter footer;
    private PauseMenu menu;

    private Button backButton;
    private Button saveButton;
    private Button quitButton;

    PauseMenuFrame() {
        header = new PauseMenuHeader();
        footer = new PauseMenuFooter();
        menu = new PauseMenu();

        //this.setTop(header);
        this.setCenter(menu);
        //this.setBottom(footer);

        backButton = menu.getBackButton();
        saveButton = menu.getSaveButton();
        quitButton = menu.getQuitButton();

        addListeners();
    }

    public void addListeners() {
        backButton.setOnAction(e -> {
        });

        saveButton.setOnAction(e -> {
        });

        quitButton.setOnAction(e -> {
        });
    }
}
