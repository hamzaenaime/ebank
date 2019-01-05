/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import static com.itextpdf.text.FontFactory.HELVETICA;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class testPdf {
    
       public static void main(String[] args) throws FileNotFoundException, DocumentException, BadElementException, IOException{
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("testPDF.pdf"));
            document.open();
            Image image2 = Image.getInstance("./img/header.png");
            image2.scaleAbsolute(520f, 90f);
            document.add(image2);
            
            
            Paragraph title = new Paragraph("Histoire des opérations", FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(200, 200, 0, 90)));
            title.setAlignment(1);
            document.add(title);
            
             // add a blank lines
            document.add( Chunk.NEWLINE );
            
            Paragraph NomP = new Paragraph("Nom et Prenom:\t"+"Hamaoui Ayoub", FontFactory.getFont(FontFactory.COURIER, 15));
            Paragraph NumC = new Paragraph("Numéro de compte:\t"+"CB25896", FontFactory.getFont(FontFactory.COURIER, 15));
            Paragraph Periode = new Paragraph("Période"+"3 derniers mois", FontFactory.getFont(FontFactory.COURIER, 15));
            
            document.add(NomP);
            document.add(NumC);
            document.add(Periode);
            
            // add a blank lines
            document.add( Chunk.NEWLINE );
            document.add( Chunk.NEWLINE );
            /* Create table of operation
            *
            */            
            PdfPTable table = new PdfPTable(4);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell("Date Operation");
            table.addCell("Libellé opeartion");
            table.addCell("Débit");
            table.addCell("Crédit");
            table.setHeaderRows(1);
            PdfPCell[] cells = table.getRow(0).getCells(); 
            for (int j=0;j<cells.length;j++){
                cells[j].setBackgroundColor(BaseColor.GRAY);
            }
            Date date = new Date();
            for (int i=1;i<20;i++){
                table.addCell(date.toString());
                table.addCell("Virement"+i);
                table.addCell("0");
                table.addCell(Float.toString((float) (100.5+i*4)));
            }
            
            document.add(table);
           
            document.close();
            System.out.println("Done");
            
            
      }
} 