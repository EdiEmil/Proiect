package java_Hotel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm {
    public JPanel JpanelUp;
    public JLabel userLoginLabel;
    public JLabel usernameLabel;
    public JTextField usernameTextField;
    public JLabel passwordLabel;
    public JPasswordField passwordTextField;
    public JButton loginButton;
    private JPanel mainPanel;
    private JButton button1;

    public LoginForm() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PreparedStatement ps;
                ResultSet rs;

                String username = usernameTextField.getText();
                String password = String.valueOf(passwordTextField.getPassword());


                if(username.trim().equals("")){
                    JOptionPane.showMessageDialog(mainPanel,"Enter your Username to Login","Empty Username",2);
                } else if(password.trim().equals("")){
                    JOptionPane.showMessageDialog(mainPanel,"Enter your Password to Login","Empty Password",2);
                }else {
                    MY_CONNECTION myConnection = new MY_CONNECTION();
                    // create the select query
                    String selectQuery = "SELECT * FROM `users` WHERE `username` =? AND `password` =?";
                    try {
                        ps = myConnection.createConnection().prepareStatement(selectQuery);
                        ps.setString(1,username);
                        ps.setString(2,password);
                        rs = ps.executeQuery();
                        if(rs.next()){
                          // if this user exist open the main form and close the login form
                           MainForm mainform = new MainForm();
                           mainform.showGUI();

                        } else {
                           // if the user enter the wrong information
                            JOptionPane.showMessageDialog(mainPanel,"Wrong UserName or Password","Login Error",2);
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }


                }

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.addActionListener(actionEvent ->{new MainForm();});
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Form");
        frame.setContentPane(new LoginForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


