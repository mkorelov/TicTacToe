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

class GameOverMenu extends VBox{
    // based on result show different text, player 1 win , player 2 win , or draw
    // allow for rematch or return to main menu
    GameOverMenu() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text text = new Text("Draw, Player 1 Wins, or Player 2 Wins");
        text.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(text);
        this.setAlignment(Pos.CENTER);
    }
}

class GameOverHeader extends HBox {
    GameOverHeader() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Game Over Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class GameOverFooter extends HBox{
    private Button playButton;
    private Button backButton;

    GameOverFooter() {
        this.setPrefSize(300, 200);
        this.setStyle("-fx-background-color: #F0F8FF;");

        playButton = new Button("Play Again");
        backButton = new Button("Back");

        this.getChildren().addAll(backButton, playButton);
        this.setAlignment(Pos.CENTER);
    }

    Button getPlayButton() {
        return this.playButton;
    }

    Button getBackButton() {
        return this.backButton;
    }
}

class GameOverFrame extends BorderPane {
    private GameOverMenu menu;
    private GameOverHeader header;
    private GameOverFooter footer;

    private Button playButton;
    private Button backButton;

    GameOverFrame() {
        menu = new GameOverMenu();
        header = new GameOverHeader();
        footer = new GameOverFooter();

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        playButton = footer.getPlayButton();
        backButton = footer.getBackButton();

        addListeners();
    }

    public void addListeners() {
        playButton.setOnAction(e -> {
            
        });

        backButton.setOnAction(e -> {
            
        });
    }
}