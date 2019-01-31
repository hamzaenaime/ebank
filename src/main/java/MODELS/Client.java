/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import static MODELS.Personne.conn;
import java.sql.SQLException;
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
        long numAccount = Account.createAccount();
            if (numAccount == -1) {
                JOptionPane.showInputDialog("Error, lors de création du compte");
            } else {
                Client.createClient((int) numAccount);
            }
    }
    
    public static void createClient(String cin, String nom, String prenom, String date_naissance, String address, String ville, String tel, String email, String password, String profession, String title, long numAccount) {
        try {
            createPersonne(cin, nom, prenom, date_naissance, address, ville, tel, email, password, title, profession);
            st = conn.createStatement();
            st.executeUpdate("insert into client values ('" + cin + "','" + numAccount + "')");
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un client !! " + ex.getMessage());
        }
    }

    public static void createClient(int numAccount) {
        try {
            createPersonne();
            st = conn.createStatement();
            st.executeUpdate("insert into client values ('" + cin + "','" + numAccount + "')");
        } catch (SQLException ex) {
            System.err.println("probleme dans la requette d'ajouter un client !! " + ex.getMessage());
        }
    }

    
    public boolean telCorrespondToNumCompte(String numcompte, String tel) {
        return false;
    }

    public static void getAllAccount() {
        //select numCompte from assoc_compte_client where id_client='" + cin + "'
    }

}
