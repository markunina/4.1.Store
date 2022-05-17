package users;

import orders.IOrder;
import orders.Order;
import products.IProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static main.Main.rating;

public class Buyer extends User implements IBuyer{

    private String name;
    private int age;
    List<IProduct> wishList = new ArrayList<>();
    List<IProduct> cart = new ArrayList<>();
    List<IOrder> orders = new ArrayList<>();

    public Buyer(String login, String password) {
        super(login, password);
    }

    public Buyer(String login) {
        super(login);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }

    @Override
    public List<IProduct> getWishList() {
        return wishList;
    }

    @Override
    public List<IProduct> getCart() {
        return cart;
    }

    @Override
    public List<IOrder> getOrders() {
        return orders;
    }

    @Override
    public boolean addToWishList(IProduct product) {
        return wishList.add(product);
    }

    @Override
    public boolean removeFromWishList(IProduct product) {
        return wishList.remove(product);
    }

    @Override
    public boolean addToCart(IProduct product) {
        if(product.getQuantity() > 0){
            product.setQuantity(product.getQuantity()-1);
            cart.add(product);
        }
        return false;
    }

    @Override
    public boolean removeFromCart(IProduct product) {
        return false;
    }

    @Override
    public List<IOrder> makeOrder() {
        List<IOrder> orders = new ArrayList<>();
        if(cart.size() > 0) {
            for(int i = 0; i < cart.size();i++){
                IProduct product = cart.get(i);
               if(pay(product.getPrice())){
                   IOrder order = new Order(product);
                   orders.add(order);
                   cart.remove(product);
               }
            }
        }
        return orders;
    }

    @Override
    public boolean pay(double price) {
        return true;//заглушка на метод оплаты
    }

    @Override
    public List<IOrder> getOrderlist() {
        return orders;
    }

    @Override
    public boolean giveReview(Map<IProduct, List<Integer>> ratings, IProduct product, int productRating){
        var itemsForRating = orders.stream().filter(o -> o.isGet()).toList();
        if (itemsForRating.contains(product)){
            rating.setRating(product,productRating);
            return true;
        }
        return false;
    }
}
