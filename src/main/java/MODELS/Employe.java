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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafar
 */
public class Employe extends Personne {

    static Dao dao;
    static Statement st;
    static Connection con;

    public static ResultSet getReclamation() {
        dao = new Dao();
        con = dao.getConnection();
        String req = "select r.id,r.owner,r.objet,r.description,r.traiter,r.date_creation from reclamation r";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static ResultSet getDemandes() {
        dao = new Dao();
        con = dao.getConnection();
        String req = "select c.numcompte, p.cin,p.nom,p.prenom,p.date_naissance,p.address,p.ville,p.tel,p.email,p.date_creation from personne p, client cl ,compte c where cl.numcompte=c.numcompte and cl.id=p.cin and c.active=false; ";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void ReclamationTraiter(String id) {
        dao = new Dao();
        con = dao.getConnection();
        String req = "update reclamation set traiter=true where id=" + id;
        try {
            st = con.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Boolean EmployeExsite(String cin) {
        dao = new Dao();
        con = dao.getConnection();
        String req = "select * from employe where id='" + cin + "'";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void addEmployee(String cin, String id, String agence, String salaire) throws EmployeException {
        if (EmployeExsite(cin)) {
            throw new EmployeException("cette Employee est deja existe");
        }
        dao = new Dao();
        con = dao.getConnection();
        String idAgence = Director.getIdAgence(agence);
        String req = "insert into employe values('" + cin + "','" + id + "','" + idAgence + "'," + salaire + ")";
        try {
            st = con.createStatement();
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(Employe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
