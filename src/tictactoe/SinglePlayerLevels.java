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
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class SinglePlayerLevels extends AnchorPane {

    protected final ImageView imageView;
    protected final Button easy;
    protected final Button hard;
    protected final Button back;

    public SinglePlayerLevels() {

        imageView = new ImageView();
        easy = new Button();
        
        hard = new Button();
        back = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));
        imageView.setCursor(Cursor.DEFAULT);

        easy.setLayoutX(459.0);
        easy.setLayoutY(402.0);
        easy.setMnemonicParsing(false);
        easy.setPrefHeight(101.0);
        easy.setPrefWidth(385.0);
        easy.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        easy.setText("EASY");
        easy.setFont(new Font("Calibri Bold", 40.0));
        
        easy.setOnAction((Action) -> {
            Panes.ticTacToe.player2.setText("Computer");
            Panes.ticTacToe.isEasy = true;
            Panes.viewPane(Panes.ticTacToe);
        });
        
        

        hard.setLayoutX(74.0);
        hard.setLayoutY(97.0);
        hard.setMnemonicParsing(false);
        hard.setPrefHeight(101.0);
        hard.setPrefWidth(385.0);
        hard.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        hard.setText("HARD");
        hard.setFont(new Font("Calibri Bold", 40.0));

        hard.setOnAction((Action) -> {
            Panes.ticTacToe.player2.setText("Computer");
            Panes.ticTacToe.isEasy = false;
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
        
        back.setOnAction((Action) -> {
            Panes.viewPane(Panes.mainMenu);
        });
        
        getChildren().add(imageView);
        getChildren().add(easy);
        
        getChildren().add(hard);
        getChildren().add(back);

    }
}
