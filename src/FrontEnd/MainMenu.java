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

    MainMenu() {
        this.setPrefSize(800, 750);
        this.setStyle("-fx-background-color: #F0F8FF;");

        String defaultButtonStyle = "-fx-font-style: italic; -fx-background-color: #FFFFFF;  -fx-font-weight: bold; -fx-font: 11 arial;";
        startButton = new Button("Start Game");
        startButton.setStyle(defaultButtonStyle);

        this.getChildren().add(startButton);
        this.setAlignment(Pos.CENTER);
    }
}

class MainMenuHeader extends HBox {
    MainMenuHeader() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("TicTacToe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class MainMenuFooter extends HBox {
    MainMenuFooter() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("TicTacToe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class MainMenuFrame extends BorderPane {
    private MainMenuHeader header;
    private MainMenuFooter footer;
    private MainMenu menu;

    MainMenuFrame() {
        header = new MainMenuHeader();
        footer = new MainMenuFooter();
        menu = new MainMenu();

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        addListeners();
    }

    public void addListeners() {

    }
}