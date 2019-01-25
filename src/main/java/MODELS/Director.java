/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import DAO.Dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafar
 */
public class Director extends Employe {
    
    static Dao dao;
    static Statement st;
    static Connection con;
    
    public static ResultSet getEmployees() {
        dao = new Dao();
        con = dao.getConnection();
        String req = "select\n"
                + "	p.cin,p.nom,p.prenom,p.date_naissance,p.address,p.ville,p.tel,p.email,p.last_login,em.salaire,ag.nom,ag.addresse,ag.ville\n"
                + "	from agence ag, personne p,employe em where em.id=p.cin and em.id_agence=ag.id ;";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //createPersonne() {

    public static void addEmploye(String cin, String nom, String prenom, String date_naissance, String address, String ville, String tel, String email, String password, String title, String idagance, float salaire) {
        dao = new Dao();
        con = dao.getConnection();
        Personne.createPersonne(cin, nom, prenom, date_naissance, address, ville, tel, email, password, title, "");
        Employe.addEmployee(cin, cin, idagance, salaire);
        
    }
}
