package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {


    //Global Variables
    JButton amt100,amt500,amt1000,amt2000,back,amt5000,amt10000;
    String pinNumber;



    FastCash(String pinNumber){
        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(220,270,650,35);
        text.setFont(new Font("Railway",Font.BOLD,14));
        text.setForeground(Color.white);
        image.add(text);// why label.add bcoz we want to add text on image


        amt100 = new JButton("Rs 100");
//        amt100.setForeground(Color.black);
//        amt100.setBackground(Color.white);
        amt100.setBounds(160,388,140,30);
        amt100.setFont(new Font("Railway",Font.BOLD,12));
        amt100.addActionListener(this);
        image.add(amt100);


        amt500 = new JButton("Rs 500");
//        amt500.setForeground(Color.black);
//        amt500.setBackground(Color.white);
        amt500.setBounds(355,387,140,30);
        amt500.setFont(new Font("Railway",Font.BOLD,12));
        amt500.addActionListener(this);
        image.add(amt500);


        amt1000 = new JButton("Rs 1000");
//        amt1000.setForeground(Color.black);
//        amt1000.setBackground(Color.white);
        amt1000.setBounds(160,422,140,30);
        amt1000.setFont(new Font("Railway",Font.BOLD,12));
        amt1000.addActionListener(this);
        image.add(amt1000);


        amt2000 = new JButton("Rs 2000");
//        amt2000.setForeground(Color.black);
//        amt2000.setBackground(Color.white);
        amt2000.setBounds(355,422,140,30);
        amt2000.setFont(new Font("Railway",Font.BOLD,12));
        amt2000.addActionListener(this);
        image.add(amt2000);


        amt5000 = new JButton("Rs 5000");
//        amt5000.setForeground(Color.black);
//        amt5000.setBackground(Color.white);
        amt5000.setBounds(160,457,140,30);
        amt5000.setFont(new Font("Railway",Font.BOLD,12));
        amt5000.addActionListener(this);
        image.add(amt5000);


        amt10000 = new JButton("Rs 10000");
//        amt10000.setForeground(Color.black);
//        amt10000.setBackground(Color.white);
        amt10000.setBounds(355,457,140,30);
        amt10000.setFont(new Font("Railway",Font.BOLD,12));
        amt10000.addActionListener(this);
        image.add(amt10000);


        back = new JButton("Back");
//        back.setForeground(Color.black);
//        back.setBackground(Color.white);
        back.setBounds(355,492,140,30);
        back.setFont(new Font("Railway",Font.BOLD,12));
        back.addActionListener(this);
        image.add(back);




        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(900,900);
        setLocation(355,0);
//        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            ConnectivityClass c6 = new ConnectivityClass();
            try {
                ResultSet rs = c6.statement.executeQuery("select * from bank where pin = '" + pinNumber + "'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance +=  Integer.parseInt(rs.getString("amount"));
                    }else { // type-->withdrawal
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank value('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                c6.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully.");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
//        else {if (ae.getSource() == amt100){
//            setVisible(false);
//            new Deposit(pinNumber).setVisible(true);
////        }else if (ae.getSource() == amt500){
//            setVisible(false);
//            new Withdrawal(pinNumber).setVisible(true);
//        }

    }


    public static void main(String[] args) {
        new FastCash("");
    }


}