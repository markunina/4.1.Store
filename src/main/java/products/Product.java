package products;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product implements IProduct{

    private static long count = 1;

    private final long id;
    private final String productName;
    private String description;
    private int quantity;
    private final String sellerName;
    private double price;

    public Product(String productName, String description, int quantity, double price, String sellerName) {
        this.id = count;
        this.productName = productName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.sellerName = sellerName;
        count++;
    }

    public static long getCount() {
        return count;
    }

    public long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSellerName() {
        return sellerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", sellerName='" + sellerName + '\'' +
                ", price=" + price +
                '}';
    }
}
