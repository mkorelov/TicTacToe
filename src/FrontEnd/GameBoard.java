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

class GameBoard extends VBox {  
    GameBoard() {
        this.setPrefSize(800, 750);
        this.setStyle("-fx-background-color: #F0F8FF;");
    }
}

class GameBoardHeader extends HBox {
    private Button pauseButton;

    GameBoardHeader() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        pauseButton = new Button("Pause");
        Text titleText = new Text("Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().addAll(titleText, pauseButton);
        this.setAlignment(Pos.CENTER);
    }
}

class GameBoardFooter extends HBox {
    GameBoardFooter() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class GameBoardFrame extends BorderPane {
    private GameBoardHeader header;
    private GameBoardFooter footer;
    private GameBoard board;

    GameBoardFrame() {
        header = new GameBoardHeader();
        footer = new GameBoardFooter();
        board = new GameBoard();

        this.setTop(header);
        this.setCenter(board);
        this.setBottom(footer);

        addListeners();
    }

    public void addListeners() {

    }
}
