/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.ACCOUNT;

import java.sql.Date;

/**
 *
 * @author hamza
 */
public class State {

    private static String cin = "";
    private static String nom = "";
    private static String prenom = "";
    private static Date date_naissance = new Date(1950 - 1900, 0, 1);
    private static String adresse = "";
    private static String ville = "";
    private static String tel = "";
    private static String email = "";
    private static String password;
    private static Date created_at;
    private static Date last_login;
    private static String num_compte;
    private static Date date_ouverture;//to be removed cause it's value is inserted by default
    private static Boolean active;
    private static String date_fermeture;
    private static String profession;

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

    public static Date getCreated_at() {
        return created_at;
    }

    public static void setCreated_at(Date created_at) {
        State.created_at = created_at;
    }

    public static Date getLast_login() {
        return last_login;
    }

    public static void setLast_login(Date last_login) {
        State.last_login = last_login;
    }

    public static String getNum_compte() {
        return num_compte;
    }

    public static void setNum_compte(String num_compte) {
        State.num_compte = num_compte;
    }

    public static Date getDate_ouverture() {
        return date_ouverture;
    }

    public static void setDate_ouverture(Date date_ouverture) {
        State.date_ouverture = date_ouverture;
    }

    public static Boolean getActive() {
        return active;
    }

    public static void setActive(Boolean active) {
        State.active = active;
    }

    public static String getDate_fermeture() {
        return date_fermeture;
    }

    public static void setDate_fermeture(String date_fermeture) {
        State.date_fermeture = date_fermeture;
    }

}
