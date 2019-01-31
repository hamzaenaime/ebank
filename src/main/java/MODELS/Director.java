/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import DAO.Dao;
import Exceptions.EmployeException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
                + "	p.cin,p.nom,p.prenom,p.date_naissance,p.address,p.ville,p.tel,p.email,em.salaire,ag.nom\n"
                + "	from agence ag, personne p,employe em where em.id=p.cin and em.id_agence=ag.id and em.id_employeur is not null ;";
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

    public static void addEmploye(String cin, String nom, String prenom, String date_naissance, String address, String ville, String tel, String email, String password, String title, String agance, String salaire) throws EmployeException, SQLException, ParseException {
        if (!Personne.cinExist(cin)) {
            Personne.createPersonne(cin, nom, prenom, date_naissance, address, ville, tel, email, password, title);
            System.out.println(" executed");
        }
        Employe.addEmployee(cin, cin, agance, salaire);

    }

    public static ResultSet getAgences() {
        String req = "select * from agence;";
        dao = new Dao();
        con = dao.getConnection();

        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String getIdAgence(String nom) {
        String req = "select * from agence where nom='" + nom + "'";
        String id;
        dao = new Dao();
        con = dao.getConnection();

        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
