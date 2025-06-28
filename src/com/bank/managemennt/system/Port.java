package com.bank.managemennt.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Port extends JFrame implements ActionListener {

    JButton yes,no;

    Port(){
        setLayout(null);

        yes = new JButton("Yes");
        yes.setBounds(150,150,100,50);
        yes.setFont(new Font("Railway", Font.BOLD, 12));
        yes.addActionListener(this);
        add(yes);


        no = new JButton("No");
        no.setBounds(300,150,100,50);
        no.setFont(new Font("Railway", Font.BOLD, 12));
        no.addActionListener(this);
        add(no);




        setSize(500,500);
        setLocation(200,100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }



    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == no){
            setVisible(false);
        }else {
            new Port2().setVisible(true);
        }

    }


    public static void main(String[] args) {
        new Port();
    }
}
