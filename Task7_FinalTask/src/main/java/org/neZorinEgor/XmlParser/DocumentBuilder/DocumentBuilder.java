package org.neZorinEgor.XmlParser.DocumentBuilder;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DocumentBuilder {
    public static Document buildDocument(File file) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            return   dbf.newDocumentBuilder().parse(file);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
