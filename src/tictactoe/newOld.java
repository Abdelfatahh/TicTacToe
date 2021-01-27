package tictactoe;

import javafx.scene.image.*;
import javafx.scene.text.*;
import java.lang.*;
import java.util.*;
import javafx.application.Platform;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class newOld extends AnchorPane {

    protected final ImageView imageView;
    protected final Button exit;
    protected final Button newPlayer;
    protected final Button oldPlayer;

    public newOld() {

        imageView = new ImageView();
        exit = new Button();
        newPlayer = new Button();
        oldPlayer = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setLayoutX(10.0);
        imageView.setLayoutY(10.0);
        imageView.setCursor(Cursor.DEFAULT);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));

        exit.setLayoutX(269.0);
        exit.setLayoutY(465.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(101.0);
        exit.setPrefWidth(385.0);
        exit.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        exit.setText("EXIT");
        exit.setFont(new Font("Calibri Bold", 40.0));

        newPlayer.setLayoutX(66.0);
        newPlayer.setLayoutY(268.0);
        newPlayer.setMnemonicParsing(false);
        newPlayer.setPrefHeight(101.0);
        newPlayer.setPrefWidth(385.0);
        newPlayer.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        newPlayer.setText("NEW PLAYER");
        newPlayer.setFont(new Font("Calibri Bold", 40.0));

        oldPlayer.setLayoutX(472.0);
        oldPlayer.setLayoutY(268.0);
        oldPlayer.setMnemonicParsing(false);
        oldPlayer.setPrefHeight(101.0);
        oldPlayer.setPrefWidth(385.0);
        oldPlayer.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        oldPlayer.setText("OLD PLAYER");
        oldPlayer.setFont(new Font("Calibri Bold", 40.0));

        getChildren().add(imageView);
        getChildren().add(exit);
        getChildren().add(newPlayer);
        getChildren().add(oldPlayer);

        
        newPlayer.setOnAction(Action -> {
            Panes.namingOption.isNew = true;
            Panes.namingOption.idTextField.setEditable(false);
            Panes.viewPane(Panes.namingOption);
        });
        
        oldPlayer.setOnAction(Action -> {
            Panes.namingOption.isNew = false;
            Panes.namingOption.idTextField.setEditable(true);
            Panes.viewPane(Panes.namingOption);
        });
        
        exit.setOnAction(Action -> {
            Platform.exit();
        });
    }
}
