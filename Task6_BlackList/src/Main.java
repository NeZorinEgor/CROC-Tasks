import java.util.*;

public class Main implements BlacklistFilter{
    public static void main(String[] args) {
        /**
         * Создаем список комментариев
         */
        List<String> comments = new ArrayList<>(List.of("Словasdо", "Слово", "Не слово", "Слово", "Слово"));

        /**
         * Создаем черный список щапреток.
         */
        Set<String> blackList = new HashSet<>();
        blackList.add("Слово");
        blackList.add("Не слово");


        BlacklistFilter example = new Main();
        example.filterComments(comments, blackList);
    }

    /**
     * @param blackList
     * @param comments
     * Перебираем список comments в обратном порядке и убираем элементы из blackList
     */

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        int startSize = comments.size();
        System.out.println(comments);

        Iterator<String> iterator = comments.iterator();
        while (iterator.hasNext()) {
            String comment = iterator.next();
            if (blackList.contains(comment)) {
                iterator.remove();
            }
        }
        System.out.println(comments);
        System.out.println("удалено элементов: " + (startSize - comments.size()));
    }

}