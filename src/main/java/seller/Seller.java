package seller;

import orders.IOrder;
import products.IProduct;
import products.Product;

import java.util.List;

public class Seller implements ISeller{

    private final String sellerName;


    public Seller(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerName() {
        return sellerName;
    }

    @Override
    public boolean addProduct(String productName, String description, int quantity, double price, List<IProduct> products) {
        if(!productName.equals("") && quantity >= 0 && price > 0){
            IProduct product = new Product(productName,description,quantity,price,sellerName);
            products.add(product);
            return true;
        }
        return false;
    }

    @Override
    public void acceptOrder(IOrder order) {
        order.setInWork(true);
    }

    @Override
    public void sendOrder(IOrder order) {
        order.setInDelivery(true);
    }



}
