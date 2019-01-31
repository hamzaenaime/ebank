/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import static MODELS.Personne.conn;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nafar
 */
public class Client extends Personne {

    /*
    public static boolean login(String id, String password) {
        if (Personne.login(id, password) && Account.isActive(cin)) {
            return true;
        }
        return false;
    }*/
    //select * from compte cp inner join client cl on cp.numcompte=cl.numcompte where cl.id='tt' and active is false;

    public static void store() {
        try{
            long numAccount = Account.createAccount();
            createClient(numAccount);
        }catch(SQLException|ParseException ex){
            JOptionPane.showInputDialog("Erreur lors de création du compte");
        }
    }    
    
    public static void createClient(String cin, String nom, String prenom, String date_naissance, String address, String ville, String tel, String email, String password, String profession, String title, long numAccount) throws SQLException {
        try{
            createPersonne(cin, nom, prenom, date_naissance, address, ville, tel, email, password, title, profession);
            st = conn.createStatement();
            st.executeUpdate("insert into client values ('" + cin + "','" + numAccount + "')");
        } catch (ParseException ex) {
            JOptionPane.showInputDialog("Erreur lors de création du compte");
        }
    }

    public static void createClient(long numAccount) throws SQLException, ParseException {
        try{
            createPersonne();
            st = conn.createStatement();
            st.executeUpdate("insert into client values ('" + cin + "'," + numAccount + ")"); 
        }catch(SQLException ex){
            JOptionPane.showInputDialog("Error, lors de création du compte");
        }                   
    }

    
    public boolean telCorrespondToNumCompte(String numcompte, String tel) {
        return false;
    }

    public static void getAllAccount() {
        //select numCompte from assoc_compte_client where id_client='" + cin + "'
    }

}
