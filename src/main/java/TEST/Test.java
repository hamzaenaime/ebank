/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import DAO.Dao;
import MODELS.Operation;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


public class Test extends JPanel
{
   
  public static void main(String s[]) throws SQLException {
      DateFormat oDateFormat = new SimpleDateFormat("yyyy-MM-dd");
      Date date = new Date();
      String D= oDateFormat.format(date);
      System.out.println(D);
      
      Connection Con;
      Dao dao = new Dao();
      Con =   dao.getConnection();
      Statement St = Con.createStatement();
      ResultSet Res;
           Operation operations = new Operation();
           Res = operations.Operation_From_To("id84901", oDateFormat.format(D), oDateFormat.format(D));
           while(Res.next()){
               System.out.println(Res.getString(1));
           }

    }
}