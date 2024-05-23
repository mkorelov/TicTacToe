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

// represents a saved game
class Load extends HBox implements Comparable<Object> {
    // variable that has time stamp
    // add a selection feature to select a saved game and load it
    Load() {

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

class LoadMenu extends VBox {
    LoadMenu() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text titleText = new Text("Eventually replace with a list of games to load from");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");

        this.getChildren().addAll(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class LoadMenuHeader extends HBox {
    LoadMenuHeader() {
        this.setPrefSize(300, 50);
        this.setStyle("-fx-background-color: #F0F8FF;");
        Text titleText = new Text("Load Menu");
        titleText.setStyle("-fx-font-weight: bold; -fx-font-size: 20;");
        this.getChildren().add(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class LoadMenuFooter extends HBox {
    private Button backButton;

    LoadMenuFooter() {
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

class LoadMenuFrame extends BorderPane {
    private LoadMenuHeader header;
    private LoadMenuFooter footer;
    private LoadMenu menu;
    private ScrollPane scrollbar;

    private Button backButton;

    LoadMenuFrame() {
        header = new LoadMenuHeader();
        footer = new LoadMenuFooter();
        menu = new LoadMenu();

        scrollbar = new ScrollPane(menu);
        scrollbar.setFitToWidth(true);
        scrollbar.setFitToHeight(true);

        this.setTop(header);
        this.setCenter(scrollbar);
        this.setBottom(footer);

        backButton = footer.getBackButton();

        addListeners();
    }  

    void addListeners() {
        backButton.setOnAction(e -> {
            Stage currStage = (Stage) backButton.getScene().getWindow();
            MainMenuFrame root = new MainMenuFrame();
            currStage.setTitle("Tic-Tac-Toe App");
            currStage.setScene(new Scene(root, 700, 700));
            currStage.setResizable(false);
            currStage.show();
        });
    }
}