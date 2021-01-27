package tictactoe;

import Database.dbFunctions;
import javafx.scene.image.*;
import javafx.scene.text.*;
import java.lang.*;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import tictactoe.Panes;

public class Record extends AnchorPane {
    
    protected final ImageView imageView;
    protected final Pane pane;
    protected final Button back;
    protected final ScrollPane scrollPane;
    protected final VBox vBox;
    protected final Button button0;
    protected Button record;
    public int playerId1;
    public String playerName1;
    
    protected Vector<Button> recordBtns = new Vector<>();
    dbFunctions theGame = new dbFunctions();
    
    public Record() {
        
        imageView = new ImageView();
        pane = new Pane();
        back = new Button();
        scrollPane = new ScrollPane();
        vBox = new VBox();
        button0 = new Button();
        
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        
        imageView.setFitHeight(762.0);
        imageView.setFitWidth(903.0);
        imageView.setLayoutX(10.0);
        imageView.setLayoutY(10.0);
        imageView.setCursor(Cursor.DEFAULT);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));
        
        pane.setPrefHeight(772.0);
        pane.setPrefWidth(913.0);
        
        back.setLayoutX(60.0);
        back.setLayoutY(601.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(66.0);
        back.setPrefWidth(184.0);
        back.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        back.setText("BACK");
        back.setFont(new Font("Calibri Bold", 40.0));
        
        scrollPane.setLayoutX(396.0);
        scrollPane.setLayoutY(227.0);
        scrollPane.setPrefHeight(382.0);
        scrollPane.setPrefWidth(380.0);
        
        vBox.setPrefHeight(400.0);
        vBox.setPrefWidth(380.0);
        
        scrollPane.setContent(vBox);
        
        getChildren().add(imageView);
        pane.getChildren().add(back);
        vBox.getChildren().add(button0);
        pane.getChildren().add(scrollPane);
        getChildren().add(pane);
        
        back.setOnAction(Action -> {
            Panes.viewPane(Panes.mainMenu);
        });
        
    }
    
    public void addRecord(String r) {
        record = new Button();
        record.setId("record");
        record.setMnemonicParsing(false);
        scrollPane.setLayoutX(420.0);
        scrollPane.setLayoutY(227.0);
        record.setPrefWidth(420.0);
        record.setPrefHeight(66.0);
        record.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand; fx-padding: 5px; fx-border-insets: 5px;-fx-background-insets: 5px;");
        record.setText(r);
        recordBtns.add(record);
        addActiontoButtons();
        vBox.getChildren().add(record);
        
    }
    
    public void addActiontoButtons() {
        
        for (Button recordBtn : recordBtns) {
            recordBtn.addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });
        }
        
    }
    
    public void actionPerformed(ActionEvent e) {
        Button clickedButton = (Button) e.getSource();
        String X = clickedButton.getText();
        String[] DATE_NAME = X.split("     ");
        Panes.ticTacToeRecords.moves = theGame.returnGame(DATE_NAME[1], playerId1, DATE_NAME[0]);
        Panes.ticTacToeRecords.playername2 = DATE_NAME[0];
        Panes.ticTacToeRecords.playername1 = playerName1;
        Panes.viewPane(Panes.ticTacToeRecords);
    }
    
    
    
}
