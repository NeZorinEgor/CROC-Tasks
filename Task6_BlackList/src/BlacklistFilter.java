import java.util.List;
import java.util.Set;

public interface BlacklistFilter {


    void filterComments(List<String> comments, Set<String> blackList);
}
