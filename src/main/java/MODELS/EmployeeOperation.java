/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import DAO.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafar
 */
public class EmployeeOperation extends Operation {

    static Connection connection;
    static Statement st;

    public static String getTitulaire(String numcompte) {
        connection = Dao.getConnection();
        String req = "select * from client cl,personne p where p.cin=cl.id and cl.numcompte=" + numcompte;
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getString("nom") + " " + res.getString("prenom");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
