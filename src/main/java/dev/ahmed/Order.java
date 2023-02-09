package dev.ahmed;

/**
 * Custom Generic CLass
 * @author Ahmed Bughra
 * @create 2023-02-07  1:24 AM
 */
public class Order<T> {
    String orderName;
    int orderId;

    //

    T orderT;

    public Order() {

    };

    public Order(String orderName, int orderId, T orderT) {
        this.orderName=orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }
}
