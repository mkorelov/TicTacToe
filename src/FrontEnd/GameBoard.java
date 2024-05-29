///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    (name of main application class)
// File:               (name of this class's file)
// Quarter:            (course) Spring 2020
//
// Author:             (your name and email address)
// Instructor's Name:  (name of your instructor)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       (name of your pair programming partner)
// Email:              (email address of your programming partner)
// Instructor's Name:  (name of your partner's instructor)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   Avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

package FrontEnd;

import BackEnd.Game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

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

        Image image = new Image(new File("src/pausebutton.png").toURI().toString());
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(20);
        imageView.setFitHeight(20);
        pauseButton = new Button();
        pauseButton.setGraphic(imageView);

        pauseButton.setPrefHeight(50);
        pauseButton.setPrefWidth(50);


        Text titleText = new Text("Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().addAll(titleText, pauseButton);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    Button getPauseButton() {
        return this.pauseButton;
    }
}

class GameBoardFooter extends HBox {
    GameBoardFooter() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        TextField player1 = new TextField("Player 1 (X)");
        TextField player2 = new TextField("Player 2 (O)");
        Text score = new Text("0 - 0");
        score.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().addAll(player1, score, player2);
        this.setSpacing(50);
        this.setAlignment(Pos.CENTER);
    }
}

class GameBoardFrame extends BorderPane {
    private GameBoardHeader header;
    private GameBoardFooter footer;
    private GameBoard board;

    private Game game;

    private Button pauseButton;

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

        pauseButton = header.getPauseButton();

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
        pauseButton.setOnAction(e -> {
            Stage currStage = (Stage) pauseButton.getScene().getWindow();
            Stage newStage = new Stage();
            PauseMenuFrame root = new PauseMenuFrame(currStage);
            newStage.setTitle("Tic-Tac-Toe App");
            newStage.setScene(new Scene(root, 300, 300));
            newStage.setResizable(false);
            newStage.show();
        });

        lt.setOnAction(e -> {
            String str = game.move(0);
            if (!str.equals("")) {
                lt.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });

        mt.setOnAction(e -> {
            String str = game.move(1);
            if (!str.equals("")) {
                mt.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });

        rt.setOnAction(e -> {
            String str = game.move(2);
            if (!str.equals("")) {
                rt.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });

        lm.setOnAction(e -> {
            String str = game.move(3);
            if (!str.equals("")) {
                lm.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });

        mm.setOnAction(e -> {
            String str = game.move(4);
            if (!str.equals("")) {
                mm.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });

        rm.setOnAction(e -> {
            String str = game.move(5);
            if (!str.equals("")) {
                rm.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });

        lb.setOnAction(e -> {
            String str = game.move(6);
            if (!str.equals("")) {
                lb.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });

        mb.setOnAction(e -> {
            String str = game.move(7);
            if (!str.equals("")) {
                mb.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });
        
        rb.setOnAction(e -> {
            String str = game.move(8);
            if (!str.equals("")) {
                rb.setText(str);
            }
            if (game.gameOver() == true) {
                Stage currStage = (Stage) lt.getScene().getWindow();
                GameOverFrame root = new GameOverFrame(game.getWinner());
                currStage.setTitle("Tic-Tac-Toe App");
                currStage.setScene(new Scene(root, 700, 700));
                currStage.setResizable(false);
                currStage.show();
            }
        });
    }
}