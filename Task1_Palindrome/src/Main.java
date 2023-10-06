import java.util.Scanner;
/**
 * Программа для определения, является ли введенная строка палиндромом.
 * @author: Егор Зорин
 */
public class Main {
    /**
     * Инициализируем сканер, записываем в userInput
     * Из строки userInput удаляем пробелы и регистры сводим к нижниму уровню ->
     * передаем в isPalindrome
     */
    public static void main(String[] args){
        //Считываем пользовательский ввод и записываем его в переменную `userInput`.
        Scanner sc = new Scanner(System.in);
        System.out.print("Ввод данных: ");
        String userInput = sc.nextLine().toLowerCase().replaceAll("\\s+","");
        // toLowerCase - символоs к одному регистру
        // replaceAll("\\s+","") - удалениt всех пробелов

        System.out.println(isPalindrome(userInput));
    }
    /**
     * isPalindrome проверяет, является ли введенная строка палиндромом.
     * @param userInput - строка для проверки на палиндром.
     * @return true, если строка является палиндромом, в противном случае - false.
     */
    private static boolean isPalindrome(String userInput){
        // Обработка оставшихся символов, когда остается либо 1 символ, либо ни одного.
        if (userInput.length() == 1 || userInput.isEmpty()){
            return true;
        }
        // Рекурсивная обработка. Если первый и последний сомвол совпадают - отрезаем их и продолжаем.
        if (userInput.charAt(0) == userInput.charAt(userInput.length() - 1)){
            return isPalindrome(userInput.substring(1, userInput.length() - 1));
        }
        return false;
    }
}