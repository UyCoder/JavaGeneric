package dev.ahmed;

import java.util.ArrayList;
import java.util.List;

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

//    public static void show(T orderT) {
//        System.out.println(orderT);
//    }

//    public show() {
////        T[] arr = new T[10];
////        T[] arr = (T[]) new Object[10];
//    }

    //Generic Method
    public <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}
