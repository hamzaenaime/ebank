package MODELS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author hamza
 */
public class Account {

    private static Connection connection;
    private static Statement st;
    private static long numAccount;
    private static Dao Dao = new Dao();
    
    public Account() {
        connection = Dao.getConnection();
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery("select numcompte from client where id= '" + Client.getCin() + "'");
            if (res.next()) {
                numAccount = res.getLong(1);
            }
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Probleme " + ex.getMessage());
        }
    }

    public static long createAccount() throws SQLException {
        connection = Dao.getConnection();
            st = connection.createStatement();
            ResultSet res = st.executeQuery("insert into compte default values RETURNING numcompte");
            if (res.next()) {
                numAccount = res.getLong(1);
                return numAccount;
            }
        return 0;
    }

    public static Boolean isActive(String cin) {
        connection = Dao.getConnection();
        String req = "select * from compte cp inner join client cl on cp.numcompte=cl.numcompte where cl.id='" + cin + "' and active is true";
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            return res.next();
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static Boolean AccountActive(String numcompte) {
        connection = Dao.getConnection();
        
        try {
            if (numcompte.matches("[0-9]+")){
                String req = "select * from compte where numcompte=" + numcompte + " and active is true";
                st = connection.createStatement();
                ResultSet res = st.executeQuery(req);
                return res.next();
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void debiter(float mnt, int numCompte) throws AccountException {
        if (!Account.AccountActive("" + numCompte)) {
            throw new AccountException("Compte n'est pas active ");
        }

        if (mnt < 0) {
            throw new AccountException("Montant Negative");
        }

        float solde = Account.getSolde(numCompte);
        if (solde - mnt < 0) {
            throw new AccountException("Solde Insuffisant");
        }

        connection = Dao.getConnection();
        String req = "update compte set solde=solde-" + mnt + " where numcompte='" + numAccount + "'";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("probleme dans la requtte de mise à jour => " + ex.getMessage());
        }
    }

    public static void crediter(float mnt, int numCompte) throws AccountException {
        if (!Account.AccountActive("" + numCompte)) {
            throw new AccountException("Compte n'est pas active ");
        }

        if (mnt < 0) {
            throw new AccountException("Montant Negative");
        }
        connection = Dao.getConnection();
        String req = "update compte set solde=solde+" + mnt + " where numcompte='" + numCompte + "'";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println("probleme dans la requtte de mise à jour => " + ex.getMessage());
        }
    }

    public static float getSolde(int numAccount) {
        connection = Dao.getConnection();
        String req = "select solde from compte where numCompte='" + numAccount + "'";
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

    public static float getSolde() {
        connection = Dao.getConnection();
        String req = "select solde from compte where numCompte='" + numAccount + "'";
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

    public static void confirmer(String numcompte) {
        connection = Dao.getConnection();
        String req = "update compte set active=true where numcompte=" + numcompte;
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] getAccounts(String cin) {
        /*connection = Dao.getConnection();
        String req = "select numCompte from compte cm inner join client cl on  cm.numcompte=cl.numcompte where cl.id='" + cin + "'";
        Vector<String> accounts=new Vector<>();
        try {
            st = connection.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                accounts.add(Long.toString(res.getLong(1)));
            }
            return accounts.toArray(new String[accounts.size()]);
        } catch (SQLException ex) {
            return null;
        }*/
        return new String[]{Long.toString(Account.getNumAccount())};
    }

    public static long getNumAccount() {
        return numAccount;
    }

}
