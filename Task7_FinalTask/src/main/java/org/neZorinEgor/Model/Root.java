package org.neZorinEgor.Model;

import java.util.List;
/**
 *   Сборник моделей продаж и товаров
 */
public class Root {
    private List<Sale> sales;
    private List<Product> products;

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
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