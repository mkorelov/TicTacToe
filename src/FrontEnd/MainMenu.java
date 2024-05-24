package FrontEnd;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;

class MainMenu extends VBox {
    private Button startButton;
    private Button ruleButton;

    MainMenu() {
        this.setPrefSize(800, 750);
        this.setStyle("-fx-background-color: #F0F8FF;");
        
        Image image = new Image(new File("src/playbutton.png").toURI().toString());
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(280);
        imageView.setFitHeight(280);
        startButton = new Button();
        startButton.setGraphic(imageView);

        startButton.setPrefHeight(300);
        startButton.setPrefWidth(300);

        ruleButton = new Button("Rules");
        ruleButton.setPrefHeight(50);
        ruleButton.setPrefWidth(300);
        Font font = new Font(25);
        ruleButton.setFont(font);

        this.getChildren().addAll(startButton, ruleButton);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    Button getStartButton() {
        return this.startButton;
    }

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
    private Button ruleButton;

    MainMenuFrame() {
        header = new MainMenuHeader();
        footer = new MainMenuFooter();
        menu = new MainMenu();

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        startButton = menu.getStartButton();
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