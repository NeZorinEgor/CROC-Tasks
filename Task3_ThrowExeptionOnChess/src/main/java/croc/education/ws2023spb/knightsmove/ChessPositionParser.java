package croc.education.ws2023spb.knightsmove;

/**
 * Класс, содержащий методы преобразования в объект расположения фигуры на шахматной доске из различных форматов.
 *
 * @author Dmitry Malenok
 * @see ChessPosition
 */
public final class ChessPositionParser implements ChessPosition{
    private int xCoord;
    private int yCoord;


    /**
     * Конструктор.
     */
    private ChessPositionParser(int newX, int newY) {
        this.xCoord = newX;
        this.yCoord = newY;
    }

    /**
     * Разбирает наименование клетки шахматной доски, на которой находится фигура, в
     * <a href="https://w.wiki/7pFN">шахматной нотации</a> и возвращает соответствующий ей объект расположения фигуры на
     * шахматной доске.
     *
     * @param position
     *            наименование клетки шахматной доски, на которой находится фигура
     * @return объект расположения фигуры на шахматной доске, соответствующий переданному наименованию клетки
     */
    public static ChessPosition parse(final String position) {
        String convert = position.toLowerCase();
        char localX = convert.charAt(0);
        char localY = convert.charAt(1);

        if (localX > 'h' || localX < 'a' || localY > '8' || localY < '1') {
            throw new IllegalArgumentException("Введены неверные координаты.");
        }

        int x = localX - 'a';
        int y = localY - '1';
        return new ChessPositionParser(x, y);
    }

    @Override
    public int x() {
        return xCoord;
    }

    @Override
    public int y() {
        return yCoord;
    }
    @Override
    public String toString() {
        char xChar = (char)('a' + xCoord);
        char yChar = (char)('1' + yCoord);
        return String.valueOf(xChar) + String.valueOf(yChar);
    }

}