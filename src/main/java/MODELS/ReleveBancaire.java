/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODELS;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author dell
 */
public class ReleveBancaire {

    private ResultSet Res;

    public void GeneratePDF(String path, String NomPrenom, String cin, Operation operations, int periode, String from, String to) throws FileNotFoundException, DocumentException, BadElementException, IOException, SQLException, ParseException {

        this.Res = operations.Operation_From_To(cin, from, to);

        String Cl = " Jours";
        if (periode > 30) {
            periode = (int) (periode / 30);
            Cl = " Mois";
        }

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();
        Image image2 = Image.getInstance("./img/header.png");
        image2.scaleAbsolute(520f, 90f);
        document.add(image2);

        Paragraph title = new Paragraph("Historique des opérations", FontFactory.getFont(FontFactory.COURIER, 30, Font.BOLD, new CMYKColor(200, 200, 0, 90)));
        title.setAlignment(1);
        document.add(title);

        // add a blank lines
        document.add(Chunk.NEWLINE);

        Paragraph NomP = new Paragraph("Nom et Prenom:\t" + NomPrenom, FontFactory.getFont(FontFactory.COURIER, 15));
        Paragraph NumC = new Paragraph("Numéro de client:\t" + cin, FontFactory.getFont(FontFactory.COURIER, 15));
        Paragraph Periode = new Paragraph("Période:\t" + periode + Cl.toString(), FontFactory.getFont(FontFactory.COURIER, 15));

        document.add(NomP);
        document.add(NumC);
        document.add(Periode);

        // add a blank lines
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        /* Create table of operation
            *
         */
        PdfPTable table = new PdfPTable(5);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell("Nom Prénom");
        table.addCell("Compte Destination");
        table.addCell("Libellé opeartion");
        table.addCell("Montant");
        table.addCell("Date Operation");

        table.setHeaderRows(1);
        PdfPCell[] cells = table.getRow(0).getCells();
        for (int j = 0; j < cells.length; j++) {
            cells[j].setBackgroundColor(BaseColor.GRAY);
        }

        while (Res.next()) {
            String np = Res.getString(5).toUpperCase() + " " + Res.getString(6).toUpperCase();
            table.addCell(np);
            table.addCell(Res.getString(1));
            table.addCell(Res.getString(2));
            table.addCell(Res.getString(3));
            table.addCell(Res.getString(4));

        }

        document.add(table);

        document.close();
        System.out.println("Done");
    }

