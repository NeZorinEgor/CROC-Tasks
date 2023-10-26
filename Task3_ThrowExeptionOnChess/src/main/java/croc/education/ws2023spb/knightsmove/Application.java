package croc.education.ws2023spb.knightsmove;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
public class Application {
    public static void main(String[] args) {
        KnightsMoveChecker checker = KnightsMoveCheckerFactory.get();

        String[] validSequence = {"a1", "b3", "c5", "d7"};
        String[] invalidSequence = {"e6", "e7"};

        try {
            checker.check(validSequence);
            System.out.print("OK");
        } catch (IllegalMoveException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }

        try {
            checker.check(invalidSequence);
            System.out.print("OK");
        } catch (IllegalMoveException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
