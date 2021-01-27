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

public class MultiplayerOptions extends AnchorPane {

    protected final ImageView imageView;
    protected final Button network;
    protected final Button local;
    protected final Button back;

    public MultiplayerOptions() {

        imageView = new ImageView();
        network = new Button();
        local = new Button();
        back = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));
        imageView.setCursor(Cursor.DEFAULT);

        network.setLayoutX(462.0);
        network.setLayoutY(258.0);
        network.setMnemonicParsing(false);
        network.setPrefHeight(101.0);
        network.setPrefWidth(385.0);
        network.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        network.setText("Network");
        network.setFont(new Font("Calibri Bold", 40.0));
        
        network.setOnAction(Action -> {
            Panes.viewPane(Panes.networkMultiplayerOptions);
        });

        local.setLayoutX(56.0);
        local.setLayoutY(258.0);
        local.setMnemonicParsing(false);
        local.setPrefHeight(101.0);
        local.setPrefWidth(385.0);
        local.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        local.setText("Local");
        local.setFont(new Font("Calibri Bold", 40.0));
        
        local.setOnAction(Action -> {
            Panes.viewPane(Panes.localMultiplayerOptions);
        });
        
        back.setLayoutX(259.0);
        back.setLayoutY(455.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(101.0);
        back.setPrefWidth(385.0);
        back.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        back.setText("BACK");
        back.setFont(new Font("Calibri Bold", 40.0));
        
        back.setOnAction(Action -> {
            Panes.viewPane(Panes.mainMenu);
        });

        getChildren().add(imageView);
        getChildren().add(network);
        getChildren().add(local);
        getChildren().add(back);

    }
}
