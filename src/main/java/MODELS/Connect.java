/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import DAO.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hamza
 */
public class Connect {

    private static Dao dao = new Dao();

    public static boolean exist(String email, String password) {
        try {
            Connection conn = Dao.getConnection();
            PreparedStatement p = conn.prepareStatement("select * from client where email=? and password =?");
            p.setString(1, email);
            p.setString(2, password);
            ResultSet res = p.executeQuery();
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("SQl error " + ex.getMessage());
        }
        return false;
    }
}
