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
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class TicTacToeGame extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Pane pane;
    protected final Button btn0;
    protected final Button btn1;
    protected final Button btn2;
    protected final Button btn3;
    protected final Button btn4;
    protected final Button btn5;
    protected final Button btn6;
    protected final Button btn7;
    protected final Button btn8;
    protected final Label player1;
    protected final Label player2;
    protected final Label player1Score;
    protected final Label player2Score;
    protected final Button newGame;
    protected final Button record;
    protected final Button back;
    protected final Label turnPlayer;

    public boolean isSinglePlayer =true ;
    protected String playerName;
    protected int playerId;
    public boolean isYourTurn = true;
    public volatile boolean isGameOver;
    public Button[] btns;

    public boolean isEasy =true;

    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    // database  ***********************************
    dbFunctions recordGame = new dbFunctions();
    static public int j = 0;
    public String[] btnsID;
    public boolean isRecording = false;
    protected int playerscore;
    // database ************************************
    
    Image win = new Image("/tictactoe/win.gif");
    ImageView imageView = new ImageView();

    Random random = new Random();
    public int randomNumber;

    public int gameCounter = 0;

    public TicTacToeGame() {

        anchorPane = new AnchorPane();
        pane = new Pane();
        btn0 = new Button();
        btn1 = new Button();
        btn2 = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn7 = new Button();
        btn8 = new Button();
        player1 = new Label();
        player2 = new Label();
        player1Score = new Label();
        player2Score = new Label();
        newGame = new Button();
        record = new Button();
        back = new Button();
        turnPlayer = new Label();

        setId("AnchorPane");
        setPrefHeight(762.0);
        setPrefWidth(903.0);

        anchorPane.setPrefHeight(762.0);
        anchorPane.setPrefWidth(903.0);
        anchorPane.setStyle("-fx-background-color: BLACK;");

        pane.setLayoutX(215.0);
        pane.setLayoutY(24.0);
        pane.setPrefHeight(470.0);
        pane.setPrefWidth(488.0);
        pane.setStyle("-fx-background-color: #ffC600;");

        btn0.setLayoutY(-7.0);
        btn0.setMnemonicParsing(false);
        btn0.setPrefHeight(159.0);
        btn0.setPrefWidth(164.0);
        btn0.setStyle("-fx-background-color: black;");

        btn1.setLayoutX(166.0);
        btn1.setLayoutY(-7.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(159.0);
        btn1.setPrefWidth(164.0);
        btn1.setStyle("-fx-background-color: black;");

        btn2.setLayoutX(333.0);
        btn2.setLayoutY(-7.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(159.0);
        btn2.setPrefWidth(164.0);
        btn2.setStyle("-fx-background-color: black;");

        btn3.setLayoutY(156.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(159.0);
        btn3.setPrefWidth(164.0);
        btn3.setStyle("-fx-background-color: black;");

        btn4.setLayoutX(167.0);
        btn4.setLayoutY(156.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(159.0);
        btn4.setPrefWidth(164.0);
        btn4.setStyle("-fx-background-color: black;");

        btn5.setLayoutX(333.0);
        btn5.setLayoutY(156.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(159.0);
        btn5.setPrefWidth(164.0);
        btn5.setStyle("-fx-background-color: black;");

        btn6.setLayoutY(318.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(159.0);
        btn6.setPrefWidth(164.0);
        btn6.setStyle("-fx-background-color: black;");

        btn7.setLayoutX(166.0);
        btn7.setLayoutY(318.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(159.0);
        btn7.setPrefWidth(164.0);
        btn7.setStyle("-fx-background-color: black;");

        btn8.setLayoutX(333.0);
        btn8.setLayoutY(318.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(159.0);
        btn8.setPrefWidth(164.0);
        btn8.setStyle("-fx-background-color: black;");

        btns = new Button[]{btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8};
        btnsID = new String[9];
        
        for(int i = 0 ; i < 9 ; i++){
            btns[i].setId(Integer.toString(i));
        }
        
        player1.setLayoutX(30.0);
        player1.setLayoutY(226.0);
        player1.setPrefHeight(45.0);
        player1.setPrefWidth(135.0);
        player1.setText("Player 1 ");
        player1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player1.setTextFill(javafx.scene.paint.Color.valueOf("#ffc600"));
        player1.setFont(new Font("Segoe UI Black", 14.0));

        player2.setLayoutX(732.0);
        player2.setLayoutY(226.0);
        player2.setPrefHeight(45.0);
        player2.setPrefWidth(145.0);
        player2.setText("Player 2 ");
        player2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2.setTextFill(javafx.scene.paint.Color.valueOf("#ff0000b5"));
        player2.setFont(new Font("Segoe UI Black", 14.0));
        

        player1Score.setLayoutX(30.0);
        player1Score.setLayoutY(271.0);
        player1Score.setPrefHeight(45.0);
        player1Score.setPrefWidth(135.0);
        player1Score.setText("0");
        player1Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player1Score.setTextFill(javafx.scene.paint.Color.valueOf("#ffc600"));
        player1Score.setFont(new Font("Segoe UI Black", 25.0));

        player2Score.setLayoutX(732.0);
        player2Score.setLayoutY(271.0);
        player2Score.setPrefHeight(45.0);
        player2Score.setPrefWidth(135.0);
        player2Score.setText("0");
        player2Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        player2Score.setTextFill(javafx.scene.paint.Color.valueOf("#ff0000c6"));
        player2Score.setFont(new Font("Segoe UI Black", 25.0));

        newGame.setLayoutX(357.0);
        newGame.setLayoutY(570.0);
        newGame.setMnemonicParsing(false);
        newGame.setPrefHeight(45.0);
        newGame.setPrefWidth(204.0);
        newGame.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        newGame.setText("NEW GAME");
        newGame.setFont(new Font("Calibri Bold", 30.0));

        record.setLayoutX(357.0);
        record.setLayoutY(632.0);
        record.setMnemonicParsing(false);
        record.setPrefHeight(55.0);
        record.setPrefWidth(204.0);
        record.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        record.setText("RECORD");
        record.setFont(new Font("Calibri Bold", 30.0));

        back.setLayoutX(357.0);
        back.setLayoutY(693.0);
        back.setMnemonicParsing(false);
        back.setPrefHeight(45.0);
        back.setPrefWidth(204.0);
        back.setStyle("-fx-background-color: #FFC600; -fx-cursor: hand;");
        back.setText("BACK");
        back.setFont(new Font("Calibri Bold", 30.0));

        turnPlayer.setLayoutX(384.0);
        turnPlayer.setLayoutY(510.0);
        turnPlayer.setPrefHeight(45.0);
        turnPlayer.setPrefWidth(135.0);
        turnPlayer.setText("O");
        turnPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        turnPlayer.setTextFill(javafx.scene.paint.Color.valueOf("#ffc600"));
        turnPlayer.setFont(new Font("Segoe UI Black", 32.0));

        pane.getChildren().add(btn0);
        pane.getChildren().add(btn1);
        pane.getChildren().add(btn2);
        pane.getChildren().add(btn3);
        pane.getChildren().add(btn4);
        pane.getChildren().add(btn5);
        pane.getChildren().add(btn6);
        pane.getChildren().add(btn7);
        pane.getChildren().add(btn8);
        anchorPane.getChildren().add(pane);
        anchorPane.getChildren().add(player1);
        anchorPane.getChildren().add(player2);
        anchorPane.getChildren().add(player1Score);
        anchorPane.getChildren().add(player2Score);
        anchorPane.getChildren().add(newGame);
        anchorPane.getChildren().add(record);
        anchorPane.getChildren().add(back);
        anchorPane.getChildren().add(turnPlayer);
        getChildren().add(anchorPane);

        addActiontoButton();

        startGame();

        newGame.setOnAction((Action) -> {
            startGame();
            
        });
        
        record.setOnAction(Action -> {
            isRecording = true;
            startGame();
        });
        
        back.setOnAction(Action -> {
            for(int i = 0 ; i < 9 ; i++){
                btns[i].setText("");
                btns[i].setStyle("-fx-background-color: black; -fx-font-size: 46px; -fx-text-fill: white");
            }
            player1Score.setText("0");
            player2Score.setText("0");
            if(isSinglePlayer){
                Panes.viewPane(Panes.singlePlayer);
            } else {
                Panes.viewPane(Panes.localMultiplayerOptions);
            }
        });
    }
    
    private void storeGame(){
        String nameWithDate = recordGame.recordGame(playerId, player2.getText(), btnsID);
        Panes.record.addRecord(nameWithDate);
        isRecording = false;
    }
    
    private void addActiontoButton() {
        for (int i = 0; i < 9; i++) {
            btns[i].addEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });
           System.out.println("I c U");
        }
    }

    private void startGame() {

        gameCounter = 0;
        isGameOver = false;
        j = 0;

        setPlayerTurn();

        for( int i =0 ; i < 9; i++ ) {
                btns[i].setText("");
                btns[i].setStyle("-fx-background-color: black; -fx-font-size: 46px; -fx-text-fill: white");
                
                btnsID[i] = null;
            }

    }

    private void setPlayerTurn() {
        if (isYourTurn == true) {
            turnPlayer.setText("X");
        } else {
            turnPlayer.setText("O");
        }
    }

    
    
    private void actionPerformed(ActionEvent e) {

        Button clickedButton = (Button) e.getSource();

        if (isGameOver == false && clickedButton.getText().equals("")) {
            if (isSinglePlayer == false) {
                if (isYourTurn) {
                    clickedButton.setText("X");
                    checkIfGameOver();
                    if (isGameOver) {
                        alert.setTitle("xWinner");
                        imageView.setImage(win);
                        alert.setGraphic(imageView);
                        alert.setHeaderText("Congratulations");
                        alert.showAndWait();
                    }

                } else {
                    clickedButton.setText("O");
                    checkIfGameOver();
                    if (isGameOver) {
                        alert.setTitle("oWinner");
                        imageView.setImage(win);
                        alert.setGraphic(imageView);
                        alert.setHeaderText("Congratulations");
                        alert.showAndWait();
                    }

                }
                btnsID[j] = clickedButton.getId();
                j++;

                isYourTurn = !isYourTurn;
                setPlayerTurn(); // setPlayerTurn()
            }

            if (isSinglePlayer == true) {
                if (isEasy == true) {
                    turnPlayer.setText("");
                    gameCounter++;
                    isYourTurn = true;
                    clickedButton.setText("X");
                    btnsID[j] = clickedButton.getId();
                    j++;
                    checkIfGameOver();
                    if (isGameOver) {
                        alert.setTitle("Winner");
                        imageView.setImage(win);
                        alert.setGraphic(imageView);
                        alert.setHeaderText("Congratulations");
                        alert.showAndWait();
                        setPlayerTurn();
                    }

                    if (isGameOver == false) {
                        isYourTurn = false;
                        removeActionFromButton();
                        gameCounter++;
                        while (true) {
                            randomNumber = random.nextInt(9);
                            System.out.println(randomNumber);
                            if (btns[randomNumber].getText().equals("")) {
                                btns[randomNumber].setText("O");
                                
                                btnsID[j] = btns[randomNumber].getId();
                                j++;
                                break;
                            }

                        }
                        checkIfGameOver();

                        addActiontoButton();

                    }
                } else {
                    System.out.println("hi");
                    singlePlayerAlgorithm(clickedButton);

                }
            }

        }

    }
    
    public void checkIfGameOver() {
        String A1 = btn0.getText();
        String A2 = btn1.getText();
        String A3 = btn2.getText();
        String B1 = btn3.getText();
        String B2 = btn4.getText();
        String B3 = btn5.getText();
        String C1 = btn6.getText();
        String C2 = btn7.getText();
        String C3 = btn8.getText();

        if (A1.equals(A2) && A1.equals(A3) && !A1.equals("")) {
            isGameOver = true;
            colorWinButtons(btn0, btn1, btn2);
        }

        if (B1.equals(B2) && B1.equals(B3) && !B1.equals("")) {
            isGameOver = true;
            colorWinButtons(btn3, btn4, btn5);
        }

        if (C1.equals(C2) && C1.equals(C3) && !C1.equals("")) {
            isGameOver = true;
            colorWinButtons(btn6, btn7, btn8);
        }

        if (A1.equals(B1) && A1.equals(C1) && !A1.equals("")) {
            isGameOver = true;
            colorWinButtons(btn0, btn3, btn6);
        }

        if (A2.equals(B2) && A2.equals(C2) && !A2.equals("")) {
            isGameOver = true;
            colorWinButtons(btn1, btn4, btn7);
        }

        if (A3.equals(B3) && A3.equals(C3) && !A3.equals("")) {
            isGameOver = true;
            colorWinButtons(btn2, btn5, btn8);
        }

        if (A1.equals(B2) && A1.equals(C3) && !A1.equals("")) {
            isGameOver = true;
            colorWinButtons(btn0, btn4, btn8);
        }

        if (A3.equals(B2) && A3.equals(C1) && !A3.equals("")) {
            isGameOver = true;
            colorWinButtons(btn2, btn4, btn6);
        }

        if(isGameOver) {
            if(isYourTurn) {
                player1Score.setText(Integer.valueOf(player1Score.getText()) + 1 + "");
                //// update in the database. 
                recordGame.updateScore(playerId);
                // error here of label cannot be converted to int
                playerscore = recordGame.selectScore(playerId);
                Panes.ticTacToe.player1Score.setText(Integer.toString(playerscore));
            } else {
                player2Score.setText(Integer.valueOf(player2Score.getText()) + 1 + "");
            }
            
            // reset game counter;
            gameCounter = 0;
            newGame.requestFocus();
           
        }
        if (gameCounter >= 9) {
            isGameOver = true;
            isYourTurn = true;
            gameCounter = 0;
        }

        if(isGameOver == true && isRecording == true ){
            storeGame();
        }
    }
    
    private void removeActionFromButton() {
        for (int i = 0; i < 9; i++) {
            btns[i].removeEventHandler(ActionEvent.ACTION, e -> {
                actionPerformed(e);
            });
            System.out.println("I cant c u ");
        }
    }

    

    private void colorWinButtons(Button b1, Button b2, Button b3) {
        b1.setStyle("-fx-background-color: green;  -fx-font-size: 46px; -fx-text-fill: white");
        b2.setStyle("-fx-background-color: green; -fx-font-size: 46px; -fx-text-fill: white");
        b3.setStyle("-fx-background-color: green;  -fx-font-size: 46px; -fx-text-fill: white");
    }

    
    
    public void singlePlayerAlgorithm(Button clickeButton) {
        // count the game 
        gameCounter++;
        isYourTurn = true;
        clickeButton.setText("X");
        btnsID[j] = clickeButton.getId();
        j++;
        checkIfGameOver();
        setPlayerTurn();
        if (isGameOver == false) {
            removeActionFromButton();
            // count the game
            gameCounter++;
            isYourTurn = false;
            int pos = findBestMove();
            btns[pos].setText("O");
            checkIfGameOver();
            addActiontoButton();
        }
    }

    // make sure to understand the full algorithm please guys :) 
    // it is really helpful! 
    public int minimax(int depth, Boolean isYourTurn) {
    
        if (!isYourTurn) {
            int best = -1000;
            for (int i = 0; i < 9; i++) {
                if (btns[i].getText().equals("")) {

                    best = Math.max(best, minimax(depth + 1, !isYourTurn));
                    System.out.println(best);
                }
                System.out.println(best);

            }
            return best;
        } else {
            int best = 1000;
            for (int i = 0; i < 9; i++) {
                if (btns[i].getText().equals("")) {

                    best = Math.min(best, minimax(depth + 1, !isYourTurn));
                    System.out.println(best);
                }
               System.out.println(best);

            }
            return best;
        }

    }

    public int findBestMove() {
        int bestVal = -10;
        int move = 0;
        for (int i = 0; i < 9; i++) {
            if (btns[i].getText().equals("")) {
                btns[i].setText("O");
                int moveVal = minimax(0, false);
                btns[i].setText("");

                move = i;
                bestVal = moveVal;
            }
        }

        return move;
    }

    

    
}
