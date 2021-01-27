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
import Database.dbFunctions;
import java.util.Vector;
import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class NamingOption extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final Button exit;
    protected final Button name;
    protected final Button id;
    protected final TextField nameTextField;
    protected final TextField idTextField;
    protected final Button enter;

    public boolean isNew;
    dbFunctions dbFunction = new dbFunctions();
    String playerName;
    int count = 0;
    int playerId;
    Vector<String> Records = new Vector<>();

    public NamingOption() {

        anchorPane = new AnchorPane();
        imageView = new ImageView();
        exit = new Button();
        name = new Button();
        id = new Button();
        nameTextField = new TextField();
        idTextField = new TextField();
        enter = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        anchorPane.setId("AnchorPane");
        anchorPane.setPrefHeight(762.0);
        anchorPane.setPrefWidth(903.0);

        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));
        imageView.setCursor(Cursor.DEFAULT);

        exit.setLayoutX(259.0);
        exit.setLayoutY(632.0);
        exit.setMnemonicParsing(false);
        exit.setPrefHeight(101.0);
        exit.setPrefWidth(385.0);
        exit.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        exit.setText("EXIT");
        exit.setFont(new Font("Calibri Bold", 40.0));

        exit.setOnAction((Action) -> {
            Platform.exit();
        });

        name.setLayoutX(201.0);
        name.setLayoutY(280.0);
        name.setMnemonicParsing(false);
        name.setPrefHeight(66.0);
        name.setPrefWidth(176.0);
        name.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        name.setText("NAME");
        name.setFont(new Font("Calibri Bold", 40.0));

        id.setLayoutX(201.0);
        id.setLayoutY(372.0);
        id.setMnemonicParsing(false);
        id.setPrefHeight(66.0);
        id.setPrefWidth(176.0);
        id.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        id.setText("ID");
        id.setFont(new Font("Calibri Bold", 40.0));

        nameTextField.setLayoutX(413.0);
        nameTextField.setLayoutY(280.0);
        nameTextField.setPrefHeight(74.0);
        nameTextField.setPrefWidth(289.0);

        idTextField.setLayoutX(413.0);
        idTextField.setLayoutY(372.0);
        idTextField.setPrefHeight(74.0);
        idTextField.setPrefWidth(289.0);

        enter.setLayoutX(259.0);
        enter.setLayoutY(513.0);
        enter.setMnemonicParsing(false);
        enter.setPrefHeight(101.0);
        enter.setPrefWidth(385.0);
        enter.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        enter.setText("ENTER");
        enter.setFont(new Font("Calibri Bold", 40.0));

        enter.setOnAction((Action) -> {
            if (isNew) {
                String name = nameTextField.getText();
                if (name.equals("")) {
                    Alert al = new Alert(Alert.AlertType.NONE);
                    al.setAlertType(Alert.AlertType.WARNING);
                    al.setContentText("USER NAME IS EMPTY");
                    al.show();
                } else {
                    count++;
                    if (idTextField.getText().isEmpty() && count == 1) {
                        playerName = nameTextField.getText();
                        playerId = dbFunction.insertPlayer(playerName);
                        idTextField.setText(Integer.toString(playerId));
                    } else {
                        Panes.record.playerName1 = playerName;
                        Panes.record.playerId1 = playerId;
                        Panes.ticTacToeMultiplayer.playerName = playerName;
                        Panes.ticTacToeMultiplayer.playerId = playerId;
                        Panes.ticTacToe.playerName = playerName;
                        Panes.ticTacToe.playerId = playerId;
                        Panes.ticTacToe.player1.setText(nameTextField.getText());
                        Panes.ticTacToe.player1Score.setText("0");

                        Panes.viewPane(Panes.mainMenu);
                    }
                }
            } else {
                playerName = nameTextField.getText();
                
                try {
                    playerId = Integer.parseInt(idTextField.getText());
                } catch(NumberFormatException NOE){
                    NOE.getMessage();
                }
                
                if(dbFunction.check(playerName, playerId)){
                    Record record = new Record();
                    Records = dbFunction.returnAllGames(playerId);
                    
                    for(int i = 0 ; i < Records.size(); i++){
                        Panes.record.addRecord(Records.get(i));
                    }
                    
                    Panes.ticTacToe.playerName = playerName;
                    Panes.ticTacToe.playerId = playerId;
                    Panes.ticTacToeMultiplayer.playerName = playerName;
                    Panes.ticTacToeMultiplayer.playerId = playerId;
                    Panes.record.playerName1 = playerName;
                    Panes.record.playerId1 = playerId;
                    Panes.ticTacToe.player1.setText(nameTextField.getText());
                    Panes.ticTacToe.player1Score.setText("0");
                    
                    Panes.viewPane(Panes.mainMenu);
                } else {
                    Alert NOMATCH = new Alert(Alert.AlertType.NONE);
                    NOMATCH.setAlertType(Alert.AlertType.WARNING);
                    NOMATCH.setContentText("WE don't have a match for you in our database! Login as new player..");
                    NOMATCH.show();
                }
            }
        });

        getChildren().add(anchorPane);
        getChildren().add(imageView);
        getChildren().add(exit);
        getChildren().add(name);
        getChildren().add(id);
        getChildren().add(nameTextField);
        getChildren().add(idTextField);
        getChildren().add(enter);

    }
}
