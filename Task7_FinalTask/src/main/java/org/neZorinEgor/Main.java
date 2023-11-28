package org.neZorinEgor;

import org.neZorinEgor.Model.Root;

import static org.neZorinEgor.XmlParser.ProductParser.parseProducts;
import static org.neZorinEgor.XmlParser.SalesParser.parseSales;
import static org.neZorinEgor.XmlToJsonWriter.XmlToJsonWriter.writeTopDate;
import static org.neZorinEgor.XmlToJsonWriter.XmlToJsonWriter.writeTopQuantity;


public class Main {
    /**
     * Стартовый класс.
     *                  @param args - точка входа
     */
    public static void main(String[] args) {
        //инициализируем сборник нужных элементов
        Root root = new Root();
        //парсим
        parseSales(root);
        parseProducts(root);
        //выводим результат
        writeTopQuantity(root);
        writeTopDate(root);
    }
}