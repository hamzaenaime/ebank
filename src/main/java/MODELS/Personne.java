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
public class Personne {
    protected static String cin;
    protected static String nom;
    protected static String prenom;
    protected static String date_naissance;
    protected static String address;
    protected static String ville;
    protected static String tel;
    protected static String email;
    protected static String date_creation;
    protected static String last_login;
    protected static Connection conn;
    protected static boolean login;
    protected static Statement st;
    
    public static boolean login(String id, String password){
        try{
            conn = Dao.getConnection();
            Statement p = conn.createStatement();
            String req = "select * from personne where cin='"+id+"'and password='"+password+"'";
            ResultSet res = p.executeQuery(req);
            if (res.next()) {
                cin = res.getString("cin");
                nom = res.getString("nom");
                prenom = res.getString("prenom");
                date_naissance = res.getString("date_naissance");
                address = res.getString("address");
                ville = res.getString("ville");
                tel = res.getString("tel");
                email = res.getString("email");
                date_creation = res.getString("date_creation");
                last_login = String.valueOf(res.getDate("last_login"));
                login = true;
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("SQl error " + ex.getMessage());
        }
        return false;
    }

    public static void createPersonne(String cin, String nom, String prenom, java.sql.Date date_naissance, String address, String ville, String tel, String email, String password, String profession) {
        conn = Dao.getConnection();
        Date date = new Date();
        Date lastLogin;
        lastLogin = new java.sql.Date(date.getYear(), date.getMonth(), date.getDate());
        String req = "insert into personne (cin,nom,prenom,date_naissance,address,ville,tel,email,password,last_login)"
                + "values (?,?,?,?,?,?,?,?,?,now())";
        try {
            PreparedStatement prep = conn.prepareStatement(req);
            prep.setString(1, cin);
            prep.setString(2, nom);
            prep.setString(3, prenom);
            prep.setDate(4, (java.sql.Date) date_naissance);
            prep.setString(5, address);
            prep.setString(6, ville);
            prep.setString(7, tel);
            prep.setString(8, email);
            prep.setString(9, password);
            //prep.setString(10, profession);

            prep.execute();
        } catch (SQLException ex) {
            System.err.println("Echec de la création du nouveau personne" + ex.getMessage());
        }        
    }
    

    public static int getPoste() {
        if(isDirector()) {
            new Director();
            return 3;
        }
        else if(isEmploye()){
            new Employe(); 
            return 2;
        }
        else{
            new Client();
            return 1;//isClient for sure
        }
    }
    
    public static boolean isDirector(){
        //no table for directors
        //in table agence there is a field id_director to identify director from employee 
        String req = "select * from agence where id_directeur='" +cin+"'";
        conn = Dao.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if(res.next())    return true;
        } catch (SQLException ex) {
            return false;
        }
        return false;    
    }

    public static boolean isEmploye(){
        //this function will be executed after isDirector() to ensure that employe found in this table is a normal employee not a director 
        String req = "select * from employe where id ='" +cin + "'";
        conn = Dao.getConnection();
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next())    return true;
        } catch (SQLException ex) {
            return false;
        }
        return false;    
    }

    public static boolean cinExist(String cin){
        String req = "select * from client where cin ='" + cin + "'";
        conn = Dao.getConnection();
        try {
            st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*public void passwordReset(int numcompte, String password) {
        String req = "update Client set password='" + password + "' where cin=(select cin from compte where numcompte=" + numcompte + ")";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println("problem sql !!" + ex.getMessage());
        }
    }   

    public Boolean cinExist(String cin) {
        String req = "select * from Client where cin='" + cin + "'";
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
     */
    //i choose to seperate update methodes
    // every field in Client has its own update methode
    //fields that can update are
    /*
        nom prenom date_naissance address ville tel email password profession
     */
    //a user can't change cin / numcompte
    //
    /*public void updateNom(String cin) {

    }*/
    public static boolean isLogin() {
        return login;
    }

    public static String getNom() {
        return nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static String getCin() {
        return cin;
    }

    public static String getDate_naissance() {
        return date_naissance;
    }

    public static String getAdresse() {
        return address;
    }

    public static String getVille() {
        return ville;
    }

    public static String getTel() {
        return tel;
    }

    public static String getEmail() {
        return email;
    }

    public static String getCreated_at() {
        return date_creation;
    }

    public static String getLast_login() {
        return last_login;
    }

    public static Connection getConn() {
        return conn;
    }

    public static boolean setAdresse(String address) {
        String req = "update client set address='" + address + "' where cin='" + cin + "'";
        try {
            Statement st = conn.createStatement();
            int res = st.executeUpdate(req);
            if (res > 0) {
                Client.address = address;
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public static boolean setVille(String ville) {
        String req = "update client set ville='" + ville + "' where cin='" + cin + "'";
        try {
            Statement st = conn.createStatement();
            int res = st.executeUpdate(req);
            if (res > 0) {
                Client.ville = ville;
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public static boolean verifyPass(String pass) {
        String req = "select cin from client where cin='" + cin + "' and password='" + pass + "'";
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public static boolean setPassword(String pass) {
        String req = "update client set password='" + pass + "' where cin='" + cin + "'";
        try {
            Statement st = conn.createStatement();
            int res = st.executeUpdate(req);
            if (res > 0) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }


}
