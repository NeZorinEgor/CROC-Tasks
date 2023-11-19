package Model;

import java.time.LocalDate;

/**
 *             <saleID>1</saleID>
 *             <sellerID>1</sellerID>
 *             <productID>1</productID>
 *             <quantity>10</quantity>
 *             <saleDate>2023-11-17</saleDate>
 */
public class Sales {
    private int saleID;
    private int sellerID;
    private int productID;
    private int quantity;
    private String saleDate;

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

    @Override
    public String toString() {
        return "Sales{" +
                "saleID=" + saleID +
                ", sellerID=" + sellerID +
                ", quantity=" + quantity +
                ", saleDate='" + saleDate + '\'' +
                '}';
    }
}
