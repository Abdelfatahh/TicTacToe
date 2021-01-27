package tictactoe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.layout.Pane;
/**
 *
 * @author abdelfatah
 */
public class Panes {
    static newOld newOrOld = new newOld();
    static NamingOption namingOption = new NamingOption();
    static MainMenuFXML mainMenu = new MainMenuFXML();
    static SinglePlayerLevels singlePlayer = new SinglePlayerLevels();
    static MultiplayerOptions multiPlayer = new MultiplayerOptions();
    static NetworkMultiplayerOptions networkMultiplayerOptions  = new NetworkMultiplayerOptions();
    static LocalMultiplayerOptions localMultiplayerOptions = new LocalMultiplayerOptions();
    static TicTacToeGame ticTacToe = new TicTacToeGame();
    static TicTacToeGameMultiplayer ticTacToeMultiplayer = new TicTacToeGameMultiplayer();
    static IpNetwork ipNetwork = new IpNetwork();
    static Record record = new Record();
    static TicTacToeRecords ticTacToeRecords = new TicTacToeRecords();
    
    
    public static void viewPane(Pane pane){
    namingOption.setVisible(false);
    mainMenu.setVisible(false);
    singlePlayer.setVisible(false);
    multiPlayer.setVisible(false);
    networkMultiplayerOptions.setVisible(false);
    localMultiplayerOptions.setVisible(false);
    ticTacToe.setVisible(false);
    ticTacToeMultiplayer.setVisible(false);
    record.setVisible(false);
    ticTacToeRecords.setVisible(false);
    newOrOld.setVisible(false);
        
    pane.setVisible(true);
    }
}


