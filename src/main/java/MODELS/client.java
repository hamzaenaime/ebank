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

/**
 *
 * @author nafar
 */
public class client {
   private static String cin; 
   private static String nom;
   private static String prenom;
   private static String date_naissance;
   private static String adresse;
   private static String ville;
   private static String tel;
   private static String email;
   private static String created_at;
   private static String last_login;
   private static String profession;
   private static Connection conn;
   private static boolean login;
   
    public static boolean login(String numAccount, String password){
     try {
            conn = Dao.getConnection();
            Statement p = conn.createStatement();
            String req = "select nom,prenom from client cl inner join compte cm on cl.cin=cm.owner where numcompte='"+numAccount+"' and password='" + password + "'";
            ResultSet res = p.executeQuery(req);
            if (res.next()) {
                cin=res.getString("cin");
                nom=res.getString("nom");
                prenom=res.getString("prenoù");
                date_naissance=res.getString("date_naissance");
                adresse=res.getString("adresse");
                ville=res.getString("ville");
                tel=res.getString("tel");
                email=res.getString("email");
                created_at=res.getString("created_at");
                last_login=String.valueOf(res.getDate("last_login"));
                profession=res.getString("profession");
                login=true;
                return true;
            }
        } catch (SQLException ex) {
            System.err.println("SQl error " + ex.getMessage());
        }
        return false;
    }
    
   public static void createClient(String cin, String nom, String prenom, Date date_naissance, String address, String ville, String tel, String email, String password, String profession){
        conn=Dao.getConnection();
        Date date = new Date();
        Date lastLogin;
        lastLogin = new java.sql.Date(date.getYear(), date.getMonth(), date.getDate());
        String req = "insert into client (cin,nom,prenom,date_naissance,address,ville,tel,email,password,lastLogin,profession) "
                + "values (?,?,?,?,?,?,?,?,?,?,now())";
        try {
            PreparedStatement prep = conn.prepareStatement(req);
            prep.setString(1,cin);
            prep.setString(2,nom);
            prep.setString(3,prenom);
            prep.setDate(4, (java.sql.Date) date_naissance);
            prep.setString(5,address);
            prep.setString(6,ville);
            prep.setString(7,tel);
            prep.setString(8,email);
            prep.setString(9,password);
            prep.setString(10,profession);

            prep.execute();
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un client !! " + ex.getMessage());
        }
   }  
    /*public void passwordReset(int numcompte, String password) {
        String req = "update client set password='" + password + "' where cin=(select cin from compte where numcompte=" + numcompte + ")";
        try {
            st = connection.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println("problem sql !!" + ex.getMessage());
        }
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
*/
    //i choose to seperate update methodes
    // every field in client has its own update methode
    //fields that can update are
    /*
        nom prenom date_naissance address ville tel email password profession
     */
    //a user can't change cin / numcompte
    //
    /*public void updateNom(String cin) {

    }*/

    public static boolean isLogin(){
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
        return adresse;
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
        return created_at;
    }

    public static String getLast_login() {
        return last_login;
    }

    public static String getProfession() {
        return profession;
    }

    public static Connection getConn() {
        return conn;
    }
    
}
