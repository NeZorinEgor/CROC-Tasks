package org.neZorinEgor.Model;

import java.util.List;

public class Root {
    private List<Sales> sales;
    private List<Product> products;

    public List<Sales> getSales() {
        return sales;
    }

    public void setSales(List<Sales> sales) {
        this.sales = sales;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Root{" +
                "sales=" + sales +
                ", products=" + products +
                '}';
    }
}