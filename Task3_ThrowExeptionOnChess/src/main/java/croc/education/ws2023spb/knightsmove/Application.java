package croc.education.ws2023spb.knightsmove;

/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
/**
 * Приложение, проверяющее возможность прохождения последовательности клеток на шахматной доске ходом коня.
 */
public class Application {
    public static void main(String[] args) {

        String[] sequence = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            sequence[i] = args[i];
        }

        KnightsMoveChecker checker = KnightsMoveCheckerFactory.get();

        try {
            checker.check(sequence);
            System.out.print("OK");
        } catch (IllegalMoveException | IllegalArgumentException | StringIndexOutOfBoundsException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

}
