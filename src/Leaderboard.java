import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class Leaderboard {

    public ArrayList<String> sendView(){
        ArrayList<String> leaderboardList = new ArrayList<String>();
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            String find ="SELECT * from players;";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(find);


            while(resultSet.next()){
                String user = resultSet.getString("username");
                int bal = resultSet.getInt("balance");
                int wins = resultSet.getInt("wins");
                int losses = resultSet.getInt("losses");
                String output = String.format("Player: %s | Balance: %d | Wins: %d | Losses: %d",user,bal,wins,losses);
                leaderboardList.add(output);

            }
            conn.close();
        }
        catch (SQLException e){

        }
        return leaderboardList;
    }

    public String sendPlayerinfo(int id){
        String output = null;
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            String find = String.format("SELECT * from players where ID = %d;",id);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(find);
            while(resultSet.next()){
                String user = resultSet.getString("username");
                int bal = resultSet.getInt("balance");
                int wins = resultSet.getInt("wins");
                int losses = resultSet.getInt("losses");
                output = String.format("Player: %s | Balance: %d | Wins: %d | Losses: %d",user,bal,wins,losses);
            }
            conn.close();
        }
        catch (SQLException e){

        }
        return output;
    }

    public void update(){

    }

    public void bankruptcy(){

    }

}
