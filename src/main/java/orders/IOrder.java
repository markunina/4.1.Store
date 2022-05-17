package orders;


import products.IProduct;

public interface IOrder {

    long getId();
    void setInWork(boolean inWork);

    boolean isGet();

    boolean isInDelivery();

    boolean isReturn();

    void setInDelivery(boolean b);

    IProduct getProduct();
}
