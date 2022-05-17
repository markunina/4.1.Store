package seller;

import orders.IOrder;
import products.IProduct;

import java.util.List;

public interface ISeller {

    boolean addProduct(String productName, String description, int quantity, double price, List<IProduct> products);

    void acceptOrder(IOrder order);

    void sendOrder(IOrder order);

}
