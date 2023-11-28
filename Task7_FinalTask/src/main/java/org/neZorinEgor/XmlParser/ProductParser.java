package org.neZorinEgor.XmlParser;

import org.neZorinEgor.Model.Product;
import org.neZorinEgor.Model.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.neZorinEgor.XmlParser.DocumentBuilder.DocumentBuilder.buildDocument;

/**
 * Класс, содержащий метод для пасинга xml файла связанного с продуктами
 */
public class ProductParser {
    /**
     * Метод сортирует xml файл с продуктами
     * @param root - сборщик элементов моделей продаж и товаров
     */
    public static void parseProducts(Root root){
        Document doc;
        try {
            doc =  buildDocument(new File("src/main/java/org/neZorinEgor/Data/Input/products.xml"));
        } catch (Exception e) {
            return;
        }
        //Достаем рутовый элемент
        Node rootNode = doc.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();

        //Перебераем product
        Node productNode = null;
        for (int i = 0; i < rootChilds.getLength(); i++){
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE){
                continue; //Пропускаем всякий мусор, по типу #text
            }
            if (rootChilds.item(i).getNodeName().equals("products")) {
                productNode = rootChilds.item(i);
                productNode = rootChilds.item(i);
            }
        }
        if (productNode == null){
            return;
        }
        List<Product> productList = new ArrayList<>();
        NodeList productsChilds = productNode.getChildNodes();
        for (int i = 0; i < productsChilds.getLength(); i++) {
            //убираем мусор
            if (productsChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            //убираем мусор
            if (!productsChilds.item(i).getNodeName().equals("product")){
                continue;
            }

            //Инициализируем поля для заполнения
            int productID = 0;
            String productName = "";

            //Перебераем последний слой product
            NodeList productChilds = productsChilds.item(i).getChildNodes();
            for (int j = 0; j < productChilds.getLength(); j++){
                if (productChilds.item(j).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }
                switch (productChilds.item(j).getNodeName()){
                    case "productID":{
                        productID = Integer.parseInt(productChilds.item(j).getTextContent());
                        break;
                    }
                    case "productName":{
                        productName = productChilds.item(j).getTextContent();
                        break;
                    }
                }
            }
            Product product = new Product(productID, productName);
            productList.add(product);
        }
        //Добавляем в рут распаршенный лист
        root.setProducts(productList);

    }
}
