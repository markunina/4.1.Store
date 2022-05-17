package orders;

import products.IProduct;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order implements IOrder {
    private static long count;
    private LocalDate dateOrder;
    private IProduct product;
    private long id;
    private boolean isInWork;
    private boolean isInDelivery;
    private boolean isInStore;
    private boolean isGet;
    private boolean isReturn;

    private static List<IOrder> orders = new ArrayList<>();

    public Order(IProduct product) {
        this.product = product;
        this.dateOrder = LocalDate.now();
        this.id = count;
        this.isInWork = true;
        count++;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public IProduct getProduct() {
        return product;
    }

    public void setProduct(IProduct product) {
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isInWork() {
        return isInWork;
    }

    @Override
    public void setInWork(boolean inWork) {
        isInWork = inWork;
    }

    @Override
    public boolean isInDelivery() {
        return isInDelivery;
    }

    @Override
    public void setInDelivery(boolean inDelivery) {
        isInDelivery = inDelivery;
    }

    public boolean isInStore() {
        return isInStore;
    }

    public void setInStore(boolean inStore) {
        isInStore = inStore;
    }

    public boolean isGet() {
        return isGet;
    }

    public void setGet(boolean get) {
        isGet = get;
    }

    public boolean isReturn() {
        return isReturn;
    }

    public void setReturn(boolean aReturn) {
        isReturn = aReturn;
    }

    public static List<IOrder> getOrders() {
        return orders;
    }

    public static void setOrders(List<IOrder> orders) {
        Order.orders = orders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "dateOrder=" + dateOrder +
                ", item=" + product +
                ", id=" + id +
                ", isInWork=" + isInWork +
                ", isInDelivery=" + isInDelivery +
                ", isInStore=" + isInStore +
                ", isReturn=" + isReturn +
                '}';
    }
}
