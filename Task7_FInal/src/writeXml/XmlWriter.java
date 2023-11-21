package writeXml;

import Model.Root;
import Model.Sales;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Comparator;


public class XmlWriter {
    /**Метод сортирует по стирму лист, открывает запись в
     *                               xml по сортировке и закрывает, как нашла 5 наибольших элеметнов
     * @param root - экземляр класса, распаршенный sale
     */
    public static void writeTopQuantity(Root root) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/Data/Output/Task1/quantityTask.xml");
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(fileOutputStream);

            // Начало записи XML
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("root");
            xmlStreamWriter.writeStartElement("sales");

            // Поток данных и сортировка по колличеству продаж
            root.getSales().stream()
                    .sorted(Comparator.comparingInt(Sales::getQuantity)
                            .reversed()).limit(5)
                    .forEach(sales -> {
                        try {

                            // Запись данных в XML
                            xmlStreamWriter.writeStartElement("sale");
                            xmlStreamWriter.writeAttribute("quantity", String.valueOf(sales.getQuantity()));
                            xmlStreamWriter.writeEndElement();
                        } catch (XMLStreamException e) {
                            System.out.println();;
                        }
                    });
            // Завершение записи XML
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

            System.out.println("топ 5 товаров с наибольшим количеством продаж cохранены -> src/Data/Output/quantityTask.xml");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
