/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import static MODELS.Personne.conn;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;

/**
 *
 * @author nafar
 */
public class Client extends Personne {

    public static void createClient(String cin, String nom, String prenom, String date_naissance, String address, String ville, String tel, String email, String password, String title, long numAccount) throws SQLException, ParseException {
        createPersonne(cin, nom, prenom, date_naissance, address, ville, tel, email, password, title);
        st = conn.createStatement();
        st.executeUpdate("insert into client values ('" + cin + "','" + numAccount + "')");
    }

    public static void createClient(long numAccount) throws SQLException, ParseException {
        createPersonne();
        st = conn.createStatement();
        st.executeUpdate("insert into client values ('" + cin + "'," + numAccount + ")"); 
        
    }

    
    public boolean telCorrespondToNumCompte(String numcompte, String tel) {
        return false;
    }

    public static void getAllAccount() {
        //select numCompte from assoc_compte_client where id_client='" + cin + "'
    }

}
