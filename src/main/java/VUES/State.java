/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES;

import MODELS.Account;
import MODELS.Client;
import java.sql.Date;

/**
 *
 * @author hamza
 */
public class State {

    private static String cin = "";
    private static String nom = "";
    private static String prenom = "";
    private static Date date_naissance;
    private static String adresse = "";
    private static String ville = "";
    private static String tel = "";
    private static String email = "";
    private static String password;
    private static String profession;
    private static int check;

    public static int getCheck() {
        return check;
    }

    public static void setCheck(int check) {
        State.check = check;
    }

    public static String getProfession() {
        return profession;
    }

    public static void setProfession(String profession) {
        State.profession = profession;
    }

    public static String getCin() {
        return cin;
    }

    public static void setCin(String cin) {
        State.cin = cin;
    }

    public static String getNom() {
        return nom;
    }

    public static void setNom(String nom) {
        State.nom = nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static void setPrenom(String prenom) {
        State.prenom = prenom;
    }

    public static Date getDate_naissance() {
        return date_naissance;
    }
    public static void setDate_naissance(Date date_naissance) {
        State.date_naissance = date_naissance;
    }

    public static String getAdresse() {
        return adresse;
    }

    public static void setAdresse(String adresse) {
        State.adresse = adresse;
    }

    public static String getVille() {
        return ville;
    }

    public static void setVille(String ville) {
        State.ville = ville;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        State.tel = tel;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        State.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        State.password = password;
    }

    /*

    public static void store() {
        Client.createClient(cin, nom, prenom, date_naissance, adresse, ville, tel, email, password, profession); 
        if(Account.createAccount()) Account.associate(cin);
    }*/
}
