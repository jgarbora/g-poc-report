package com.g.gpocreport.helper;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PdfHelper {

    // saving to a file
    public static void convertToPdf(String html, String fileAbsolutePath) throws FileNotFoundException {
        convertToPdf(new FileOutputStream(fileAbsolutePath), html);
    }

    // generating in mem to OutputStream
    public static ByteArrayOutputStream convertToPdfInByteArrayOutputStream(String html) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        convertToPdf(outputStream,html);
        return outputStream;
    }

    // generating in mem to InputStream
    public static ByteArrayInputStream convertToPdfInByteArrayInputStream(String html) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        convertToPdf(outputStream,html);

        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    private static void convertToPdf(OutputStream outputStream, String html) {
        PdfDocument pdfDocument = new PdfDocument(new PdfWriter(outputStream));
        pdfDocument.setDefaultPageSize(PageSize.A4);

        ConverterProperties converterProperties = new ConverterProperties();
        FontProvider fontProvider = new DefaultFontProvider(true,false,false);
        converterProperties.setFontProvider(fontProvider);

        HtmlConverter.convertToPdf(html, pdfDocument, converterProperties);
    }

}
