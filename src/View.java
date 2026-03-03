import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.BiPredicate;

public class View {
    Background logBack = new Background();
    JFrame loginFrame = new JFrame();
    JFrame playFrame = new JFrame();

    DefaultListModel<String> Leaderboard = new DefaultListModel<String>();
    JList<String> LeaderboardList = new JList<String>(Leaderboard);

    JButton loginButton = new JButton("Login");
    JButton createButton = new JButton("Create Account");
    JButton viewLButton = new JButton("View Leaderboard");

    JTextField textFieldUsername = new JTextField(10);
    JTextField textFieldPassword = new JTextField(10);

    JButton betButton = new JButton("Set bet");
    JButton playButton = new JButton("Play bet");
    JTextField textFieldBet = new JTextField(10);
    JLabel playerstats = new JLabel(" ");

    public View(){
        JLabel userlabel = new JLabel("Username");
        userlabel.setFont(new Font("Verdana",Font.BOLD,20));
        userlabel.setForeground(Color.WHITE);
        JLabel passlabel = new JLabel("Password");
        passlabel.setFont(new Font("Verdana",Font.BOLD,20));
        passlabel.setForeground(Color.WHITE);

        GridBagConstraints loginTabs = new GridBagConstraints();
        loginTabs.insets = new Insets(10,50,100,5);

        GridBagConstraints loginFieldTabs = new GridBagConstraints();
        loginFieldTabs.insets = new Insets(10,5,100,20);

        GridBagConstraints passTabs = new GridBagConstraints();
        passTabs.insets = new Insets(10,-375,0,10);

        GridBagConstraints passFieldTabs = new GridBagConstraints();
        passFieldTabs.insets = new Insets(10,-150,0,10);

        GridBagConstraints lButtonTabs = new GridBagConstraints();
        lButtonTabs.insets = new Insets(10,-400,-160,0);

        GridBagConstraints cButtonTabs = new GridBagConstraints();
        cButtonTabs.insets = new Insets(10,-415,-250,-10);

        GridBagConstraints leaderTabs = new GridBagConstraints();
        leaderTabs.insets = new Insets(10,-600,-400,-10);

        logBack.setLayout(new GridBagLayout());
        logBack.add(userlabel,loginTabs);
        logBack.add(textFieldUsername, loginFieldTabs);
        logBack.add(passlabel, passTabs);
        logBack.add(textFieldPassword, passFieldTabs);
        logBack.add(loginButton, lButtonTabs);
        logBack.add(createButton, cButtonTabs);


        logBack.add(viewLButton, leaderTabs);
        loginFrame = new JFrame();
        loginFrame.add(logBack);

        loginFrame.pack();

        loginFrame.setSize(900,505);

        loginFrame.setVisible(true);
        makePlayFrame();
    }


    public JPanel makeLoginTab(){
        JPanel loginPanel = new JPanel();
        loginPanel.setBorder(new EmptyBorder(100,100,100,100));



        JPanel inner = new JPanel();
        inner.setLayout(new BoxLayout(inner,BoxLayout.Y_AXIS));
        JLabel userlabel = new JLabel("Username");
        userlabel.setFont(new Font("Verdana",Font.BOLD,20));
        inner.add(userlabel);
        inner.add(textFieldUsername);
        JLabel passlabel = new JLabel("Password");
        passlabel.setFont(new Font("Verdana",Font.BOLD,20));
        inner.add(passlabel);
        inner.add(textFieldPassword);
        inner.add(loginButton);
        inner.add(createButton);

        loginPanel.add(BorderLayout.CENTER,inner);

        loginPanel.setBorder(new EmptyBorder(50,50,50,50));

        return loginPanel;
    }

    public void makePlayFrame(){
        JPanel east = new JPanel();
        JPanel west = new JPanel();
        JPanel south = new JPanel();
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JLabel gamble = new JLabel("GET GAMBLING BABY", SwingConstants.CENTER);

        north.setBorder(new EmptyBorder(50,50,50,50));
        south.setBorder(new EmptyBorder(50,50,50,50));
        east.setBorder(new EmptyBorder(50,50,50,50));
        west.setBorder(new EmptyBorder(50,50,50,50));
        center.setBorder(new EmptyBorder(50,50,50,50));
        north.add(gamble);

        center.add(playButton);

        west.setLayout(new GridLayout(1,1));
        west.add(textFieldBet);
        west.add(betButton);

        east.setLayout(new BoxLayout(east,BoxLayout.Y_AXIS));
        east.add(new JLabel("Leaderboard"));
        east.add(LeaderboardList);

        south.add(playerstats);


        playFrame.add(BorderLayout.NORTH,north);
        playFrame.add(BorderLayout.SOUTH,south);
        playFrame.add(BorderLayout.EAST,east);
        playFrame.add(BorderLayout.WEST,west);
        playFrame.add(BorderLayout.CENTER,center);
        playFrame.setSize(900,700);



    }



    public void setLoginListener(ActionListener al){
        loginButton.addActionListener(al);
    }

    public void setCreateListener(ActionListener al){
        createButton.addActionListener(al);
    }

    public void setLeaderboardListener(ActionListener al){
        viewLButton.addActionListener(al);
    }

    public void setBetListener(ActionListener al) {betButton.addActionListener(al);}

    public void setPlayListener(ActionListener al) {playButton.addActionListener(al);}

}
