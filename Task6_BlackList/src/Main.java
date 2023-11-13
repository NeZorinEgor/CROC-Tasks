import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main implements BlacklistFilter{
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("Слово 1");
        comments.add("Слово 2");
        comments.add("Слово 3");
        comments.add("Слово 4");

        Set<String> blacList = new HashSet<>();
        blacList.add("Слово 1");


        BlacklistFilter example = new Main();
        example.filterComments(comments, blacList);
    }

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        int startSize = comments.size();
        for (int i = 0; i < comments.size(); i ++){
            if (comments.get(i).equals("")){
                comments.remove(i);
            }
        }
        System.out.println(comments);
        System.out.println("новая длинна: " + comments.size());
        System.out.println("удаленно элементов: " + (startSize - comments.size()));
    }
}