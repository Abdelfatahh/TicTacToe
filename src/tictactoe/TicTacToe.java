/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author abdelfatah
 */
public class TicTacToe extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        AnchorPane pane = new AnchorPane();
       
        pane.getChildren().add(Panes.newOrOld);
        pane.getChildren().add(Panes.namingOption);
        pane.getChildren().add(Panes.mainMenu);
        pane.getChildren().add(Panes.multiPlayer);
        pane.getChildren().add(Panes.singlePlayer);
        pane.getChildren().add(Panes.ticTacToe);
        pane.getChildren().add(Panes.localMultiplayerOptions);
        pane.getChildren().add(Panes.networkMultiplayerOptions);
        pane.getChildren().add(Panes.ticTacToeMultiplayer);
        pane.getChildren().add(Panes.record);
        pane.getChildren().add(Panes.ticTacToeRecords);
        
        Panes.viewPane(Panes.newOrOld);
                    
        Scene scene = new Scene(pane, 903, 762);
        
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setResizable(false);
        //primaryStage.getIcons().add(new Image());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest((WindowEvent we) -> {
            System.exit(0);
        }); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
