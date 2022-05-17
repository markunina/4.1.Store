package products;

public interface IProduct {

    long getId();

    double getPrice();

    int getQuantity();

    void setQuantity(int quantity);

    String getProductName();

    String getDescription();
}
