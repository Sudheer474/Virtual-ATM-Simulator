package com.bank.managemennt.system;

import java.sql.*;

public class ConnectivityClass {

    //Global var
    Connection connection;
    Statement statement;

    public ConnectivityClass(){
        try {
            //Establishing connection
            String url = "jdbc:mysql://localhost:3306/bankmanagementsystem";
            String username = "root";
            String password = "Robot@2001";

            Class.forName("com.mysql.cj.jdbc.Driver"); //OR "com.mysql.jdbc.Driver"

            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
