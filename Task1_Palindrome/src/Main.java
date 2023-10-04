import java.util.Scanner;
//Палиндром — число, буквосочетание, слово или текст, одинаково читающееся в обоих направлениях.

public class Main {
    public static void main(String[] args){
        //Считываем пользовательский ввод и записываем его в переменную `userInput`.
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        System.out.println(isPalindrome(userInput) ? "YES" : "NO");
    }
    private static boolean isPalindrome(String userInput){
        //
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