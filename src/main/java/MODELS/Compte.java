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
 * @author hamza
 */
public class Compte {

    private static Connection connection;
    private static Statement st;
    private static Dao dao = new Dao();

    public static int nbCompte(String mois) {
        connection = dao.getConnection();
        String req = "select  count(c.*) from compte c where to_char(c.date_ouverture, 'MM') = '" + mois + "';";
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
