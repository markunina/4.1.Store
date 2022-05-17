package users;

import orders.IOrder;
import products.IProduct;

import java.util.List;
import java.util.Map;

public interface IBuyer {

    boolean addToWishList(IProduct product);
    boolean removeFromWishList(IProduct product);
    boolean addToCart(IProduct product);
    boolean removeFromCart(IProduct product);
    List<IOrder> makeOrder();
    boolean pay(double price);
    List<IOrder> getOrderlist();
    boolean giveReview(Map<IProduct, List<Integer>> ratings, IProduct product, int productRating);
    List<IProduct> getWishList();
    List<IProduct> getCart();
    List<IOrder> getOrders();

}
