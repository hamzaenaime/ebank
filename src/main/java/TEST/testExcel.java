/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class testExcel {
	public static void main(String[] args) throws IOException {
	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Operations");
	    
            
//HEADER :
   InputStream inputStream = new FileInputStream("img/header.png");
   //Get the contents of an InputStream as a byte[].
   byte[] bytes = IOUtils.toByteArray(inputStream);
   //Adds a picture to the workbook
   int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
   //close the input stream
   inputStream.close();
   //Returns an object that handles instantiating concrete classes
   CreationHelper helper = workbook.getCreationHelper();
   //Creates the top-level drawing patriarch.
   Drawing drawing = sheet.createDrawingPatriarch();

   //Create an anchor that is attached to the worksheet
   ClientAnchor anchor = helper.createClientAnchor();
   sheet.addMergedRegion(new CellRangeAddress(1, 6, 0, 9));
   
   

   //create an anchor with upper left cell _and_ bottom right cell
   anchor.setCol1(0); //Column B
   anchor.setRow1(1); //Row 3
   anchor.setCol2(9); //Column C
   anchor.setRow2(6); //Row 4
//
// 

      drawing.createPicture(anchor, pictureIdx);
   //pict.resize(); //don't do that. Let the anchor resize the image!

   //Create the Cell B3
//   Cell cell = sheet.createRow(2).createCell(1);
	    

    CellStyle style = workbook.createCellStyle();
    Font font = workbook.createFont();
    font.setFontName("Roboto");
    font.setFontHeight((short)(550));
    style.setFont(font);
    style.setAlignment((short)3);
            
            
    
   Row row = sheet.createRow(7);
   sheet.addMergedRegion(new CellRangeAddress(7, 9, 4, 6));
   Cell cell2 = row.createCell(4);
   cell2.setCellValue("Historique Des Operations ");
   cell2.setCellStyle(style);
   
   
//   Coordonnes :
     //Style des Coordonnes :
    CellStyle CoordStyle = workbook.createCellStyle();
    Font Coordfont = workbook.createFont();
//    Coordfont.setFontHeight((short)(500));
    Coordfont.setColor(IndexedColors.BLACK.getIndex());
    CoordStyle.setFont(Coordfont);
    
    CoordStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    CoordStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    

   row = sheet.createRow(11);
   sheet.addMergedRegion(new CellRangeAddress(11, 11, 1,4));
   Cell numCompte = row.createCell(1);
   numCompte.setCellValue("Numero de Compte :   232112133443  ");
   numCompte.setCellStyle(CoordStyle);
   
   
   row = sheet.createRow(12);
   sheet.addMergedRegion(new CellRangeAddress(12, 12, 1,4));
   Cell nom = row.createCell(1);
   nom.setCellValue("Nom Complet :   XXXXXXXX YYYYYYYYY");
   nom.setCellStyle(CoordStyle);
   
//   Operations Table : 


//HEader table Style :
    CellStyle htableStyle = workbook.createCellStyle();
    Font htablefont = workbook.createFont();
    htablefont.setColor(IndexedColors.WHITE.getIndex());
    htableStyle.setFont(htablefont);
    htableStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
    htableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    htableStyle.setBorderBottom((short)6);
    htableStyle.setAlignment((short)2);


   String[] tableHeaders = {"date","Nom Complet","Type D'operation","à" , "montant"} ;
   row = sheet.createRow(15);
   int i = 3 ;
   for (String header : tableHeaders){
        Cell headerCell = row.createCell(i);
        headerCell.setCellValue(header);
        headerCell.setCellStyle(htableStyle);
        sheet.setColumnWidth(i, 1000*5);
        i++ ;
        
   }
   
//   table style paire :
    CellStyle ptableStyle = workbook.createCellStyle();
    Font ptablefont = workbook.createFont();
    ptablefont.setColor(IndexedColors.BLACK.getIndex());
    ptableStyle.setFont(ptablefont);
    ptableStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
    ptableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    ptableStyle.setBorderBottom((short)6);
    ptableStyle.setAlignment((short)2);
    
    
    
//   table style imppaire :
    CellStyle imtableStyle = workbook.createCellStyle();
    Font imtablefont = workbook.createFont();
    imtablefont.setColor(IndexedColors.BLACK.getIndex());
    imtableStyle.setFont(imtablefont);
    imtableStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
    imtableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
    imtableStyle.setBorderBottom((short)6);
    imtableStyle.setAlignment((short)2);


        for (int j = 16; j < 20; j++) {
                row = sheet.createRow(j);
                
                for (int k = 3; k < 8; k++) {
                    Cell oper = row.createCell(k);
                    oper.setCellValue("test");
                    if (j%2 == 0)
                        oper.setCellStyle(ptableStyle);
                    else 
                        oper.setCellStyle(imtableStyle);
                    
                    System.out.println(k%2);
                    
                    
                }
                
            }
   
   
   
   
   
   
   
            

//            
//            
//	    Font font = workbook.createFont();
//            font.setColor(IndexedColors.WHITE.getIndex());
//            style.setFont(font);
//            
//        
//	    Cell cell1 = row.createCell(0);
//	    cell1.setCellValue("ID");
//	    cell1.setCellStyle(style);
//	    
//	    Cell cell2 = row.createCell(2);
////	    cell2.setCellValue("NAME");
//	    cell2.setCellStyle(style);
            
       
  

	    FileOutputStream fos =new FileOutputStream(new File("cp.xlsx"));
	    workbook.write(fos);
	    fos.close();
	    System.out.println("Done");
	}
}  