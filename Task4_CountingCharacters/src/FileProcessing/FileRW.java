package FileProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRW {
    public static void counter() throws FileNotFoundException {
        File inputFile = new File("src/file/input.txt");
        Scanner in = new Scanner(inputFile);
        int characterCount = 0;

        while (in.hasNext()) {
            String line = in.nextLine();
            characterCount += line.length();
        }

        System.out.println("Количество символов в файле: " + characterCount);
        in.close();
    }
}
