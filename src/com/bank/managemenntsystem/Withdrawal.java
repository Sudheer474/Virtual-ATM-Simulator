package com.bank.managemenntsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

        //Global Var
        JButton withdraw,back;
        String pinNumber;
        JTextField amount;

        Withdrawal(String pinNumber){
        this.pinNumber = pinNumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setBounds(195,310,650,35);
        text.setFont(new Font("Railway",Font.BOLD,16));
        text.setForeground(Color.white);
        image.add(text);


        amount = new JTextField();
        amount.setFont(new Font("Railway",Font.BOLD,18));
        amount.setBounds(180,365,250,30);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setFont((new Font("Railway",Font.BOLD,16)));
        withdraw.setBounds(380,485,130,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setFont((new Font("Railway",Font.BOLD,16)));
        back.setBounds(380,520,130,30);
        back.addActionListener(this);
        image.add(back);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }


        @Override
        public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdraw){
            String withdrawAmt = amount.getText();
            Date date = new Date();
            if (withdrawAmt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw.");
            }else {
                try {
                    ConnectivityClass c5 = new ConnectivityClass();
                    String query1 = "select from bank";
                    String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+withdrawAmt+"')";
                    c5.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs " + withdrawAmt+ " Withdraw Successfully.");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber);
        }


    }



    public static void main(String[] args) {
            new Withdrawal("");
    }

}
