package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


/**
 * This project is done using Java Core concepts, Java Swing,AWT(Abstract window toolkit) and MySql database
 * And JDBC connectivity...
 */



//interface
public class Login extends JFrame implements ActionListener {

    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton clear,signUp,login;

    public Login(){//Constructor to create Frame

        setTitle("Bhag Jaunga Bank");
//        = new JFrame("Bhag Jaunga Bank Ltd. "); //JFrame Creation

        setLayout(null); //Terminates default flow layout

//        Container c = getContentPane();

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3); // label takes image icon as parameter
        label.setBounds(90,10,100,100);
                   //frm left  frm up
        add(label);

//        JLabel label = new JLabel();//JLabel creation
//        label.setIcon(new ImageIcon("/ImageIcon/BankIcon.png"));//sets the image to be displayed as an icon
//        Dimension size = label.getPreferredSize();
//        label.setBounds(50,30,size.width,size.height);
//        add(new JLabel(icon));


        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Oswald",Font.BOLD, 30));
        text.setBounds(220,40,300,40);
        add(text);

        JLabel cardNo = new JLabel("Card No");
        cardNo.setFont(new Font("Oswald",Font.BOLD,30));
        cardNo.setBounds(140,150,150,40);
        add(cardNo);

        cardTextField = new JTextField(); //to enter card no
        cardTextField.setBounds(320,160,220,30);
        cardTextField.setFont(new Font("Oswald",Font.BOLD,20));
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Railway",Font.BOLD,30));
        pin.setBounds(140,230,400,40);
        add(pin);

        pinTextField = new JPasswordField(); //to enter pin no
        pinTextField.setBounds(320,230,220,30);//setting position of pin area
        pinTextField.setFont(new Font("Oswald",Font.BOLD,20));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(320,300,100,35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(440,300,100,35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(320,370,220,35);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        setSize(750,480);//for size
        setVisible(true); // Exhibit the
        setLocation(350,200);

    }

//abstract method overriding of interface
    public void actionPerformed(ActionEvent ae){ //what will happen while click on buttons will be described here
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if (ae.getSource() == login){
            ConnectivityClass c4 = new ConnectivityClass();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();

            String query = "select * from login where cardNo = '"+ cardNumber+"' and pinNo = '"+pinNumber+ "'";

            try {
                ResultSet rs = c4.statement.executeQuery(query);
                // returns data from DB so we need to store the data in result set object
                if (rs.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else if (ae.getSource() == signUp){
            setVisible(false);
            new SignupOne().setVisible(true); // constructor calling through anonymous object
            // SignupOne obj = new SignupOne(); --> obj.setVisible(true);

        }
    }

    public static void main(String[] args) {
        // write your code here
        new Login(); //Anonymous object of class login
    }
}
