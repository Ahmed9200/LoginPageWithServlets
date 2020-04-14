/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Krm
 */
public class Database {

    public static Connection con;

    public static void setConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "381998SohailaKaram");
        } catch (SQLException var1) {
            System.out.println(var1.getMessage());
        } catch (ClassNotFoundException var2) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, (String) null, var2);
        } catch (InstantiationException var3) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, (String) null, var3);
        } catch (IllegalAccessException var4) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, (String) null, var4);
        }

    }

    public static Customer getCustomerData(Connection connection, String sql) {
        try {

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Customer c = new Customer();

            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setAge(rs.getString("age"));
                c.setEmail(rs.getString("email"));
                c.setFname(rs.getString("fname"));
                c.setLname(rs.getString("lname"));
                c.setPhone(rs.getString("phone"));
                System.out.println("Done add data for customer");
            }
            return c;
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static boolean checkUser(Connection connection, String username, String password) {
        try {
            setConnection();
            Statement statement = connection.createStatement();
            String strCheck = "select * from customer where username= '" + username + "' and password= '" + password + "'";
            statement.executeQuery(strCheck);
            if (statement.getResultSet().next()) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException var4) {
        }

        return false;
    }

}
