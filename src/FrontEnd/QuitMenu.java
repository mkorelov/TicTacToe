package FrontEnd;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.*;

class QuitMenu extends VBox {
    QuitMenu() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text text = new Text("Are you sure you want to quit? (You will lose all progress)");
        text.setWrappingWidth(300);
        Font font = new Font(19);
        text.setFont(font);

        this.getChildren().addAll(text);
        this.setAlignment(Pos.CENTER);
    }
}

class QuitMenuFooter extends HBox {
    private Button yesButton;
    private Button noButton;

    QuitMenuFooter() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        yesButton = new Button("Yes");
        noButton = new Button("No");

        this.getChildren().addAll(yesButton, noButton);
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }

    Button getYesButton() {
        return this.yesButton;
    }

    Button getNoButton() {
        return this.noButton;
    }
}

class QuitMenuHeader extends HBox {
    QuitMenuHeader() {
        this.setStyle("-fx-background-color: #F0F8FF;");

        Text titleText = new Text("Quit Menu");

        this.getChildren().addAll(titleText);
        this.setAlignment(Pos.CENTER);
    }
}

class QuitMenuFrame extends BorderPane {
    private QuitMenu menu;
    private QuitMenuFooter footer;
    private QuitMenuHeader header;

    private Button yesButton;
    private Button noButton;

    private Stage oldStage;

    QuitMenuFrame(Stage stage) {
        menu = new QuitMenu();
        footer = new QuitMenuFooter();
        header = new QuitMenuHeader();

        oldStage = stage;

        this.setTop(header);
        this.setCenter(menu);
        this.setBottom(footer);

        yesButton = footer.getYesButton();
        noButton = footer.getNoButton();

        addListeners();
    }

    public void addListeners() {
        yesButton.setOnAction(e -> {
            Stage currStage = (Stage) yesButton.getScene().getWindow();
            currStage.close();
            MainMenuFrame root = new MainMenuFrame();
            oldStage.setTitle("Tic-Tac-Toe App");
            oldStage.setScene(new Scene(root, 700, 700));
            oldStage.setResizable(false);
            oldStage.show();
        });

        noButton.setOnAction(e -> {
            Stage currStage = (Stage) noButton.getScene().getWindow();
            currStage.close();
        });
    }
}