import java.sql.*;

public class Login {

    public static int playerId;

    public Login(){

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            String cmd = "CREATE TABLE IF NOT EXISTS players (" +
                    "id INTEGER PRIMARY KEY," +
                    "username STRING," +
                    "password STRING," +
                    "balance INTEGER," +
                    "wins INTEGER," +
                    "losses INTEGER);";
            conn.createStatement().executeUpdate(cmd);
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();

    }
    }

    public boolean loginState = false;

    public boolean login(String username, String password){
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            String find ="SELECT id,username from players WHERE username = ? AND password = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(find);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String user = resultSet.getString("username");
                int id = resultSet.getInt("id");
                if(user.equals(username)){
                    loginState = true;
                    playerId = id;
                }
                else{
                    //USER ENTERED WRONG USERNAME OR PASSWORD
                    System.out.println("Incorrect Username/Password");
                }
            }
            conn.close();
        }
        catch (SQLException e){

        }
        return loginState;
    }

    public boolean createAcc(String username, String password){
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:database.db");
            String find ="SELECT username from players WHERE username = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(find);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            loginState = true;

            while(resultSet.next()){
                String user = resultSet.getString("username");
                if(user.equals(username)){
                    loginState = false;
                    //USERNAME ALREADY TAKEN DO SOMETHING HERE
                    System.out.println("USERNAME TAKEN");
                }
            }

            if(loginState){
                System.out.println("Creating Account.");
                conn.createStatement().executeUpdate(String.format("INSERT INTO players (username, password, balance, wins, losses) VALUES ('%s','%s',%d,%d,%d);", username, password, 1000, 0, 0));
                conn.close();
                loginState = true;
            }

        }
        catch (SQLException e){

        }
        return loginState;
    }
    //Maybe we should make it take a String or number that outputs
    //something different depending on the value
    //Like account name taken or incorrect username/password.
    public void loginFail(){
        System.out.println();
        //SOME GUI ELEMENT THAT SENDS YOU BACK TO LOGIN PAGE. FUNCTION IS USED BY OTHER FUNCTIONS IN CLASS
    }

}
