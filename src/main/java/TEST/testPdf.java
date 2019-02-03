/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;


import MODELS.Operation;
import MODELS.Table.OperationTable;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class testPdf {
    
       public static void main(String[] args){
           try {                        
               Operation.getAllOperation("id84901");
           } catch (SQLException ex) {
               Logger.getLogger(testPdf.class.getName()).log(Level.SEVERE, null, ex);
           }
      }
} 