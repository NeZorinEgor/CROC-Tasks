package FileProcessing;

import java.io.*;
import java.util.Scanner;

public class FileRW {
    public static void counter() throws IOException {
        File inputFile = new File("src/file/input.txt");
        Scanner in = new Scanner(inputFile);
        int characterCount = 0;
        FileWriter outDir = new FileWriter("src/file/output.txt");
        while (in.hasNext()) {
            String line = in.nextLine();
            characterCount += line.length();
            outDir.write(characterCount);
        }
        System.out.println("Количество символов в файле: " + characterCount);
        in.close();
    }
}
