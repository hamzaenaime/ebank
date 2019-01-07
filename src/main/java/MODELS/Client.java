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
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafar
 */
public class Client extends Personne{
    
<<<<<<< HEAD
    public static void createClient(String cin, String nom, String prenom, java.sql.Date date_naissance, String address, String ville, String tel, String email, String password, String profession) {
        
        createPersonne(cin, nom, prenom, date_naissance, address, ville, tel, email, password, profession);
        try {
            st = conn.createStatement();
            st.executeUpdate("insert into client values id='"+cin+"'");
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un client !! " + ex.getMessage());
        }        
    }
    
=======
>>>>>>> 1d248ccf8cec442e56a490bd85df0f76a7712025
}
