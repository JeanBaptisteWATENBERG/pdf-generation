package com.jb.pdf;

import com.itextpdf.text.DocumentException;
import org.apache.commons.io.IOUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException {
        InputStream resourceAsStream = Main.class.getResourceAsStream("/test.html");
        String html = IOUtils.toString(resourceAsStream, StandardCharsets.UTF_8);
        File tempFile = File.createTempFile("hello", ".pdf");
        OutputStream outputStream = new FileOutputStream(tempFile);

        ITextRenderer renderer = new ITextRenderer();
        renderer.getFontResolver().addFont(Main.class.getResource("/Roboto-Regular.ttf").toExternalForm(), true);

        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        System.out.println(tempFile.getAbsolutePath());
    }
}
