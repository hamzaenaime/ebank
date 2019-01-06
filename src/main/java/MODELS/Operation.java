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

/**
 *
 * @author nafar
 */
public class Operation {
    
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
