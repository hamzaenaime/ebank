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
}
