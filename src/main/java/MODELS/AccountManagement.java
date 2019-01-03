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

    private Dao dao;
    private Connection connection;
    private Statement st;
    private static int numcompte = 1;

    public AccountManagement() {
        dao = new Dao();
        connection = dao.getConnection();

    }

    public void createAccount(String cin, String nom, String prenom, java.sql.Date date_naissance, String address, String ville, String tel, String email, String password, String profession) {
        // note that we've to add the numCompte to our database /* important */
        java.util.Date date = new java.util.Date();
        java.sql.Date createdAt, lastLogin;
        lastLogin = createdAt = new java.sql.Date(date.getYear(), date.getMonth(), date.getDate());
        String req = "insert into client values('" + cin + "','" + nom + "','" + prenom + "','" + date_naissance + "','" + address + "','" + ville + "','" + tel + "','" + email + "','" + password + "','" + createdAt + "','" + lastLogin + "','" + profession + "');";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un client !! " + ex.getMessage());
        }
        String req2 = "insert into compte(numcompte,owner,solde,active) values(" + numcompte + ",'" + cin + "',0,false)";
        try {
            st = connection.createStatement();
            st.executeUpdate(req2);
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un compte !! " + ex.getMessage());
        }
        String req3 = "insert into comptecourant values(" + numcompte + ",0)";
        try {
            st = connection.createStatement();
            st.executeUpdate(req3);
            numcompte++;
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un compte courant !! " + ex.getMessage());
        }

    }

    public void passwordReset(int numcompte, String password) {
        String req = "update client set password='" + password + "' where cin=(select cin from compte where numcompte=" + numcompte + ")";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println("problem sql !!" + ex.getMessage());
        }
    }

    public Boolean NumCompteExist(int numcompte) {
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

    public Boolean cinExist(String cin) {
        String req = "select * from client where cin='" + cin + "'";
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

    //i choose to seperate update methodes
    // every field in client has its own update methode
    //fields that can update are
    /*
        nom prenom date_naissance address ville tel email password profession
     */
    //a user can't change cin / numcompte
    //
    public void updateNom(String cin) {

    }
}
