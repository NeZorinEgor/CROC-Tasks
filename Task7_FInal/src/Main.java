import Model.Root;
import Model.Sales;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Root root = new Root();

        Document doc;
        try {
            doc =  buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error: " + e);
            return; //На случай ошибки
        }

        //Достаем рутовый элемент
        Node rootNode = doc.getFirstChild();
        System.out.println(rootNode.getNodeName()); //root

        NodeList rootChilds = rootNode.getChildNodes();

        Node salesNode = null;
        for (int i = 0; i < rootChilds.getLength(); i++){
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue; //Пропускаем всякий мусор, по типу #text
            }
            System.out.println(rootChilds.item(i).getNodeName());

            switch (rootChilds.item(i).getNodeName()){
                case "sales":{
                    salesNode = rootChilds.item(i);
                    //System.out.println(salesNode.getTextContent());
                    break;
                }
            }
        }
        if (salesNode == null){ //Можем не продолжать
            return;
        }
        List<Sales> salesList = new ArrayList<>();
        NodeList salesChilds = salesNode.getChildNodes();
        for (int i = 0; i < salesChilds.getLength(); i++) {
            //чистим барахло
            if (salesChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            //чистим барахло
            if (!salesChilds.item(i).getNodeName().equals("sale")){
                continue;
            }

            int saleID = 0;
            int sellerID = 0;
            int productID = 0;
            int quantity = 0;
            String saleDate = "";

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
        root.setSales(salesList);
        System.out.println(root.toString());

        root.getSales().stream().filter((sales -> {
            return sales.getQuantity() == 10;
        })).forEach(sales -> {
            System.out.println(sales.toString());
        });

    }
    public static Document buildDocument() throws Exception{
        File file = new File("src/Data/Input/sales.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return   dbf.newDocumentBuilder().parse(file);
    }
}