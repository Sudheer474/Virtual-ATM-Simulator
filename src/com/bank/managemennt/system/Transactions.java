package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {


    //Global Variables
    JButton deposit, withdrawal, fastCash, miniStatement, exit, pinChange, balanceEnquiry;
    String pinNumber;


    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(220, 270, 650, 35);
        text.setFont(new Font("Railway", Font.BOLD, 14));
        text.setForeground(Color.white);
        image.add(text);// why label.add bcoz we want to add text on image


        deposit = new JButton("Deposit");
//        deposit.setForeground(Color.black);
//        deposit.setBackground(Color.white);
        deposit.setBounds(160, 388, 140, 30);
        deposit.setFont(new Font("Railway", Font.BOLD, 12));
        deposit.addActionListener(this);
        image.add(deposit);


        withdrawal = new JButton("Cash Withdrawal");
//        withdrawal.setForeground(Color.black);
//        withdrawal.setBackground(Color.white);
        withdrawal.setBounds(355, 387, 140, 30);
        withdrawal.setFont(new Font("Railway", Font.BOLD, 12));
        withdrawal.addActionListener(this);
        image.add(withdrawal);


        fastCash = new JButton("Quick Cash");
//        fastCash.setForeground(Color.black);
//        fastCash.setBackground(Color.white);
        fastCash.setBounds(160, 422, 140, 30);
        fastCash.setFont(new Font("Railway", Font.BOLD, 12));
        fastCash.addActionListener(this);
        image.add(fastCash);


        miniStatement = new JButton("Mini Statement");
//        miniStatement.setForeground(Color.black);
//        miniStatement.setBackground(Color.white);
        miniStatement.setBounds(355, 422, 140, 30);
        miniStatement.setFont(new Font("Railway", Font.BOLD, 12));
        miniStatement.addActionListener(this);
        image.add(miniStatement);


        pinChange = new JButton("Pin Change");
//        pinChange.setForeground(Color.black);
//        pinChange.setBackground(Color.white);
        pinChange.setBounds(160, 457, 140, 30);
        pinChange.setFont(new Font("Railway", Font.BOLD, 12));
        pinChange.addActionListener(this);
        image.add(pinChange);


        balanceEnquiry = new JButton("Balance Enquiry");
//        balanceEnquiry.setForeground(Color.black);
//        balanceEnquiry.setBackground(Color.white);
        balanceEnquiry.setBounds(355, 457, 140, 30);
        balanceEnquiry.setFont(new Font("Railway", Font.BOLD, 12));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);


        exit = new JButton("Exit");
//        exit.setForeground(Color.black);
//        exit.setBackground(Color.white);
        exit.setBounds(355, 492, 140, 30);
        exit.setFont(new Font("Railway", Font.BOLD, 12));
        exit.addActionListener(this);
        image.add(exit);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(900, 900);
        setLocation(355, 0);
//        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);  //setVisible(false);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdrawal) {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        } else if (ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        } else if (ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if (ae.getSource() == miniStatement){
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main (String []args){
        new Transactions("");
    }

}