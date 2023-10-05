import java.util.Scanner;
//Задача - написать детектор палиндрома

public class Main {
    /**
     * isPalindrome проверяет, является ли введенная строка палиндромом.
     * @param userInput - строка для проверки на палиндром.
     * Из строки userInput удаляются пробелы и регистры сводятся к нижниму уровню.
     * @return true, если строка является палиндромом, в противном случае - false.
     * @author Егор Зорин
     */
    public static void main(String[] args){
        //Считываем пользовательский ввод и записываем его в переменную `userInput`.
        Scanner sc = new Scanner(System.in); //Инициализируем сканер
        String userInput = sc.nextLine().toLowerCase().replaceAll("\\s+","");
        // to lower case - символоs к одному регистру
        // replaceAll("\\s+","") - удалениt всех пробелов

        System.out.println(isPalindrome(userInput) ? "YES" : "NO");
        //TODO: Избавиться от тернарного выражения
    }
    private static boolean isPalindrome(String userInput){
        // Обработка оставшихся символов, когда остается либо 1 символ, либо ни одного.
        if (userInput.length() == 1 || userInput.length() == 0){
            return true;
        }
        // Рекурсивная обработка. Если первый и последний сомвол совпадают - отрезаем их и продолжаем.
        if (userInput.charAt(0) == userInput.charAt(userInput.length() - 1)){
            return isPalindrome(userInput.substring(1, userInput.length() - 1));
        }
        return false;
    }

}