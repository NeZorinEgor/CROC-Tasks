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
        System.out.print("""
                ✅️ Задание 1 - Вывести в файл топ 5 товаров с наибольшим количеством продаж;
                ✅️ Задание 2 - Вывести в файл топ 5 дат, в которые было продано наибольшее количество товаров;
                ✅️ Форматы файлов: XML -> JSON;
                Директория результатов👀:
                """);
        //инициализируем сборник нужных элементов
        Root root = new Root();
        //парсим
        parseSales(root);
        parseProducts(root);
        //выводим результат
        writeTopQuantity(root);
        writeTopDate(root);
        System.out.println("Спасибо за все, чему нас учили \uD83D\uDE4F\uD83C\uDFFB\uD83D\uDE4F\uD83C\uDFFB\uD83D\uDE4F\uD83C\uDFFB");
    }
}