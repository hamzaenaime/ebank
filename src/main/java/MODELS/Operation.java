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

/**
 *
 * @author nafar
 */
public class Operation {
   private static Connection conn;
    
    public static boolean createOperation(int compte, String motif, float montant){
        conn = Dao.getConnection();
<<<<<<< HEAD
        String req = "insert into operation (id_client,id_compte_src,id_compte_destination,description,montant) values (?,?,?,?)";
=======
        String req = "insert into operation (id_client,id_compte,description,montant) values (?,?,?,?)";
>>>>>>> 1d248ccf8cec442e56a490bd85df0f76a7712025
        try {
            PreparedStatement prep = conn.prepareStatement(req);
            prep.setString(1, Client.getCin());
            prep.setInt(2, compte);
            prep.setString(3, motif);
            prep.setFloat(4, montant);

            int action=prep.executeUpdate();
            return action > 0;           
        } catch (SQLException ex) {
            return false;
        }
    }
    
    private Connection Con;
    private Statement St;
    private Dao dao;
    
     public Operation(){
        dao =   new Dao();
        Con =   dao.getConnection();
    }
    
    public static ResultSet getAllOperation(){
        Connection con = Dao.getConnection();
        try 
        {
            Statement st = con.createStatement();
            String req ;
            req="select description,date_operation::date,montant from operation";
            ResultSet rs=st.executeQuery(req);
            return rs ;
        }
        catch( SQLException ex)
        {
            return null ;
        }
    }
    
    public ResultSet All_Operations(String id){
        ResultSet Res;
        Connection con = Dao.getConnection();
        try{
            St = Con.createStatement();
            St=con.createStatement();
            Res=St.executeQuery("Select * from operation where id_client ="+"'"+id+"'");
            return Res;
        }catch(SQLException ex){
            System.err.println("Erreur de la req select ou st "+ex.getMessage());
            return null;
        }
        
    }
}
