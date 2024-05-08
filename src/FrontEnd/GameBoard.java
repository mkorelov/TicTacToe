package FrontEnd;

import BackEnd.Game;

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

    private Button lt;  // left top box
    private Button mt;  // middle top box
    private Button rt;  // right top box

    private Button lm;  // left middle box
    private Button mm;  // middle middle box
    private Button rm;  // right middle box

    private Button lb;  // left bottom box
    private Button mb;  // middle bottom box
    private Button rb;  // right bottom box

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

        this.getChildren().add(board);
        this.setAlignment(Pos.CENTER);
    }

    Button getLTButton() {
        return this.lt;
    }

    Button getMTButton() {
        return this.mt;
    }

    Button getRTButton() {
        return this.rt;
    }

    Button getLMButton() {
        return this.lm;
    }

    Button getMMButton() {
        return this.mm;
    }

    Button getRMButton() {
        return this.rm;
    }

    Button getLBButton() {
        return this.lb;
    }

    Button getMBButton() {
        return this.mb;
    }

    Button getRBButton() {
        return this.rb;
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

    private Game game;

    private Button lt;
    private Button mt;
    private Button rt;
    private Button lm;
    private Button mm;
    private Button rm;
    private Button lb;
    private Button mb;
    private Button rb;

    GameBoardFrame() {
        header = new GameBoardHeader();
        footer = new GameBoardFooter();
        board = new GameBoard();

        this.setTop(header);
        this.setCenter(board);
        this.setBottom(footer);

        game = new Game();

        lt = board.getLTButton();
        mt = board.getMTButton();
        rt = board.getRTButton();
        lm = board.getLMButton();
        mm = board.getMMButton();
        rm = board.getRMButton();
        lb = board.getLBButton();
        mb = board.getMBButton();
        rb = board.getRBButton();

        addListeners();
    }

    public void addListeners() {
        lt.setOnAction(e -> {
            lt.setText(game.move(0));
        });

        mt.setOnAction(e -> {
            mt.setText(game.move(1));
        });

        rt.setOnAction(e -> {
            rt.setText(game.move(2));
        });

        lm.setOnAction(e -> {
            lm.setText(game.move(3));
        });

        mm.setOnAction(e -> {
            mm.setText(game.move(4));
        });

        rm.setOnAction(e -> {
            rm.setText(game.move(5));
        });

        lb.setOnAction(e -> {
            lb.setText(game.move(6));
        });

        mb.setOnAction(e -> {
            mb.setText(game.move(7));
        });
        
        rb.setOnAction(e -> {
            rb.setText(game.move(8));
        });
    }
}
