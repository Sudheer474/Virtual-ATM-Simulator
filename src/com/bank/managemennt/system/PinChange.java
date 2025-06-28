package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    //Global Variable
    JPasswordField pinTextField, repinTextField;
    JButton change,back;
    String pinNumber;

    PinChange(String pinNumber){
        this.pinNumber = pinNumber;


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("CHANGE YOUR PIN ");
        text.setBounds(240, 250, 650, 30);
        text.setFont(new Font("Railway", Font.BOLD, 18));
        text.setForeground(Color.white);
        image.add(text);


        JLabel pinText = new JLabel("New PIN ");
        pinText.setBounds(155, 285, 100, 30);
        pinText.setFont(new Font("Railway", Font.BOLD, 16));
        pinText.setForeground(Color.white);
        image.add(pinText);

        pinTextField =new JPasswordField();
        pinTextField.setBounds(330, 285, 170, 30);
        pinTextField.setFont(new Font("Railway", Font.BOLD, 18));
        pinTextField.setForeground(Color.black);
        image.add(pinTextField);


        JLabel repinText = new JLabel("Re-Enter New PIN ");
        repinText.setBounds(155, 330, 150, 30);
        repinText.setFont(new Font("Railway", Font.BOLD, 16));
        repinText.setForeground(Color.white);
        image.add(repinText);

        repinTextField =new JPasswordField();
        repinTextField.setBounds(330, 330, 170, 30);
        repinTextField.setFont(new Font("Railway", Font.BOLD, 18));
        repinTextField.setForeground(Color.black);
        image.add(repinTextField);


        change = new JButton("CHANGE");
        change.setBounds(365,457,140,30);
        change.setFont(new Font("Railway", Font.BOLD, 16));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(365,492,140,30);
        back.setFont(new Font("Railway", Font.BOLD, 16));
        back.addActionListener(this);
        image.add(back);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,900);
        setLocation(300,0);
//        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String newPin = pinTextField.getText();
                String renewPin = repinTextField.getText();

                if (!newPin.equals(renewPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match.");
                    return;
                }

                if (newPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                    return;
                }
                if (renewPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Re-Enter New PIN");
                    return;
                }
                ConnectivityClass conn = new ConnectivityClass();
                String query1 = "update bank set pin = '"+renewPin+"' where pin = '"+pinNumber+"'";
                String query2 = "update signupthree set pinNo = '"+renewPin+"' where pinNo = '"+pinNumber+"'";
                String query3 = "update login set pinNo = '"+renewPin+"' where pinNo = '"+pinNumber+"'";
                conn.statement.executeUpdate(query1);
                conn.statement.executeUpdate(query2);
                conn.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"PIN changes successfully");

                setVisible(false);
                new Transactions(renewPin).setVisible(true); //now transaction will have new pin

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }

    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

}
