/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reports.PDFHeaderFooter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinic
 */
public class PDFHeaderFooter extends PdfPageEventHelper {

    private Font headerFont;
    private Font footerFont;
    private String headerText;

    public PDFHeaderFooter(String headerText) {
        this.headerFont = FontFactory.getFont(FontFactory.COURIER, 20, Font.BOLD);
        this.footerFont = FontFactory.getFont(FontFactory.COURIER, 12, Font.NORMAL);
        this.headerText = headerText;
    }

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        // Header
        float headerX = (document.left() + document.right()) / 2;
        float headerY = document.top() - 10;

        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
                new Phrase(this.headerText, headerFont),
                headerX, headerY, 0);

        // Footer
        float footerX = (document.left() + document.right()) / 2;
        float footerY = document.bottom() - 20;

        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER,
                new Phrase("Página " + writer.getPageNumber(), footerFont),
                footerX, footerY, 0);

    }

}
