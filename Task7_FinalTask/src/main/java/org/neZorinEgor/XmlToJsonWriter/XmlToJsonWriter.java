package org.neZorinEgor.XmlToJsonWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.neZorinEgor.Model.Product;
import org.neZorinEgor.Model.Root;
import org.neZorinEgor.Model.Sales;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class XmlToJsonWriter {
    /**
     * Метод сортирует по стирму лист, открывает запись в
     * xml по сортировке и закрывает, как нашла 5 наибольших элеметнов
     */

    public class JsonWriter {
        private static void writeTopElements(Root root, String outputFilePath, String attributeName) {
            try {
                List<Map<String, Object>> topSales = root.getSales().stream()
                        .sorted(Comparator.comparingInt(Sales::getQuantity).reversed())
                        .limit(5)
                        .map(sales -> {
                            String productName = getProductNameById(root, sales.getProductID());
                            Map<String, Object> map = new HashMap<>();
                            map.put("productName", productName);
                            map.put(attributeName, attributeName.equals("quantity") ? sales.getQuantity() : sales.getSaleDate());
                            return map;
                        })
                        .collect(Collectors.toList());

                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(new File(outputFilePath), topSales);

                System.out.println("Output file: " + outputFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String getProductNameById(Root root, int productID) {
            Optional<Product> productOptional = root.getProducts().stream()
                    .filter(product -> product.getProductID() == productID)
                    .findFirst();

            return productOptional.map(Product::getProductName).orElse("");
        }


        public static void writeTopQuantity(Root root) {
            writeTopElements(root, "src/main/java/org/neZorinEgor/Data/Output/Task1/quantityTask.json", "quantity");
        }
        public static void writeTopDate(Root root) {
            writeTopElements(root, "src/main/java/org/neZorinEgor/Data/Output/Task2/dateTask.json", "date");
        }
    }
}


