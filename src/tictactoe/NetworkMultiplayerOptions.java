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
import java.io.IOException;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class NetworkMultiplayerOptions extends AnchorPane {

    protected final ImageView imageView;
    protected final Button join;
    protected final Button create;
    protected final Button back;

    
    public NetworkMultiplayerOptions() {

        imageView = new ImageView();
        join = new Button();
        create = new Button();
        back = new Button();

        
        setId("AnchorPane");
        setPrefHeight(762.0);
        setPrefWidth(903.0);

        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setCursor(Cursor.DEFAULT);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));

        join.setLayoutX(259.0);
        join.setLayoutY(398.0);
        join.setMnemonicParsing(false);
        join.setPrefHeight(101.0);
        join.setPrefWidth(385.0);
        join.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        join.setText("Join");
        join.setFont(new Font("Calibri Bold", 40.0));

        join.setOnAction(Action -> {
            Panes.ticTacToeMultiplayer.isSinglePlayer = false;
            if(Panes.ticTacToeMultiplayer.connect()){
                Panes.ticTacToeMultiplayer.th = new Thread(Panes.ticTacToeMultiplayer);
                Panes.ticTacToeMultiplayer.th.start();
                Panes.viewPane(Panes.ticTacToeMultiplayer);
            } else {
                Alert NotConnected = new Alert(Alert.AlertType.NONE);
                NotConnected.setAlertType(Alert.AlertType.WARNING);
                NotConnected.setContentText("NO GAMES AVAILABLE TO JOIN");
                NotConnected.show();
            }
        });
        
        create.setLayoutX(259.0);
        create.setLayoutY(240.0);
        create.setMnemonicParsing(false);
        create.setPrefHeight(101.0);
        create.setPrefWidth(385.0);
        create.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        create.setText("Create");
        create.setFont(new Font("Calibri Bold", 40.0));
        
        create.setOnAction(Action -> {
            Panes.ticTacToeMultiplayer.isSinglePlayer = false;
            try {
                Panes.ticTacToeMultiplayer.initServer();
                System.out.println("SERVER INITIALIZED");
            } catch (IOException ex){
                System.err.println("SERVER INITIALIZATION ERROR");
            }
            
            Panes.ticTacToeMultiplayer.th = new Thread(Panes.ticTacToeMultiplayer);
            Panes.ticTacToeMultiplayer.th.start();
            Panes.viewPane(Panes.ticTacToeMultiplayer);
            
        });
        
        
        
        back.setLayoutX(259.0);
        back.setLayoutY(632.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(101.0);
        back.setPrefWidth(385.0);
        back.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        back.setText("BACK");
        back.setFont(new Font("Calibri Bold", 40.0));
        
        back.setOnAction(Action -> {
            Panes.viewPane(Panes.multiPlayer);
        });

        getChildren().add(imageView);
        getChildren().add(join);
        getChildren().add(create);
        getChildren().add(back);


    }
}
