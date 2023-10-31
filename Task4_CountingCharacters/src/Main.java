import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Это класс Main, который анализирует символы во входном файле и создает карту частоты символов,
 * а затем записывает результат в выходной файл.
 */
public class Main {
    /**
     * Этот метод является точкой входа в приложение.
     *
     * @param args Аргументы командной строки (не используются в этом приложении).
     */
    public static void main(String[] args) {
        String inputFile = "src//file//input.txt";  // Путь к входному файлу.
        String outputFile = "src//file//output.txt";  // Путь к выходному файлу.
        Map<Character, Integer> frequencyMap = new HashMap<>();  // Карта частоты символов.

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char character = (char) currentChar;
                if (character != ' ' && character != '\n') {
                    frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        Map<Character, Integer> sortedFrequencyMap = new TreeMap<>(frequencyMap);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (Map.Entry<Character, Integer> entry : sortedFrequencyMap.entrySet()) {
                writer.write("\"" + entry.getKey() + "\"=" + entry.getValue() + ", ");
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи файла: " + e.getMessage());
        }
    }
}
