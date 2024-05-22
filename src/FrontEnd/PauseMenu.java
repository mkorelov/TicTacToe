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
    private Button ruleButton;

    PauseMenu() {
        this.setPrefSize(300, 200);
        this.setStyle("-fx-background-color: #F0F8FF;");

        backButton = new Button("Back");
        saveButton = new Button("Save");
        quitButton = new Button("Quit");
        ruleButton = new Button("Rules");

        this.getChildren().addAll(backButton, saveButton, quitButton, ruleButton);
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

    Button getRuleButton() {
        return this.ruleButton;
    }
}

class PauseMenuHeader extends HBox {
    PauseMenuHeader() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Pause Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class PauseMenuFooter extends HBox {
    PauseMenuFooter() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class PauseMenuFrame extends BorderPane {
    private PauseMenuHeader header;
    private PauseMenuFooter footer;
    private PauseMenu menu;

    private Stage oldStage;

    private Button backButton;
    private Button saveButton;
    private Button quitButton;
    private Button ruleButton;

    PauseMenuFrame(Stage stage) {
        header = new PauseMenuHeader();
        footer = new PauseMenuFooter();
        menu = new PauseMenu();

        oldStage = stage;

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        backButton = menu.getBackButton();
        saveButton = menu.getSaveButton();
        quitButton = menu.getQuitButton();
        ruleButton = menu.getRuleButton();

        addListeners();
    }

    public void addListeners() {
        backButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            currStage.close();
        });

        saveButton.setOnAction(e -> {
        });

        quitButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            currStage.close();
            MainMenuFrame root = new MainMenuFrame();
            oldStage.setTitle("Tic-Tac-Toe App");
            oldStage.setScene(new Scene(root, 700, 700));
            oldStage.setResizable(false);
            oldStage.show();
        });

        ruleButton.setOnAction(e -> {
            Stage currStage = (Stage) ruleButton.getScene().getWindow();
            Stage newStage = new Stage();
            RuleMenuFrame root = new RuleMenuFrame(currStage);
            newStage.setTitle("Tic-Tac-Toe App");
            newStage.setScene(new Scene(root, 300, 300));
            newStage.setResizable(false);
            newStage.show();
        });
    }
}
