///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:    Main.java
// File:               GameBoard.java
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

/**
 * This class contains the components in the center of the Game Board screen.
 * The instance variables are 9 buttons that are organized in a 3x3 grid.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
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

    /**
     * The default constructor of the center component of the Game Board 
     * screen.
     */
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

        // creates game board with 9 buttons organize in a 3x3 grid
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

    /**
     * Getter method for the top left button.
     *
     * @return Returns the top left button from the grid.
     */
    Button getLTButton() {
        return this.lt;
    }

    /**
     * Getter method for the top middle button.
     *
     * @return Returns the top middle button from the grid.
     */
    Button getMTButton() {
        return this.mt;
    }

    /**
     * Getter method for the top right button.
     *
     * @return Returns the top right button from the grid.
     */
    Button getRTButton() {
        return this.rt;
    }

    /**
     * Getter method for the middle left button.
     *
     * @return Returns the middle left button from the grid.
     */
    Button getLMButton() {
        return this.lm;
    }

    /**
     * Getter method for the center button.
     *
     * @return Returns the center button from the grid.
     */
    Button getMMButton() {
        return this.mm;
    }

    /**
     * Getter method for the middle right button.
     *
     * @return Returns the middle right button from the grid.
     */
    Button getRMButton() {
        return this.rm;
    }

    /**
     * Getter method for the bottom left button.
     *
     * @return Returns the bottom left button from the grid.
     */
    Button getLBButton() {
        return this.lb;
    }

    /**
     * Getter method for the bottom middle button.
     *
     * @return Returns the bottom middle button from the grid.
     */
    Button getMBButton() {
        return this.mb;
    }

    /**
     * Getter method for the bottom right button.
     *
     * @return Returns the bottom right button from the grid.
     */
    Button getRBButton() {
        return this.rb;
    }
}

/**
 * This class contains the components at the top of the Game Board screen.
 * The only instance variable is a button that will cause the game to pause.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class GameBoardHeader extends HBox {
    private Button pauseButton;

    /**
     * The default constructor of the top component of the Game Board 
     * screen.
     */
    GameBoardHeader() {
        this.setPrefSize(800, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");

        // creates a button with an uploaded image instead of text
        String path = "src/pausebutton.png";
        Image image = new Image(new File(path).toURI().toString());
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

    /**
     * Getter method for the pause button.
     *
     * @return Returns the pause button from the top of the Game Board screen.
     */
    Button getPauseButton() {
        return this.pauseButton;
    }
}

/**
 * This class contains the components at the bottom of the Game Board screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
class GameBoardFooter extends HBox {

    /**
     * The default constructor of the bottom component of the Game Board 
     * screen.
     */
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

/**
 * This class combines all the components of the Game Board screen. It has
 * all the same instance variables as the other classes, but also an 
 * additional one for the game logic and each individual component of the 
 * screen.
 *
 * Bugs: N/A
 *
 * @author Michael Korelov
 */
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

    /**
     * The default constructor of the entire Game Board screen.
     */
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

    /**
     * Performs a response after a button is clicked on the Game Board screen.
     * When a button on the grid is clicked it is updated with either a "X" or 
     * an "O", unless it already has been clicked. There is also a pause button
     * that will open a new menu when clicked.
     */
    void addListeners() {
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