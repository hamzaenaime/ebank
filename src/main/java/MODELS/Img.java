package MODELS;

import DAO.Dao;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Img{
    private static Connection con;
    
    public static void store(String path, String cin) throws FileNotFoundException, SQLException, IOException{
        con = Dao.getConnection();
            try{
                PreparedStatement pstmt=con.prepareStatement("insert into cin values(?,?)");
                FileInputStream fis=new FileInputStream(path);
                pstmt.setString(1,cin);
                pstmt.setBinaryStream(2,fis,fis.available());
                pstmt.executeUpdate();
            }catch(IOException | SQLException e){
                System.out.println("exception"+e.getMessage());
            }
    }
    
    public static ResultSet get(String cin) throws IOException{
        con = Dao.getConnection();
        String req = "select image from cin where cin='"+cin+"' limit 2";
        try{
            Statement st = con.createStatement();
            return st.executeQuery(req);
        } catch (SQLException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}