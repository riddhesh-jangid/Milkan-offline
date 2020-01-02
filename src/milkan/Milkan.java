/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milkan;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import functions.iofunctions;
import gui.createOwnerAccount;
import gui.login;
import functions.common;
/**
 *
 * @author Riddhesh
 */
public class Milkan {
    public static void main(String[] args) {
       iofunctions io = new iofunctions();
       createOwnerAccount createowneraccount = new createOwnerAccount();
       login login = new login();         
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try
        {
            connection = DriverManager.getConnection(common.DB_URL,common.DB_USER,common.DB_PASSWD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from owner");
            login.show();
            connection.close();
        }
        catch(SQLException e)
        {
           createowneraccount.show();
           io.o("catch");
        }
    }
    
}
    

