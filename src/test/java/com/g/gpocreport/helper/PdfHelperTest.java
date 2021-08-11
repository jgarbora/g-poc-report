package com.g.gpocreport.helper;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class PdfHelperTest {

    @Test
    public void test () throws FileNotFoundException {

        String html = "<h1>Hello</h1>"
                + "<p>This was created using iText</p>"
                + "<a href='hmkcode.com'>hmkcode.com</a>";

        PdfHelper.convertToPdf(html, "test2.pdf");
    }

}