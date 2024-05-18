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

class RuleMenu extends VBox {
    RuleMenu() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text titleText = new Text("Here are the rules of Tic-Tac-Toe");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");

        Text firstRule = new Text("1. Take turns ... ");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");

        this.getChildren().addAll(titleText, firstRule);
        //this.setAlignment(Pos.CENTER);
    }
}

class RuleMenuHeader extends HBox {
    RuleMenuHeader() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Rule Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class RuleMenuFooter extends HBox {
    private Button backButton;

    RuleMenuFooter() {
        this.setPrefSize(300, 200);
        this.setStyle("-fx-background-color: #F0F8FF;");

        backButton = new Button("Back");

        this.getChildren().addAll(backButton);
        this.setAlignment(Pos.CENTER);
    }

    Button getBackButton() {
        return this.backButton;
    }
}

class RuleMenuFrame extends BorderPane {
    private RuleMenuHeader header;
    private RuleMenuFooter footer;
    private RuleMenu menu;

    private Stage oldStage;

    private Button backButton;

    RuleMenuFrame(Stage stage) {
        header = new RuleMenuHeader();
        footer = new RuleMenuFooter();
        menu = new RuleMenu();

        oldStage = stage;

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        backButton = footer.getBackButton();

        addListeners();
    }  

    void addListeners() {
        backButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            currStage.close();
        });
    }
}