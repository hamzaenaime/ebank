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
   protected static Connection conn;
    
    public static int createOperation(int compte_src,int compte_dst, String motif, float montant){
        conn = Dao.getConnection();//id_client,
        String req = "insert into operation (id_compte_src,id_compte_dst,description,montant) values (?,?,?,?) returning id_operation";
        try {
            PreparedStatement prep = conn.prepareStatement(req,PreparedStatement.RETURN_GENERATED_KEYS);
            prep.setInt(1, compte_src);//Client.getCin()
            prep.setInt(2, compte_dst);
            prep.setString(3, motif);
            prep.setFloat(4, montant);
            prep.executeUpdate();
            ResultSet rs=prep.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException ex) {
            System.out.print("error lors de l'insertion dans la table operation_client :"+ex.getMessage());
            return 0;
        }
    }

    public static ResultSet getOperationFromTo(String cin, String d1, String d2) {
    Connection con = Dao.getConnection();
        try 
        {
            Statement st = con.createStatement();
            String req ;
            req="select date_operation::date,description,montant from operation inner join operation_client o on operation.id_operation = o.id_operation "
                    + "where o.id_client='"+cin+"' and date_operation >= TO_DATE('"+d1+"','YYYY-mm-dd') and date_operation <= TO_DATE('"+d2+"','YYYY-mm-dd') order by date_operation desc";
            ResultSet rs=st.executeQuery(req);
            return rs ;
        }
        catch( SQLException ex)
        {
            return null ;
        }
    }
    
    private Connection Con;
    private Statement St;
    private Dao dao;
    
     public Operation(){
        Con =   dao.getConnection();
    }
    
    public static ResultSet getAllOperation(String cin){
        Connection con = Dao.getConnection();
        try 
        {
            Statement st = con.createStatement();
            String req ;
            req="select date_operation::date,description,montant from operation inner join operation_client o on operation.id_operation = o.id_operation where o.id_client='"+cin+"' order by date_operation desc";
            ResultSet rs=st.executeQuery(req);
            return rs ;
        }
        catch( SQLException ex)
        {
            return null ;
        }
    }
}
