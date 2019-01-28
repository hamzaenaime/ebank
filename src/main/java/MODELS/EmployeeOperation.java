/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import DAO.Dao;
import Exceptions.AccountException;
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

    public static void createEmployerOperation(int compte_dst, String motif, String cin_emp, String cin, String nom, String prenom, float montant) {
        //15 à changer
        int numoperation = Operation.createOperation(15, compte_dst, motif, montant);
        connection = Dao.getConnection();
        String req = "insert into operation_employe values(" + numoperation + ",'" + cin_emp + "','" + cin + "','" + nom + "','" + prenom + "')";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Account.crediter(montant, compte_dst);
        } catch (AccountException ex) {
            Logger.getLogger(EmployeeOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
