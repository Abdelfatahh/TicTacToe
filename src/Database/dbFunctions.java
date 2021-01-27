/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdelfatah
 */
public class dbFunctions {
    public PreparedStatement stmt1;
    public PreparedStatement stmt2;
    public PreparedStatement querySql;
    public Statement stmt3;
    public Statement stmt;
    public Statement cr1_stmt;
    public Statement cr2_stmt;
    public String queryString;
    public String queryString1;
    public String cr_query1;
    public String cr_query2;

    //create two tables 
    //table1-> player contains name id score foe each player
    //table2-> game contains player1 id /plyer2 id ,date, moves ,first char(x-o)
    public void createTables() {

        dbConnection connect = new dbConnection();
        Connection con = connect.getConnection();

        try {
            cr1_stmt = con.createStatement();
            cr2_stmt = con.createStatement();

            cr_query1 = new String("create table IF NOT EXISTS player(id int(100) auto_increment,name char(21) not null, score int(100) ,primary key(id) )");
            cr1_stmt.execute(cr_query1);

            cr_query2 = new String("create table IF NOT EXISTS game(player1 int ,player2name char(21)  ,gdate datetime, p1 char(20),  p2 char(20), p3 char(20), p4 char(20), p5 char(20), p6 char(20), p7 char(20), p8 char(20),p9 char(20),foreign key(player1) references player(id),primary key(player1,gdate))");
            cr2_stmt.execute(cr_query2);

        } catch (SQLException ex) {

            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                cr1_stmt.close();
                cr2_stmt.close();
                connect.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    // inset into player table and retrive id for user name
    public int insertPlayer(String n) {
        
        dbConnection  connect = new dbConnection();
        Connection getConnect = connect.getConnection();
        
        int id = -2;
        try {
            querySql = getConnect.prepareStatement("insert into player values(null,?,?)");
            querySql.setString(1, n);
            querySql.setInt(2, 0);
            querySql.execute();

            querySql = getConnect.prepareStatement("select id from player where name=?");
            querySql.setString(1, n);
            ResultSet rs = querySql.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {

            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {

                querySql.close();
                connect.closeConnection();

            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;

    }

    //check if name and id in database
    public boolean check(String n, int pid) {
        
        dbConnection connect = new dbConnection();
        Connection getConnect = connect.getConnection();

        int id;

        try {
            querySql = getConnect.prepareStatement("select id from player where name=?");
            querySql.setString(1, n);
            ResultSet rs = querySql.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                if (id == pid) {
                    return true;
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                
                querySql.close();
                connect.closeConnection();

            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;

    }

    // return score for player id
    public int selectScore(int n) {
        int scorep = -1;
        dbConnection c = new dbConnection();
        Connection con = c.getConnection();
        try {
            querySql = con.prepareStatement("select score from player where id=? ");
            querySql.setInt(1, n);
            ResultSet rs = querySql.executeQuery();
            while (rs.next()) {
                scorep = rs.getInt("score");
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                querySql.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return scorep;
    }

    //update score for player
    public void updateScore(int d) {
        dbConnection c = new dbConnection();
        Connection con = c.getConnection();
        try {
            querySql = con.prepareStatement("update player set score =score+1 where id=? ");
            querySql.setInt(1, d);
            querySql.execute();
        } catch (SQLException ex) {
            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                querySql.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    //insert game --> record game take array of moves , first symbol and datetime of game and retrive date
    public String recordGame(int pl1, String p2n, String btxt[]) {
        
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String s = df.format(dateobj);

        dbConnection connect = new dbConnection();
        Connection getConnect = connect.getConnection();
        try {
            int j = 0;
            querySql = getConnect.prepareStatement("insert into game values (?,?,?,?,?,?,?,?,?,?,?,?)");
            querySql.setInt(1, pl1);
            querySql.setString(2, p2n);
            querySql.setString(3, s);
            for (int i = 4; i < 13 && j < 9; i++, j++) {
                querySql.setString(i, btxt[j]);
            }
            querySql.execute();

        } catch (SQLException ex) {
            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                querySql.close();
                connect.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return (p2n + "     " + s);

    }

    //return Array of moves and first symbol played and take date p1ayerID player2ID
    public String[] returnGame(String d, int p1id, String p2n) {
        String[] ch;
        ch = new String[10];
        dbConnection c = new dbConnection();
        Connection con = c.getConnection();
        try {
            for (int i = 1; i < 10; i++) {
                querySql = con.prepareStatement("select p? from game where gdate=? and player1=? and player2name=? ");
                querySql.setInt(1, i);
                querySql.setString(2, d);
                querySql.setInt(3, p1id);
                querySql.setString(4, p2n);
                ResultSet rs = querySql.executeQuery();
                while (rs.next()) {
                    ch[i - 1] = rs.getString("p" + i);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                querySql.close();
                c.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ch;

    }

    public Vector<String> returnAllGames(int playerId) {

        Vector<String> allRecords = new Vector<>();
        
        dbConnection connect = new dbConnection();
        Connection getConnect = connect.getConnection();
        try {

            querySql = getConnect.prepareStatement("select * from game where player1=?");
            querySql.setInt(1, playerId);
            ResultSet rs = querySql.executeQuery();
            while (rs.next()) {
                String nameWithDate = rs.getString("player2name") + "     " + rs.getString("gdate");
                allRecords.add(nameWithDate);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                querySql.close();
                connect.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(dbFunctions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return allRecords;

    }
}