    public void GenerateExcel(String path, String NomPrenom, String cin, Operation operations, int periode, String from, String to) throws FileNotFoundException, DocumentException, BadElementException, IOException, SQLException, ParseException {

        this.Res = operations.Operation_From_To(cin, from, to);

        String Cl = " Jours";
        if (periode > 30) {
            periode = (int) (periode / 30);
            Cl = " Mois";
        }
        //Fill Excel :
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
        CellStyle Titlestyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font font = workbook.createFont();
        font.setFontHeight((short) (550));
        Titlestyle.setFont(font);
        Titlestyle.setAlignment((short) 3);

        Row row = sheet.createRow(7);
        sheet.addMergedRegion(new CellRangeAddress(7, 9, 4, 6));
        Cell Title = row.createCell(4);
        Title.setCellValue("Historique Des Operations ");
        Title.setCellStyle(Titlestyle);

        //soub Title viwing the persiode
        CellStyle subTitlestyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font subfont = workbook.createFont();
//    subfont.setFontHeight((short)(300));
        subTitlestyle.setAlignment((short) 2);
        subTitlestyle.setFont(subfont);

        row = sheet.createRow(10);
        sheet.addMergedRegion(new CellRangeAddress(10, 10, 4, 6));
        Cell subTitle = row.createCell(4);
        subTitle.setCellValue("Période : de " + from + " à " + to + "   (" + (periode + Cl.toString()) + " )");
        subTitle.setCellStyle(subTitlestyle);

//   Coordonnes :
        //Style des Coordonnes :
        CellStyle CoordStyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font Coordfont = workbook.createFont();
//    Coordfont.setFontHeight((short)(500));
        Coordfont.setColor(IndexedColors.BLACK.getIndex());
        CoordStyle.setFont(Coordfont);

        CoordStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        CoordStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        row = sheet.createRow(11);
        sheet.addMergedRegion(new CellRangeAddress(11, 11, 1, 3));
        Cell numCompte = row.createCell(1);
        numCompte.setCellValue("CIN                   :   " + cin);
        numCompte.setCellStyle(CoordStyle);

        row = sheet.createRow(12);
        sheet.addMergedRegion(new CellRangeAddress(12, 12, 1, 3));
        Cell nom = row.createCell(1);
        nom.setCellValue("Nom Complet    :  " + NomPrenom);
        nom.setCellStyle(CoordStyle);

//   Operations Table : 
//HEader table Style :
        CellStyle htableStyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font htablefont = workbook.createFont();
        htablefont.setColor(IndexedColors.WHITE.getIndex());
        htableStyle.setFont(htablefont);
        htableStyle.setFillForegroundColor(IndexedColors.GREY_80_PERCENT.getIndex());
        htableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        htableStyle.setBorderBottom((short) 6);
        htableStyle.setAlignment((short) 2);

        String[] tableHeaders = {"date", "Nom Complet", "Type D'operation", "à", "montant"};
        row = sheet.createRow(14);
        int i = 3;
        for (String header : tableHeaders) {
            Cell headerCell = row.createCell(i);
            headerCell.setCellValue(header);
            headerCell.setCellStyle(htableStyle);
            sheet.setColumnWidth(i, 1000 * 5);
            i++;

        }

//   table style paire :
        CellStyle ptableStyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font ptablefont = workbook.createFont();
        ptablefont.setColor(IndexedColors.BLACK.getIndex());
        ptableStyle.setFont(ptablefont);
        ptableStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        ptableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        ptableStyle.setBorderBottom((short) 3);
        ptableStyle.setAlignment((short) 2);

//   table style imppaire :
        CellStyle imtableStyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font imtablefont = workbook.createFont();
        imtablefont.setColor(IndexedColors.BLACK.getIndex());
        imtableStyle.setFont(imtablefont);
        imtableStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        imtableStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        imtableStyle.setBorderBottom((short) 3);
        imtableStyle.setAlignment((short) 2);

        int j = 15;
        while (Res.next()) {

            row = sheet.createRow(j);

            Cell date = row.createCell(3);
            Cell nomComplet = row.createCell(4);
            Cell TypOp = row.createCell(5);
            Cell dis = row.createCell(6);
            Cell montant = row.createCell(7);
            String np = Res.getString(5).toUpperCase() + " " + Res.getString(6).toUpperCase();

            //set values :
            date.setCellValue(Res.getString(4));
            nomComplet.setCellValue(np);
            TypOp.setCellValue(Res.getString(2));
            dis.setCellValue(Res.getString(1));
            montant.setCellValue(Res.getDouble(3));

            if (j % 2 == 0) {
                date.setCellStyle(ptableStyle);
                nomComplet.setCellStyle(ptableStyle);
                TypOp.setCellStyle(ptableStyle);
                dis.setCellStyle(ptableStyle);
                montant.setCellStyle(ptableStyle);
            } else {
                date.setCellStyle(imtableStyle);
                nomComplet.setCellStyle(imtableStyle);
                TypOp.setCellStyle(imtableStyle);
                dis.setCellStyle(imtableStyle);
                montant.setCellStyle(imtableStyle);
            }

            j++;

        }
        FileOutputStream fos = new FileOutputStream(new File(path + "cp.xlsx"));
        workbook.write(fos);
        fos.close();
        System.out.println("Done");

    }

}
