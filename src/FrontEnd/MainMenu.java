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

class MainMenu extends VBox {
    private Button startButton;
    //private Button loadButton;
    private Button ruleButton;

    MainMenu() {
        this.setPrefSize(800, 750);
        this.setStyle("-fx-background-color: #F0F8FF;");

        startButton = new Button("Start Game");
        startButton.setPrefHeight(300);
        startButton.setPrefWidth(300);
        Font font = new Font(45);
        startButton.setFont(font);

        //loadButton = new Button("Load");

        ruleButton = new Button("Rules");

        this.getChildren().addAll(startButton, /*loadButton,*/ ruleButton);
        this.setAlignment(Pos.CENTER);
    }

    Button getStartButton() {
        return this.startButton;
    }

    /*Button getLoadButton() {
        return this.loadButton;
    }*/

    Button getRuleButton() {
        return this.ruleButton;
    }
}

class MainMenuHeader extends HBox {
    MainMenuHeader() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Main Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class MainMenuFooter extends HBox {
    MainMenuFooter() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class MainMenuFrame extends BorderPane {
    private MainMenuHeader header;
    private MainMenuFooter footer;
    private MainMenu menu;

    private Button startButton;
    //private Button loadButton;
    private Button ruleButton;

    MainMenuFrame() {
        header = new MainMenuHeader();
        footer = new MainMenuFooter();
        menu = new MainMenu();

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        startButton = menu.getStartButton();
        //loadButton = menu.getLoadButton();
        ruleButton = menu.getRuleButton();

        addListeners();
    }

    public void addListeners() {
        startButton.setOnAction(e -> {
            Stage currStage = (Stage) startButton.getScene().getWindow();

            GameBoardFrame root = new GameBoardFrame();

            currStage.setTitle("Tic-Tac-Toe App");
            currStage.setScene(new Scene(root, 700, 700));
            currStage.setResizable(false);
            currStage.show();
        });

        /*loadButton.setOnAction(e -> {
            Stage currStage = (Stage) startButton.getScene().getWindow();

            LoadMenuFrame root = new LoadMenuFrame();

            currStage.setTitle("Tic-Tac-Toe App");
            currStage.setScene(new Scene(root, 700, 700));
            currStage.setResizable(false);
            currStage.show();
        });*/

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