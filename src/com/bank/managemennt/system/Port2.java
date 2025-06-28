package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Port2 extends JFrame implements ActionListener {

    Port2(){
        setLayout(null);

        JLabel label = new JLabel("Here are some available ports");
        label.setFont(new Font("Oswald",Font.BOLD,16));
        label.setBounds(100,50,400,40);
        add(label);



        setSize(500,500);
        setLocation(200,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }







    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        new Port2();
    }
}
