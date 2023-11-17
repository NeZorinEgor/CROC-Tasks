package Model;
/**
 *             <sellerID>1</sellerID>
 *             <lastName>Иванов</lastName>
 *             <firstName>Иван</firstName>
 */
public class Sellers {
    private int sellerID;
    private String lastName;
    private String firstName;

    public Sellers(int sellerID, String lastName, String firstName){
        this.sellerID = sellerID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getSellerID() {
        return sellerID;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Sellers{" +
                "sellerID=" + sellerID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
