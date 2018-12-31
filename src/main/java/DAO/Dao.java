
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
    private static String url = "jdbc:postgresql://ec2-46-137-99-175.eu-west-1.compute.amazonaws.com:5432/dfl1ouqpq4djuc?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
    private static String username = "krvxwoxrqrqrlv";
    private static String password = "f3b61448d29137faef397b3f495a4dacd8662a95fbe070df8b7a4ea4dfdc2410";
    private static Connection connection;

    public Dao() {
        try {
            System.out.println("connection...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("every thing is ok *_* !!! ");
        } catch (SQLException ex2) {
            /*System.out.println("switched to local database server");
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ebank", "postgres", "bilal123");
                System.out.println("every thing is ok *_* !!! ");
            }catch (SQLException ex) {
                System.err.println("problem de connection  " + ex.getMessage());
            }*/
            System.out.println("problem de connection  !! " + ex2.getMessage());
        }

    }

    public static Connection getConnection() {
        return connection;
    }

}
