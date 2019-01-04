package MODELS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AccountManagement {

    private static Connection connection;
    private static Statement st;

    public void createAccount(String cin, String nom, String prenom, java.sql.Date date_naissance, String address, String ville, String tel, String email, String password, String profession) {
        
        // note that we've to add the numCompte to our database /* important */
        client.createClient(cin,nom,prenom,date_naissance,address,ville,tel,email,password,profession);
        
        connection=Dao.getConnection();
        
        String req = "insert into compte(owner) values('" + cin + "',0)";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println("Echec de création de compte " + ex.getMessage());
        }        
        /*String req3 = "insert into comptecourant values(0)";
        try {
            st = connection.createStatement();
            st.executeUpdate(req3);
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un compte courant !! " + ex.getMessage());
        }*/
    }

    public static Boolean AccountExist(int numcompte) {
        connection = Dao.getConnection();
        String req = "select * from compte where numcompte=" + numcompte;
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public static float getSolde(String cin){
    connection = Dao.getConnection();
        String req = "select solde from compte where owner='" +cin+"'";
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
        
    }
}
