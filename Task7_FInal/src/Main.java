import Model.Root;
import Model.Sales;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static writeXml.XmlWriter.writeTopQuantity;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Root root = new Root();
        Document doc;
        try {
            doc =  buildDocument();
        } catch (Exception e) {
            return;
        }

        //Достаем рутовый элемент
        Node rootNode = doc.getFirstChild();

        NodeList rootChilds = rootNode.getChildNodes();

        //Перебераем sales
        Node salesNode = null;
        for (int i = 0; i < rootChilds.getLength(); i++){
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue; //Пропускаем всякий мусор, по типу #text
            }

            switch (rootChilds.item(i).getNodeName()){
                case "sales":{
                    salesNode = rootChilds.item(i);
                    break;
                }
            }
        }
        if (salesNode == null){
            return;
        }
        List<Sales> salesList = new ArrayList<>();
        NodeList salesChilds = salesNode.getChildNodes();
        for (int i = 0; i < salesChilds.getLength(); i++) {
            //убираем мусор
            if (salesChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            //убираем мусор
            if (!salesChilds.item(i).getNodeName().equals("sale")){
                continue;
            }

            //Инициализируем поля для заполнения
            int saleID = 0;
            int sellerID = 0;
            int productID = 0;
            int quantity = 0;
            String saleDate = "";

            //Перебераем последний слой sale
            NodeList saleChilds = salesChilds.item(i).getChildNodes();
            for (int j = 0; j < saleChilds.getLength(); j++){
                if (saleChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (saleChilds.item(j).getNodeName()){
                    case "saleID":{
                        saleID = Integer.valueOf(saleChilds.item(j).getTextContent());
                        break;
                    }
                    case "sellerID":{
                        sellerID = Integer.valueOf(saleChilds.item(j).getTextContent());
                        break;
                    }
                    case "productID":{
                        productID = Integer.valueOf(saleChilds.item(j).getTextContent());
                        break;
                    }
                    case "quantity":{
                        quantity = Integer.valueOf(saleChilds.item(j).getTextContent());
                        break;
                    }
                    case "saleDate":{
                        saleDate = saleChilds.item(j).getTextContent();
                        break;
                    }
                }
            }
            Sales sales = new Sales(saleID, sellerID, productID, quantity, saleDate);
            salesList.add(sales);
        }
        //Добавляем в рут распаршенный лист
        root.setSales(salesList);


//        root.getSales().stream()
//                .sorted(Comparator.comparingInt(Sales::getQuantity)
//                        .reversed()).limit(5)
//                .forEach(sales -> System.out.println(sales.toString()));

        writeTopQuantity(root);

    }
    public static Document buildDocument() throws Exception{
        File file = new File("src/Data/Input/sales.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return   dbf.newDocumentBuilder().parse(file);
    }


}