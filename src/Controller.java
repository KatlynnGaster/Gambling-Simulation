import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    View view;
    Login login;
    Leaderboard leaderboard;
    Bet bet;

    public Controller(){
        this.view = new View();
        this.login = new Login();
        this.leaderboard = new Leaderboard();
        this.bet = new Bet();

        view.setLoginListener(new loginListener());
        view.setCreateListener(new createListener());
        view.setLeaderboardListener(new leaderboardListener());
        view.setBetListener(new betButtonListener());
        view.setPlayListener(new playButtonListener());

        view.playerstats.setText(leaderboard.sendPlayerinfo(Login.playerId));
        ArrayList<String> hold = leaderboard.sendView();
        for(String str : hold){
            view.Leaderboard.addElement(str);
        }
    }


    class loginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String username = view.textFieldUsername.getText();
            String password = view.textFieldPassword.getText();
            boolean loginCheck = login.login(username,password);
            view.playerstats.setText(leaderboard.sendPlayerinfo(Login.playerId));
            if(loginCheck){
                view.loginFrame.setVisible(false);
                view.playFrame.setVisible(true);
            }
            else{
                System.out.println("Fail login");
            }
        }
    }

    class createListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            String username = view.textFieldUsername.getText();
            String password = view.textFieldPassword.getText();
            boolean loginCheck = login.createAcc(username,password);
            if(loginCheck){
                view.loginFrame.setVisible(false);
                view.playFrame.setVisible(true);
            }
            else{
                System.out.println("Fail login");
            }
        }
    }

    class leaderboardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            leaderboard.sendView();
        }
    }

    class betButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Bet.betAmount = Integer.parseInt(view.textFieldBet.getText());
            System.out.println("Bet chosen.");
        }
    }

    class playButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            double flip = Math.round(Math.random());
            if(flip == 0.00){
                System.out.println("Lose");
            }
            if(flip == 1.00){
                System.out.println("Win!");
            }
        }
    }

}
