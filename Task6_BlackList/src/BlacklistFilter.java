import java.util.List;
import java.util.Set;

public interface BlacklistFilter {
    /**
     * Интерефейс из задания. В метод фильтра перелается лист комментариев и сет запрешенных слов.
     * @param comments
     * @param blackList
     */
    void filterComments(List<String> comments, Set<String> blackList);
}
