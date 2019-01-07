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
public class Account {

    private static Connection connection;
    private static Statement st;
<<<<<<< HEAD
    private static int numAccount;

    public static boolean createAccount() {
        connection = Dao.getConnection();
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery("insert into compte default values RETURNING numcompte");
            if(res.next()){
                numAccount = res.getInt(1);
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
=======

    public void createAccount(String cin, String nom, String prenom, java.sql.Date date_naissance, String address, String ville, String tel, String email, String password, String profession) {

        // note that we've to add the numCompte to our database /* important */
        Client.createClient(cin, nom, prenom, date_naissance, address, ville, tel, email, password, profession);

        connection = Dao.getConnection();

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
>>>>>>> 1d248ccf8cec442e56a490bd85df0f76a7712025
    }

    public static Boolean AccountExist(String numcompte) {
        connection = Dao.getConnection();
        String req = "select * from compte where numcompte=" + numcompte;
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

<<<<<<< HEAD
    public static void associate(String cin) {
        try {
            st = connection.createStatement();
            st.executeUpdate("insert into assoc_compte_client (numcompte,id_client) values('"+numAccount+"','"+cin+"')");
        } catch (SQLException ex) {
                System.err.println("probleme dans la requette d'ajouter un compte courant !! " + ex.getMessage());
            }
        }

=======
>>>>>>> 1d248ccf8cec442e56a490bd85df0f76a7712025
    public float getSolde(String cin) {
        connection = Dao.getConnection();
        String req = "select solde from compte where id_client='" + cin + "'";
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }
}
