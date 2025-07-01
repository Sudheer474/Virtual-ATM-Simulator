package com.bank.managemenntsystem.signup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.bank.managemenntsystem.ConnectivityClass;
import com.toedter.calendar.JDateChooser;

/**
 -->Here, I'm creating application form and JDBC connection in the same class..
 */
public class SignupOne extends JFrame implements ActionListener {

    //Global variables
    long random;//this will generate random form no.
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinCodeTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, others;
    JDateChooser dateChooser;


    SignupOne(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);


        JLabel formNo = new JLabel("APPLICATION FORM NO. "+ random);
        formNo.setFont(new Font("Railway",Font.BOLD,30));
        formNo.setBounds(210,20,600,30);
        add(formNo);



        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Railway",Font.BOLD,20));
        personalDetails.setBounds(300,70,600,34);
        add(personalDetails);



        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100,130,600,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,16));
        nameTextField.setBounds(260,130,500,30);
        add(nameTextField);



        JLabel fatherName = new JLabel("Father's Name :");
        fatherName.setFont(new Font("Railway",Font.BOLD,20));
        fatherName.setBounds(100,180,600,30);
        add(fatherName);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway",Font.BOLD,16));
        fnameTextField.setBounds(260,180,500,30);
        add(fnameTextField);



        JLabel dob = new JLabel("Date of Birth :");
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100,230,600,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Railway",Font.BOLD,16));
        dateChooser.setBounds(260,230,250,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);



        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100,280,600,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Railway",Font.BOLD,16));
        male.setBounds(260,280,100,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Railway",Font.BOLD,16));
        female.setBounds(390,280,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);



        JLabel email = new JLabel("Email Address :");
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100,330,600,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD,16));
        emailTextField.setBounds(260,330,500,30);
        add(emailTextField);



        JLabel maritalStatus = new JLabel("Marital Status :");
        maritalStatus.setFont(new Font("Railway",Font.BOLD,20));
        maritalStatus.setBounds(100,380,600,30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setFont(new Font("Railway",Font.BOLD,16));
        married.setBounds(260,380,120,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setFont(new Font("Railway",Font.BOLD,16));
        unmarried.setBounds(380,380,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        others = new JRadioButton("Others");
        others.setFont(new Font("Railway",Font.BOLD,16));
        others.setBounds(520,380,120,30);
        others.setBackground(Color.white);
        add(others);

        ButtonGroup maritalStatusGrp = new ButtonGroup();
        maritalStatusGrp.add(married);
        maritalStatusGrp.add(unmarried);
        maritalStatusGrp.add(others);


        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(100,430,600,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway",Font.BOLD,16));
        addressTextField.setBounds(260,430,500,30);
        add(addressTextField);


        JLabel city = new JLabel("City :");
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100,480,600,30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD,16));
        cityTextField.setBounds(260,480,500,30);
        add(cityTextField);



        JLabel state = new JLabel("State :");
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100,530,600,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,16));
        stateTextField.setBounds(260,530,500,30);
        add(stateTextField);



        JLabel pinCode = new JLabel("Pin Code :");
        pinCode.setFont(new Font("Railway",Font.BOLD,20));
        pinCode.setBounds(100,580,600,30);
        add(pinCode);

        pinCodeTextField = new JTextField();
        pinCodeTextField.setFont(new Font("Railway",Font.BOLD,16));
        pinCodeTextField.setBounds(260,580,500,30);
        add(pinCodeTextField);



        JButton next = new JButton("Next >>");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(660,640,100,30);
        next.addActionListener(this::actionPerformed);
        add(next);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setLocation(300,10);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formNo = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = dateChooser.getDateEditor().getUiComponent().getToolTipText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }

        String email = emailTextField.getText();
        String maritalStatus = null;
        if (married.isSelected()){
            maritalStatus = "Married";
        }else if (unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }else if (others.isSelected()){
            maritalStatus = "Others";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pinCode = pinCodeTextField.getText();


        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else {
                //Here using Connectivity class to establish the JDBC connection by creating object of connectivity class
                ConnectivityClass c1 = new ConnectivityClass();

                String query = ("insert into signupone values ('" +formNo+ "','" +name+ "','"+fname+ "','"+dob+ "','"+gender+ "','"+email+ "','"+maritalStatus+ "','"+address+ "','"+city+ "','"+state+ "','"+pinCode+ "')");
                c1.statement.executeUpdate(query);

                new SignupTwo(formNo).setVisible(true);
                setVisible(false);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new SignupOne().setVisible(true);// anonymous object
    }


}

