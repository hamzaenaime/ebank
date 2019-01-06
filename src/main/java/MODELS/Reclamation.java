/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import DAO.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author nafar
 */
public class Reclamation {
    private static Connection conn;
    
    public static boolean create(String objet, String desc){
        conn = Dao.getConnection();
        String req = "insert into reclamation (owner,objet,description) values (?,?,?)";
        try {
            PreparedStatement prep = conn.prepareStatement(req);
            prep.setString(1, Client.getCin());
            prep.setString(2, objet);
            prep.setString(3, desc);
            int action=prep.executeUpdate();
            return action > 0;           
        } catch (SQLException ex) {
            return false;
        }
    }
}
