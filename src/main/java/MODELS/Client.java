/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import java.sql.SQLException;

/**
 *
 * @author nafar
 */
public class Client extends Personne {

    public static void createClient(String cin, String nom, String prenom, String date_naissance, String address, String ville, String tel, String email, String password, String profession, String title, long numAccount) {

        try {
            createPersonne(cin, nom, prenom, date_naissance, address, ville, tel, email, password,title, profession);
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
