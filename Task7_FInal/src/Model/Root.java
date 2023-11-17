package Model;


import java.util.List;

public class Root {
    private List<Sellers> sellers;

    public Root(List<Sellers> sellers) {
        this.sellers = sellers;
    }

    public List<Sellers> getSellers() {
        return sellers;
    }

    @Override
    public String toString() {
        return "Root{" +
                "sellers=" + sellers +
                '}';
    }
}
