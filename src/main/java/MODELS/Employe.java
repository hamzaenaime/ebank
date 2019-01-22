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
public class Employe extends Personne {

    static Dao dao;
    static Statement st;
    static Connection con;

    public static ResultSet getReclamation() {
        dao = new Dao();
        con = dao.getConnection();
        String req = "select * from reclamation";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static void ReclamationTraiter(String id) {
        dao = new Dao();
        con = dao.getConnection();
        String req = "update reclamation set traiter=true where id=" + id;
        try {
            st = con.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
