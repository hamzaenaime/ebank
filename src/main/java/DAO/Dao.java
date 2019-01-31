
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

    //private static String pilote = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://ec2-46-137-99-175.eu-west-1.compute.amazonaws.com:5432/dfl1ouqpq4djuc?sslmode=require";
    private static String username = "krvxwoxrqrqrlv";
    private static String password = "f3b61448d29137faef397b3f495a4dacd8662a95fbe070df8b7a4ea4dfdc2410";
    private static Connection connection;

    public Dao() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex2) {
            new VUES.ConnectionFailed().setVisible(true);
        }

    }

    public static Connection getConnection() {
        return connection;
    }

}
