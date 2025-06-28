package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BalanceEnquiry extends JFrame implements ActionListener {

    //Global var
    JButton back;
    String pinNumber;

    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        back = new JButton("BACK");
        back.setBounds(365, 520, 140, 30);
        back.setFont(new Font("Railway", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);


        ConnectivityClass c6 = new ConnectivityClass();
        float balance = 0.00F;
        try {
            ResultSet rs = c6.statement.executeQuery("select * from bank where pin = '" + pinNumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Float.parseFloat(rs.getString("amount"));
                } else { // type-->withdrawal
                    balance -= Float.parseFloat(rs.getString("amount"));
                }
            }
        }catch (Exception e) {
                e.printStackTrace();
        }

        JLabel checkBalance = new JLabel("Your current account balance is Rs "+ balance);
        checkBalance.setForeground(Color.white);
        checkBalance.setFont(new Font("Railway",Font.BOLD,14));
        checkBalance.setBounds(190,295,600,35);
        image.add(checkBalance);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);


    }
    @Override
    public void actionPerformed (ActionEvent ae){
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);

    }
    public static void main (String[]args){
        new BalanceEnquiry("");
    }
}
