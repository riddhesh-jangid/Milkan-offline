/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
import java.lang.System;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;
import functions.iofunctions;
/**
 *
 * @author root
 */
public class database_functions {
    String dburl = "jdbc:mysql://localhost:3306/MilkanDatabase";
    String dbdriver = "com.mysql.jdbc.Driver";
    String dbuser = "root";
    String dbpassword = "mysqlroot";
    iofunctions io = new iofunctions();
    public database_functions()
    {
        
    }
    
    public int exist(String tablename)
    {
        try
        {
            Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from "+tablename);
            return 1;
        }
        catch(SQLException e)
        {
            return 0;
        }
    }
    
    public int numberofrecords(String tablename)
    {
        int count = 0;
        try
        {
            Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from "+tablename);
            while(resultSet.next())
            {
                count++;
            }
        }
        catch(SQLException e)
        {
            count = 0;
        }
        return count;
    }
    public int numberofrecordsquery(String query)
    {
        int count = 0;
        try
        {
            Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                count++;
            }
            connection.close();
        }
        catch(SQLException e)
        {
            count = 0;
        }
        return count;
    }
    public String create(String query)
    {
        try
        {
          Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
          Statement statement = connection.createStatement();
          statement.execute(query);
          connection.close();
          return "success";
        }
        catch(SQLException e)
        {
          io.o("\n"+e+"\n");  
          return "fail"+e;  
        }
    }
    
    public String[][] retrieve(String query,int size)
    {
       int totalrecords = numberofrecordsquery(query),i;
       /*Checks if their are no entry in tables*/
       if (totalrecords == 0)
       {
           String[][] error = new String[1][1];
           error[0][0] = "noentry";
           return error;
       }
       /*Retrieve data from table*/
       String[][] result = new String[totalrecords][]; 
       for (i=0; i<totalrecords ; i++)
       {
           result[i] = new String[size];
       }
       try
        {
          Connection connection = DriverManager.getConnection(dburl,dbuser,dbpassword);
          Statement statement = connection.createStatement();
          ResultSet resultSet = statement.executeQuery(query);
          int row = 0;
          while(resultSet.next())
          {
              for(i=0 ; i<size ; i++)
              {
                 result[row][i] = resultSet.getString(i+1);
              }
              row++;        
          }
          connection.close();
        }
        catch(SQLException e)
        {
           
        }
        return result;
    }
/*END OF database_functions CLASS*/
}
