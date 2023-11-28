package org.neZorinEgor.Model;

/**
 *             <saleID>1</saleID>
 *             <sellerID>1</sellerID>
 *             <productID>1</productID>
 *             <quantity>10</quantity>
 *             <saleDate>2023-11-17</saleDate>
 */
public class Sales {
    private final int saleID;
    private final int sellerID;
    private final int productID;
    private final int quantity;
    private final String saleDate;

    public Sales(int saleID, int sellerID, int productID, int quantity, String saleDate) {
        this.saleID = saleID;
        this.sellerID = sellerID;
        this.productID = productID;
        this.quantity = quantity;
        this.saleDate = saleDate;
    }

    public int getSaleID() {
        return saleID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public int getProductID(){
        return productID;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "saleID=" + saleID +
                ", sellerID=" + sellerID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", saleDate='" + saleDate + '\'' +
                '}';
    }
}
