/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author abdelfatah
 */
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class LocalMultiplayerOptions extends AnchorPane {

    protected final ImageView imageView;
    protected final Button doubleScreens;
    protected final Button oneScreen;
    protected final Button back;

    public LocalMultiplayerOptions() {
        
        imageView = new ImageView();
        doubleScreens = new Button();
        oneScreen = new Button();
        back = new Button();

        setId("AnchorPane");
        setPrefHeight(762.0);
        setPrefWidth(903.0);
        
        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setCursor(Cursor.DEFAULT);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));

        doubleScreens.setLayoutX(459.0);
        doubleScreens.setLayoutY(402.0);
        doubleScreens.setMnemonicParsing(false);
        doubleScreens.setPrefHeight(101.0);
        doubleScreens.setPrefWidth(385.0);
        doubleScreens.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        doubleScreens.setText("Double Screens");
        doubleScreens.setFont(new Font("Calibri Bold", 40.0));
            
        doubleScreens.setOnAction(Action -> {
            Panes.viewPane(Panes.networkMultiplayerOptions);
        });
        
        oneScreen.setLayoutX(74.0);
        oneScreen.setLayoutY(97.0);
        oneScreen.setMnemonicParsing(false);
        oneScreen.setPrefHeight(101.0);
        oneScreen.setPrefWidth(385.0);
        oneScreen.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        oneScreen.setText("One Screen");
        oneScreen.setFont(new Font("Calibri Bold", 40.0));

        oneScreen.setOnAction(Action -> {
            Panes.ticTacToe.player2.setText("Player 2");
            Panes.viewPane(Panes.ticTacToe);
        });
        
        back.setLayoutX(259.0);
        back.setLayoutY(632.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(101.0);
        back.setPrefWidth(385.0);
        back.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        back.setText("BACK");
        back.setFont(new Font("Calibri Bold", 40.0));

        getChildren().add(imageView);
        getChildren().add(doubleScreens);
        getChildren().add(oneScreen);
        getChildren().add(back);

    }
}
