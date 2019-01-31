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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafar
 */
public class Personne {

    protected static String cin;
    protected static String title;
    protected static String nom;
    protected static String prenom;
    protected static String date_naissance;
    protected static String address;
    protected static String ville;
    protected static String tel;
    protected static String email;
    protected static String password;
    protected static String date_creation;
    protected static String last_login;
    protected static Connection conn;
    protected static boolean login;
    protected static Statement st;
    private static Dao Dao = new Dao();
    
    
    public static boolean login(String id, String password) throws SQLException {
        conn = Dao.getConnection();
        Statement p = conn.createStatement();
        String req = "select * from personne where cin='" + id + "'and password='" + password + "'";
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
            title = res.getString("title");
            date_creation = res.getString("date_creation");
            last_login = res.getString("last_login");
            login = true;
            return true;
        }
        return false;
    }

    public static void logout() {
        setLastLogin();
        login = false;
    }

    public static void setLastLogin() {
        conn = Dao.getConnection();
        String req = "update personne set last_login=now() where cin='" + cin + "'";
        try {
            st = conn.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println("problem sql !!" + ex.getMessage());
        }
    }

    public static void createPersonne(String cin, String nom, String prenom, String date_naissance, String address, String ville, String tel, String email, String password, String title) throws SQLException, ParseException {
        conn = Dao.getConnection();
        String req = "insert into personne (cin,nom,prenom,date_naissance,address,ville,tel,email,password,title,last_login)"
                + "values (?,?,?,?,?,?,?,?,?,?::titleenum,now())";
        Date formate = new SimpleDateFormat("yyyy-MM-dd").parse(date_naissance);
        java.sql.Date aDate = new java.sql.Date(formate.getTime());
        PreparedStatement prep = conn.prepareStatement(req);
        prep.setString(1, cin);
        prep.setString(2, nom);
        prep.setString(3, prenom);
        prep.setDate(4, aDate);
        prep.setString(5, address);
        prep.setString(6, ville);
        prep.setString(7, tel);
        prep.setString(8, email);
        prep.setString(9, password);
        prep.setString(10, title);
        prep.execute();
    }

    public static void createPersonne() throws ParseException, SQLException {
        conn = Dao.getConnection();
        String req = "insert into personne (cin,nom,prenom,date_naissance,address,ville,tel,email,password,title,last_login)"
                + "values (?,?,?,?,?,?,?,?,?,?::titleenum,now())";
        Date formate = new SimpleDateFormat("yyyy-MM-dd").parse(date_naissance);
        java.sql.Date aDate = new java.sql.Date(formate.getTime());
        PreparedStatement prep = conn.prepareStatement(req);
        prep.setString(1, cin);
        prep.setString(2, nom);
        prep.setString(3, prenom);
        prep.setDate(4, aDate);
        prep.setString(5, address);
        prep.setString(6, ville);
        prep.setString(7, tel);
        prep.setString(8, email);
        prep.setString(9, password);
        prep.setString(10, title);
        prep.execute();
    }

    public static int getPoste() {
        if (isDirector()) {
            new Director();
            return 3;
        } else if (isEmploye()) {
            new Employe();
            return 2;
        } else {
            new Client();
            return 1;//isClient for sure
        }
    }

    public static String getNomPrenom(String cin) throws SQLException {
        conn = Dao.getConnection();
        String req = "select * from personne where cin='" + cin + "'";
        String nomprenom = "";
        st = conn.createStatement();
        ResultSet res = st.executeQuery(req);
        if (res.next()) {
            return res.getString(2) + " " + res.getString(3);
        }
        return "nothing";
    }

    public static boolean isDirector() {
        //no table for directors
        //in table agence there is a field id_director to identify director from employee 
        String req = "select * from agence where id_directeur='" + cin + "'";
        conn = Dao.getConnection();
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

    public static boolean isEmploye() {
        //this function will be executed after isDirector() to ensure that employe found in this table is a normal employee not a director 
        String req = "select * from employe where id ='" + cin + "' and id_employeur is not null";
        conn = Dao.getConnection();
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

    public static boolean cinExist(String cin) {
        String req = "select * from personne where cin ='" + cin + "'";
        conn = Dao.getConnection();
        try {
            st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                System.out.println(cin + " exist");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static boolean cinMatchTel(String cin, String tel) {
        String req = "select * from Personne where cin ='" + cin + "' and tel='0" + tel + "'";
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

    public static void passwordReset(String cin, String password) {
        String req = "update personne set password='" + password + "' where cin='" + cin + "'";
        conn = Dao.getConnection();
        try {
            st = conn.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.err.println("problem sql !!" + ex.getMessage());
        }
    }

    public static String getEmail(String cin) {
        String req = "select * from Personne where cin ='" + cin + "'";
        conn = Dao.getConnection();
        try {
            st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getString("email");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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

    public static String getTitle() {
        return title;
    }

    public static void setAddress(String address) {
        Personne.address = address;
    }

    public static void setDate_naissance(String date_naissance) {
        Personne.date_naissance = date_naissance;
    }

    public static void setEmail(String email) {
        Personne.email = email;
    }

    public static void setNom(String nom) {
        Personne.nom = nom;
    }

    public static void setPrenom(String prenom) {
        Personne.prenom = prenom;
    }

    public static void setTel(String tel) {
        Personne.tel = tel;
    }

    public static void setTitle(String title_) {
        Personne.title = title;
    }

    public static void setCin(String cin_) {
        Personne.cin = cin_;
    }

    public static void setVille(String ville_) {
        Personne.ville = ville_;
    }

    public static void setPassword(String pass) {
        Personne.password = pass;
    }

    public static boolean updateAdresse(String address) {
        String req = "update Personne set address='" + address + "' where cin='" + cin + "'";
        try {
            Statement st = conn.createStatement();
            int res = st.executeUpdate(req);
            if (res > 0) {
                Client.address = address;
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public static boolean updateVille(String ville) {
        String req = "update Personne set ville='" + ville + "' where cin='" + cin + "'";
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
        String req = "select cin from Personne where cin='" + cin + "' and password='" + pass + "'";
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

    public static boolean updatePassword(String pass) {
        String req = "update Personne set password='" + pass + "' where cin='" + cin + "'";
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

    public static int personneCount() {
        conn = Dao.getConnection();
        String req = "select count(*) from personne";
        try {
            st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    public static double sexePourcentage(String sexe) {
        conn = Dao.getConnection();
        String req = "select count(*) from personne where title='" + sexe + "'";
        try {
            double count = new Double(Personne.personneCount());
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getInt(1) / count;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    public static int ageCount(String year) {
        conn = Dao.getConnection();
        String req = "select  count(p.*) from personne p where to_char(p.date_naissance, 'YYYY') = '" + year + "';";
        try {
            st = conn.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
