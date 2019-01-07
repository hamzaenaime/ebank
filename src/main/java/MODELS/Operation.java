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
            return 0;
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
