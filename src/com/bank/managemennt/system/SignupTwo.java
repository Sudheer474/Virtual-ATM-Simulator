package com.bank.managemennt.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Random;

public class SignupTwo extends JFrame implements ActionListener {

    //Global variables
    Connection conn;
    Statement stmt;

    String formNo;
    JTextField panCardTextField, aadhaarCardTextField;
    JButton next;
    JComboBox selectReligion,selectCategory,selectIncome,selectEducationalQualification,selectOccupation,
            whetherSeniorCitizen,whetherExistingAccount;


    SignupTwo(String formNo) {
        this.formNo = formNo;

        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM "+ this.formNo + " - PAGE 2" );


        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 20));
        additionalDetails.setBounds(320, 50, 600, 34);
        add(additionalDetails);



        JLabel religion = new JLabel("Religion :");
        religion.setFont(new Font("Railway", Font.BOLD, 20));
        religion.setBounds(80, 130, 600, 30);
        add(religion);

        //combo box takes array of string, and it provides a dropdown
        selectReligion = new JComboBox(new String[]{"Hindu", "Muslim", "Sikh", "Christian", "Others"});
        selectReligion.setFont(new Font("Railway", Font.BOLD, 16));
        selectReligion.setBounds(275, 130, 500, 30);
        selectReligion.setBackground(Color.white);
        add(selectReligion);



        JLabel category = new JLabel("Category :");
        category.setFont(new Font("Railway", Font.BOLD, 20));
        category.setBounds(80, 185, 600, 30);
        add(category);

        selectCategory = new JComboBox(new String[]{"General", "OBC", "SC", "ST", "Others"});
        selectCategory.setFont(new Font("Railway", Font.BOLD, 16));
        selectCategory.setBounds(275, 185, 500, 30);
        selectCategory.setBackground(Color.white);
        add(selectCategory);


        JLabel income = new JLabel("Income :");
        income.setFont(new Font("Railway", Font.BOLD, 20));
        income.setBounds(80, 240, 600, 30);
        add(income);

        selectIncome = new JComboBox(new String[]{" Null", "< 1,50,000", "< 5,00,000", "< 10,00,000", " Above 10,00,000"});
        selectIncome.setFont(new Font("Railway", Font.BOLD, 16));
        selectIncome.setBounds(275, 240, 500, 30);
        selectIncome.setBackground(Color.white);
        add(selectIncome);


        JLabel educationalQualification = new JLabel("Educational");
        educationalQualification.setFont(new Font("Railway", Font.BOLD, 20));
        educationalQualification.setBounds(80, 285, 600, 30);
        add(educationalQualification);
        JLabel qualification = new JLabel("Qualification :");
        qualification.setFont(new Font("Railway", Font.BOLD, 20));
        qualification.setBounds(80, 315, 600, 30);
        add(qualification);

        selectEducationalQualification = new JComboBox(new String[]{" Metric Pass ", " Intermediate", " Graduate", " Post-Graduate", " Others"});
        selectEducationalQualification.setFont(new Font("Railway", Font.BOLD, 16));
        selectEducationalQualification.setBounds(275, 315, 500, 30);
        selectEducationalQualification.setBackground(Color.white);
        add(selectEducationalQualification);


        JLabel occupation = new JLabel("Occupation :");
        occupation.setFont(new Font("Railway", Font.BOLD, 20));
        occupation.setBounds(80, 370, 500, 30);
        add(occupation);

        selectOccupation = new JComboBox(new String[]{" Student"," Salaried", " Self-Employed", " Business", " Retired"});
        selectOccupation.setFont(new Font("Railway", Font.BOLD, 16));
        selectOccupation.setBounds(275, 370, 500, 30);
        selectOccupation.setBackground(Color.white);
        add(selectOccupation);

        JLabel panCardNo = new JLabel("Pan no :");
        panCardNo.setFont(new Font("Railway", Font.BOLD, 20));
        panCardNo.setBounds(80, 425, 600, 30);
        add(panCardNo);

        panCardTextField = new JTextField();
        panCardTextField.setFont(new Font("Railway", Font.BOLD, 16));
        panCardTextField.setBounds(275, 425, 500, 30);
        add(panCardTextField);


        JLabel aadhaarCardNo = new JLabel("Aadhaar no :");
        aadhaarCardNo.setFont(new Font("Railway", Font.BOLD, 20));
        aadhaarCardNo.setBounds(80, 480, 600, 30);
        add(aadhaarCardNo);

        aadhaarCardTextField = new JTextField();
        aadhaarCardTextField.setFont(new Font("Railway", Font.BOLD, 16));
        aadhaarCardTextField.setBounds(275, 480, 500, 30);
        add(aadhaarCardTextField);



        JLabel seniorCitizen = new JLabel("Senior Citizen :");
        seniorCitizen.setFont(new Font("Railway", Font.BOLD, 20));
        seniorCitizen.setBounds(80, 535, 600, 30);
        add(seniorCitizen);

        whetherSeniorCitizen = new JComboBox(new String[]{" No", " Yes"});
        //Here you can use ButtonGroup for "YES or NO"
        whetherSeniorCitizen.setFont(new Font("Railway", Font.BOLD, 16));
        whetherSeniorCitizen.setBounds(275, 535, 500, 30);
        whetherSeniorCitizen.setBackground(Color.white);
        add(whetherSeniorCitizen);



        JLabel existingAccount = new JLabel("Existing Account :");
        existingAccount.setFont(new Font("Railway", Font.BOLD, 20));
        existingAccount.setBounds(80, 590, 600, 30);
        add(existingAccount);

        whetherExistingAccount = new JComboBox(new String[]{" No", " Yes"});

        whetherExistingAccount.setFont(new Font("Railway", Font.BOLD, 16));
        whetherExistingAccount.setBounds(275, 590, 500, 30);
        whetherExistingAccount.setBackground(Color.white);
        add(whetherExistingAccount);



        JButton next = new JButton("Next >>");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(695, 645, 80, 30);
        next.addActionListener(this::actionPerformed);
        add(next);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        setSize(870, 780);
        setLocation(300, 10);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String sReligion = (String) selectReligion.getSelectedItem(); //stringReligion
        String sCategory = (String) selectCategory.getSelectedItem();
        String sIncome = (String) selectIncome.getSelectedItem();
        String sEducation = (String) selectEducationalQualification.getSelectedItem();
        String sOccupation = (String) selectOccupation.getSelectedItem();
        String sSenCitizen = (String) whetherSeniorCitizen.getSelectedItem();
        String sExtAcc = (String) whetherExistingAccount.getSelectedItem();


        String sPanNo = panCardTextField.getText();
        String sAadhaar = aadhaarCardTextField.getText();


            try{
                //Again establishing the JDBC connection using connectivity class by creating the object of Connectivity class
                ConnectivityClass c2 = new ConnectivityClass();

                String query = ("insert into signuptwo values ('" +formNo+ "','" +sReligion+ "','"+sCategory+ "','"+sIncome+ "','"+sEducation+ "','"+sOccupation+ "','"+sPanNo+ "','"+sAadhaar+ "','"+sSenCitizen+ "','"+sExtAcc+ "')");
                c2.statement.executeUpdate(query);

                //To jump to signupthree class
                setVisible(false);
                new SignupThree(formNo);

            }catch (Exception e){
                e.printStackTrace();
            }
    }


    public static void main (String[]args){
        new SignupTwo("");// anonymous object
    }
}