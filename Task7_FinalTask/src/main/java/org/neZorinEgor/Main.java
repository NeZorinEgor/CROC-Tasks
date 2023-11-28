package org.neZorinEgor;

import org.neZorinEgor.Model.Root;

import static org.neZorinEgor.XmlParser.ProductParser.parseProducts;
import static org.neZorinEgor.XmlParser.SalesParser.parseSales;
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






}