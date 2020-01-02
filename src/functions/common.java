/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;
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

/**
 *
 * @author root
 */
public class common {
  static public String DB_URL = "jdbc:mysql://localhost:3306/MilkanDatabase";
  static public String DB_DRV = "com.mysql.jdbc.Driver";
  static public String DB_USER = "root";
  static public String DB_PASSWD = "mysqlroot";
}
