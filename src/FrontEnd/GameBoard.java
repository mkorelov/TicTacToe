package FrontEnd;

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
import javafx.geometry.Insets;
import javafx.scene.text.*;

class GameBoard extends VBox {
    private GridPane board;

    private Button lt;
    private Button mt;
    private Button rt;

    private Button lm;
    private Button mm;
    private Button rm;

    private Button lb;
    private Button mb;
    private Button rb;

    GameBoard() {
        this.setPrefSize(800, 750);
        this.setStyle("-fx-background-color: #F0F8FF;");

        lt = new Button();
        lt.setPrefHeight(100);
        lt.setPrefWidth(100);

        mt = new Button();
        mt.setPrefHeight(100);
        mt.setPrefWidth(100);

        rt = new Button();
        rt.setPrefHeight(100);
        rt.setPrefWidth(100);

        lm = new Button();
        lm.setPrefHeight(100);
        lm.setPrefWidth(100);

        mm = new Button();
        mm.setPrefHeight(100);
        mm.setPrefWidth(100);

        rm = new Button();
        rm.setPrefHeight(100);
        rm.setPrefWidth(100);

        lb = new Button();
        lb.setPrefHeight(100);
        lb.setPrefWidth(100);

        mb = new Button();
        mb.setPrefHeight(100);
        mb.setPrefWidth(100);

        rb = new Button();
        rb.setPrefHeight(100);
        rb.setPrefWidth(100);

        board = new GridPane();
        board.getColumnConstraints().add(new ColumnConstraints(100));
        board.getColumnConstraints().add(new ColumnConstraints(100));
        board.getColumnConstraints().add(new ColumnConstraints(100));
        board.getRowConstraints().add(new RowConstraints(100));
        board.getRowConstraints().add(new RowConstraints(100));
        board.getRowConstraints().add(new RowConstraints(100));

        board.setPrefWidth(500);
        board.setPrefHeight(500);

        board.add(lt, 0, 0);
        board.add(mt, 1, 0);
        board.add(rt, 2, 0);
        board.add(lm, 0, 1);
        board.add(mm, 1, 1);
        board.add(rm, 2, 1);
        board.add(lb, 0, 2);
        board.add(mb, 1, 2);
        board.add(rb, 2, 2);

        board.setAlignment(Pos.CENTER);

        //board.getChildren().addAll(lt, mt, rt, lm, mm, rm, lb, mb, rb);

        this.getChildren().add(board);
        this.setAlignment(Pos.CENTER);
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
