package org.neZorinEgor.XmlParser;

import org.neZorinEgor.Model.Root;
import org.neZorinEgor.Model.Sale;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.neZorinEgor.XmlParser.DocumentBuilder.DocumentBuilder.buildDocument;

/**
 * Класс, содержащий метод для пасинга xml файла связанного с продажами
 */
public class SalesParser {
    private static final String SALE_ID = "saleID";
    private static final String SELLER_ID = "sellerID";
    private static final String PRODUCT_ID = "productID";
    private static final String QUANTITY = "quantity";
    private static final String SALE_DATE = "saleDate";

    /**
     * Метод сортирует xml файл с продажами
     *
     * @param root - сборщик элементов моделей продаж и товаров
     */
    public static void parseSales(Root root) {
        Document doc;
        try {
            doc = buildDocument(new File("src/main/java/org/neZorinEgor/Data/Input/sales.xml"));
        } catch (Exception e) {
            return;
        }
        //Достаем рутовый элемент
        Node rootNode = doc.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();

        //Перебераем sales
        Node salesNode = null;
        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue; //Пропускаем всякий мусор, по типу #text
            }
            if (rootChilds.item(i).getNodeName().equals("sales")) {
                salesNode = rootChilds.item(i);
            }
        }
        if (salesNode == null) {
            return;
        }

        List<Sale> salesList = paseList(salesNode);

        //Добавляем в рут распаршенный лист
        root.setSales(salesList);
    }

    private static List<Sale> paseList(Node salesNode) {
        List<Sale> salesList = new ArrayList<>();
        NodeList salesChilds = salesNode.getChildNodes();
        for (int i = 0; i < salesChilds.getLength(); i++) {
            //убираем мусор
            if (salesChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            //убираем мусор
            if (!salesChilds.item(i).getNodeName().equals("sale")) {
                continue;
            }
            //Перебераем последний слой sale
            NodeList saleChilds = salesChilds.item(i).getChildNodes();

            Sale sales = parseElement(salesChilds.item(i));
            salesList.add(sales);
        }
        return salesList;
    }

    private static Sale parseElement(Node elementNode){
        //Инициализируем поля для заполнения
        int saleID = 0;
        int sellerID = 0;
        int productID = 0;
        int quantity = 0;
        String saleDate = "";
        NodeList elementChilds = elementNode.getChildNodes();

        for (int j = 0; j < elementChilds.getLength(); j++) {
            if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            switch (elementChilds.item(j).getNodeName()) {
                case SALE_ID: {
                    saleID = Integer.parseInt(elementChilds.item(j).getTextContent());
                    break;
                }
                case SELLER_ID: {
                    sellerID = Integer.parseInt(elementChilds.item(j).getTextContent());
                    break;
                }
                case PRODUCT_ID: {
                    productID = Integer.parseInt(elementChilds.item(j).getTextContent());
                    break;
                }
                case QUANTITY: {
                    quantity = Integer.parseInt(elementChilds.item(j).getTextContent());
                    break;
                }
                case SALE_DATE: {
                    saleDate = elementChilds.item(j).getTextContent();
                    break;
                }
            }
        }
        Sale sales = new Sale(saleID, sellerID, productID, quantity, saleDate);
        return sales;
    }
}
