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
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class MainMenuFXML extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Button singlePlayer;
    protected final Button multiPlayer;
    protected final Button record;
    protected final Button exit;

    public MainMenuFXML() {

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        singlePlayer = new Button();
        multiPlayer = new Button();
        record = new Button();
        exit = new Button();

        setId("AnchorPane");
        setPrefHeight(762.0);
        setPrefWidth(903.0);

        anchorPane.setPrefHeight(762.0);
        anchorPane.setPrefWidth(903.0);

        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));
        imageView.setCursor(Cursor.DEFAULT);

        singlePlayer.setLayoutX(259.0);
        singlePlayer.setLayoutY(228.0);
        singlePlayer.setMnemonicParsing(false);
        singlePlayer.setPrefHeight(101.0);
        singlePlayer.setPrefWidth(385.0);
        singlePlayer.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        singlePlayer.setText("SINGLE PLAYER");
        singlePlayer.setFont(new Font("Calibri Bold", 40.0));
        
        singlePlayer.setOnAction((Action) -> {
            Panes.viewPane(Panes.singlePlayer);
        });
        
        
        multiPlayer.setLayoutX(259.0);
        multiPlayer.setLayoutY(347.0);
        multiPlayer.setMnemonicParsing(false);
        multiPlayer.setPrefHeight(101.0);
        multiPlayer.setPrefWidth(385.0);
        multiPlayer.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        multiPlayer.setText("MULTIPLAYER");
        multiPlayer.setFont(new Font("Calibri Bold", 40.0));
        multiPlayer.setOnAction(Action ->{
            Panes.ticTacToe.isSinglePlayer = false;
            Panes.viewPane(Panes.multiPlayer);
        });
        

        record.setLayoutX(259.0);
        record.setLayoutY(465.0);
        record.setMnemonicParsing(false);
        record.setPrefHeight(101.0);
        record.setPrefWidth(385.0);
        record.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        record.setText("RECORD");
        record.setFont(new Font("Calibri Bold", 40.0));
        
        record.setOnAction(Action -> {
            if(Panes.record.recordBtns.isEmpty()){
                Alert kekw = new Alert(Alert.AlertType.NONE);
                kekw.setAlertType(Alert.AlertType.WARNING);
                kekw.setContentText("No records available!");
                kekw.show();
            }
            else {
                Panes.viewPane(Panes.record);
            }
        });

        exit.setLayoutX(259.0);
        exit.setLayoutY(583.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(101.0);
        exit.setPrefWidth(385.0);
        exit.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        exit.setText("EXIT");
        exit.setFont(new Font("Calibri Bold", 40.0));
        
        exit.setOnAction(Aciton -> {
            Platform.exit();
        });

        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(singlePlayer);
        anchorPane.getChildren().add(multiPlayer);
        anchorPane.getChildren().add(record);
        anchorPane.getChildren().add(exit);
        getChildren().add(anchorPane);

    }
}
