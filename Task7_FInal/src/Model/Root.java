package Model;

import java.util.List;

public class Root{
    private List<Sales> sales;

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Root{" +
                "sales=" + sales +
                '}';
    }
}