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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hamza
 */
public class Account {

    private static Connection connection;
    private static Statement st;
    private static long numAccount;

    public Account(){
    connection = Dao.getConnection();
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery("select numcompte from compte cm inner join client cl on cm.numcompte=cl.numcompte where cin= '"+Client.getCin()+"'");
            if(res.next()){
                numAccount = res.getLong(1);
            }
        } catch (SQLException ex) {
                System.err.println("Probleme" + ex.getMessage());
        }
    }
    
    public static long createAccount() {
        connection = Dao.getConnection();
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery("insert into compte default values RETURNING numcompte");
            if(res.next()){
                numAccount = res.getLong(1);
                return numAccount;
            }
        } catch (SQLException ex) {
                System.err.println("probleme dans la requette d'ajouter un client !! " + ex.getMessage());
        }
        return -1;
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

    public static void associate(String cin) {
        try {
            st = connection.createStatement();
            st.executeUpdate("insert into assoc_compte_client (numcompte,id_client) values('"+numAccount+"','"+cin+"')");
        } catch (SQLException ex) {
                System.err.println("probleme dans la requette d'ajouter un compte courant !! " + ex.getMessage());
            }
        }

    public static float getSolde() {
        connection = Dao.getConnection();
        String req = "select solde from compte where numCompte='"+numAccount+"'";
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getFloat(1);
            }
        } catch (SQLException ex) {
        }
        return -1;
    }
    

    public static float getSolde(int numAccount) {
        connection = Dao.getConnection();
        String req = "select solde from compte where numCompte='"+numAccount+"'";
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getFloat(1);
            }
        } catch (SQLException ex) {
        }
        return -1;
    }
    
    public static String[] getAccounts(String cin) {
        /*connection = Dao.getConnection();
        String req = "select numCompte from assoc_compte_client where id_client='" + cin + "')";
        Vector<String> accounts=new Vector<>();
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                accounts.add(String.valueOf(res.getInt(0)));
            }
            return accounts.toArray(new String[accounts.size()]);
        } catch (SQLException ex) {
            return null;
        }*/
        return new String[]{"48484884","188112","495132"};
    }
}
