package org.neZorinEgor;

import org.neZorinEgor.Model.Product;
import org.neZorinEgor.Model.Root;
import org.neZorinEgor.Model.Sales;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.neZorinEgor.XmlToJsonWriter.XmlToJsonWriter.JsonWriter.writeTopDate;
import static org.neZorinEgor.XmlToJsonWriter.XmlToJsonWriter.JsonWriter.writeTopQuantity;


public class Main {
    public static void main(String[] args) {
        //инициализируем сборник нужных элементов
        Root root = new Root();
        parseSales(root);
        parseProducts(root);

        writeTopQuantity(root);
        writeTopDate(root);
    }

    public static void parseSales(Root root){
        Document doc;
        try {
            doc =  buildDocument(new File("src/main/java/org/neZorinEgor/Data/Input/sales.xml"));
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
            if (rootChilds.item(i).getNodeName().equals("sales")) {
                salesNode = rootChilds.item(i);
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
                        saleID = Integer.parseInt(saleChilds.item(j).getTextContent());
                        break;
                    }
                    case "sellerID":{
                        sellerID = Integer.parseInt(saleChilds.item(j).getTextContent());
                        break;
                    }
                    case "productID":{
                        productID = Integer.parseInt(saleChilds.item(j).getTextContent());
                        break;
                    }
                    case "quantity":{
                        quantity = Integer.parseInt(saleChilds.item(j).getTextContent());
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
    }

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


    //---------------------------------------------------------------------------продукты

    public static Document buildDocument(File file) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            return   dbf.newDocumentBuilder().parse(file);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}