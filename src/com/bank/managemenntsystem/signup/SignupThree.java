package com.bank.managemenntsystem.signup;

import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    //Global variables
    JButton submit,cancel;
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formNo;


    SignupThree(String formNo){
        this.formNo = formNo;


        setLayout(null);


        JLabel l1 = new JLabel("Page 3: Account  Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(290,40,400,30);
        add(l1);

        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Railway",Font.BOLD,20));
        accType.setBounds(100,120,200,40);
        add(accType);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBounds(100,160,150,20);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBounds(320,160,300,20);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBounds(100,200,150,20);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        SignupThree.this.r4.setFont(new Font("Railway",Font.BOLD,16));
        SignupThree.this.r4.setBounds(320,200,300,20);
        SignupThree.this.r4.setBackground(Color.white);
        add(SignupThree.this.r4);

        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(r1);
        accGroup.add(r2);
        accGroup.add(SignupThree.this.r4);
        accGroup.add(r3);



        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Railway",Font.BOLD,20));
        card.setBounds(100,270,200,30);
        add(card);
        JLabel dummyInfo = new JLabel("Your 16 Digit Card Number");
        dummyInfo.setFont(new Font("Railway",Font.BOLD,12));
        dummyInfo.setBounds(100,290,200,30);
        add(dummyInfo);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-5545");
        number.setFont(new Font("Railway",Font.BOLD,20));
        number.setBounds(320,270,400,30);
        add(number);



        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Railway",Font.BOLD,20));
        pin.setBounds(100,340,200,30);
        add(pin);
        JLabel dummyInfo2 = new JLabel("Your 4 Digit PIN Number");
        dummyInfo2.setFont(new Font("Railway",Font.BOLD,12));
        dummyInfo2.setBounds(100,360,200,30);
        add(dummyInfo2);

        JLabel pinNum = new JLabel("XXXX");
        pinNum.setFont(new Font("Railway",Font.BOLD,20));
        pinNum.setBounds(320,340,400,30);
        add(pinNum);



        JLabel services_required = new JLabel("Services Required");
        services_required.setFont(new Font("Railway",Font.BOLD,20));
        services_required.setBounds(100,420,400,30);
        add(services_required);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100,450,150,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(300,450,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100,490,150,30);
        add(c3);

        c4 = new JCheckBox("E-mail & SMS Alerts");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(300,490,300,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(100,530,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(300,530,200,30);
        add(c6);


        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Railway",Font.BOLD,13));
        c7.setBounds(100,590,650,30);
        add(c7);



        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Railway",Font.BOLD,16));
        submit.setBounds(200,650,130,35);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Railway",Font.BOLD,16));
        cancel.setBounds(400,650,120,35);
        cancel.addActionListener(this);
        add(cancel);




        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(800,800);
        setLocation(350,0);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == submit){
            String accType = null;
            if (r1.isSelected()){
                accType = "Saving Account";
            }else if (r2.isSelected()){
                accType = "Fixed Deposit Account";
            }else if (r3.isSelected()){
                accType = "Current Account";
            }else if (r4.isSelected()){
                accType = "Recurring Deposit Account";
            }

            Random random = new Random(); // for generating random card no.
            String cardNo = "" + Math.abs((random.nextLong() % 9000000000000L) + 4102000000000000L);
            String pinNo = "" + Math.abs((random.nextInt(1000,9999)));
            String services = "";
            if (c1.isSelected()){
                services = services + " ATM Card";
            }else if (c2.isSelected()){
                services = services + " Internet Banking";
            }else if (c3.isSelected()){
                services = services + " Mobile Banking";
            }else if (c4.isSelected()){
                services = services + " Email & SMS Alerts";
            }else if (c5.isSelected()){
                services = services + " Cheque Book";
            }else if (c6.isSelected()){
                services = services + " E-Statement";
            }
            if (!c7.isSelected()){
                JOptionPane.showMessageDialog(null,"Please check the declaration !!");
                return;
            }

            //validation if anything remains empty show a dialogue box
            try {
                if (accType == null){
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                }else{
                    ConnectivityClass conn3 = new ConnectivityClass();
                    String query = ("insert into signupthree values ('" +new String(this.formNo)+ "','" +accType+ "','"+cardNo+ "','"+pinNo+ "','"+services+ "')");
                    String query2 = ("insert into login values ('" +new String(this.formNo)+ "','"+cardNo+ "','"+pinNo+ "')");

                    conn3.statement.executeUpdate(query2);
                    conn3.statement.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Card Number: " + cardNo + "\n Pin: " + pinNo);

                    setVisible(false);
                    new Login();

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }else if (ae.getSource() == cancel){
            JOptionPane optionPane = new JOptionPane(new JButton("Continue"));
            JOptionPane optionPane2 = new JOptionPane(new JButton("Cancel"));
            JOptionPane.showMessageDialog(null,"You'll loose all previous data !!");
//            JOptionPane.showMessageDialog("");

            setVisible(false);
            new Login();

//            setVisible(false);
        }
    }


    public static void main(String[] args) {
        new SignupThree("");
    }


}
