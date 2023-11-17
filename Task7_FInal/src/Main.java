import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        //Открываем файл для парсинга
        File inputData = new File("src/Data/Input/sellers.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            Document doc = dbf.newDocumentBuilder().parse(inputData);
            Node root = doc.getFirstChild();
            System.out.println(root);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Error message: " + e);
        }



    }
}