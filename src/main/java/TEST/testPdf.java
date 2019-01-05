/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TEST;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class testPdf {
       public static void main(String[] args) throws FileNotFoundException, DocumentException, BadElementException, IOException{
           
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("testPDF.pdf"));
            document.open();
            Image image2 = Image.getInstance("../ebank image/header.png");
            image2.scaleAbsolute(520f, 90f);
            document.add(image2);
            
           
            Paragraph paragraph1 = new Paragraph();
            //paragraph1.setSpacingBefore(50);
            document.add(paragraph1);
            
            Paragraph title = new Paragraph("Histoire des opérations", FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(200, 200, 0, 90)));
            title.setAlignment(1);
            document.add(title);
            
           
            document.close();
            System.out.println("Done");
            
            
      }
} 