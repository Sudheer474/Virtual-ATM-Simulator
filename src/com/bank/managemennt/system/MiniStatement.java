package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class MiniStatement extends JFrame implements ActionListener {

    //Global var
    String pinNumber;

    MiniStatement(String pinNumber){
        this.pinNumber = pinNumber;
        setTitle("Mini Statement Indian Bank");

        setLayout(null);

        JLabel mini = new JLabel();
        setBounds(100,100,400,30);
        add(mini);


        JLabel card = new JLabel();
        card.setBounds(10,40,100,20);
//        card.setFont(new Font("Railway",Font.BOLD,16));
        add(card);



        JLabel stro = new JLabel((new Date()).toString());
        stro.setFont(new Font("Railway",Font.BOLD,16));
        stro.setBounds(125,0,300,30);
        add(stro);



        try {
            ConnectivityClass conn = new ConnectivityClass();
            ResultSet rs = conn.statement.executeQuery("select * from login where pinNo = '"+pinNumber+"',");
            while (rs.next()){
                card.setText("Card Number " + rs.getString("cardNo").substring(0,4) + "XXXXXXXX" + rs.getString("cardNo").substring(12));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            ConnectivityClass conn2 = new ConnectivityClass();
            ResultSet rs = conn2.statement.executeQuery("select * from bank where pin = '"+pinNumber+"',");
            while (rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,600);
        setLocation(350,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args) {
        new MiniStatement("");
    }
}
