/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;
import java.lang.System;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class iofunctions {
// function for print string  
    public void o(String s)
    {
        System.out.print(s);
    }
  
// function for input of string  
    public String i()
    {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        return s;
    }
//function for input of Integer
    public Integer in()
    {
        Scanner scan = new Scanner(System.in);
        Integer s = scan.nextInt();
        return s;
    }
    public void alert(String s)
    {
           JOptionPane.showMessageDialog(null, 
                              s, 
                              "ALERT", 
                              JOptionPane.WARNING_MESSAGE);
        
    }
}

