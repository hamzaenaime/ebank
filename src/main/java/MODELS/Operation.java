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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nafar
 */
public class Operation {

    protected static Connection conn;

    public static int createOperation(int compte_src, int compte_dst, String motif, float montant) {
        conn = Dao.getConnection();//id_client,
        String req = "insert into operation (id_compte_src,id_compte_dst,description,montant) values (?,?,?,?) returning id_operation";
        try {
            PreparedStatement prep = conn.prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setInt(1, compte_src);//Client.getCin()
            prep.setInt(2, compte_dst);
            prep.setString(3, motif);
            prep.setFloat(4, montant);
            prep.executeUpdate();
            ResultSet rs = prep.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex) {
            System.out.print("error lors de l'insertion dans la table operation_client :" + ex.getMessage());
            return 0;
        }
    }

    public static ResultSet getOperationFromTo(String cin, String d1, String d2) {
        Connection con = Dao.getConnection();
        try {
            Statement st = con.createStatement();
            String req;
            req = "select date_operation::date,description,montant from operation inner join operation_client o on operation.id_operation = o.id_operation "
                    + "where o.id_client='" + cin + "' and date_operation >= TO_DATE('" + d1 + "','YYYY-mm-dd') and date_operation <= TO_DATE('" + d2 + "','YYYY-mm-dd')+interval '24 hours' order by date_operation desc";
            ResultSet rs = st.executeQuery(req);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static ResultSet getAllOperation(String cin) {
        Connection con = Dao.getConnection();
        try {
            Statement st = con.createStatement();
            String req;
            req = "select date_operation::date,description,montant from operation inner join operation_client o on operation.id_operation = o.id_operation where o.id_client='" + cin + "' order by date_operation desc";
            ResultSet rs = st.executeQuery(req);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    /*Ayoub Methodes*/
    private static Connection con;
    private static Statement st;
    private static Dao dao = new Dao();

    //Constructor 
    public Operation() {
        con = dao.getConnection();
    }

    public ResultSet Operation_From_To(String cin, String From, String To) {
        ResultSet res = null;
        try {
            this.st = this.con.createStatement();
            res = st.executeQuery("select OP.id_compte_dst,OP.description,OP.montant,OP.date_operation,P.nom,P.prenom FROM operation AS OP INNER JOIN operation_client AS OPC ON OP.id_operation=OPC.id_operation INNER JOIN personne AS P ON P.cin = OPC.id_client "
                    + "where OPC.id_client='" + cin + "' and OP.date_operation >= TO_DATE('" + From + "','YYYY-mm-dd') and OP.date_operation <= TO_DATE('" + To + "','YYYY-mm-dd') order by OP.date_operation desc");
            System.err.println("testt");
            return res;
        } catch (SQLException ex) {
            System.err.println("testt");
            return null;
        }
    }

    public static double transactionMontant(String mois) {
        con = dao.getConnection();
        String req = "select  sum(o.montant) from operation o where to_char(o.date_operation, 'MM') = '" + mois + "';";
        try {
            st = con.createStatement();
            ResultSet res = st.executeQuery(req);
            if (res.next()) {
                return res.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Personne.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
