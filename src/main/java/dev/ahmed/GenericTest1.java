package dev.ahmed;

import com.sun.org.apache.xpath.internal.operations.Or;
import dev.ahmed.exer.Employee;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Ahmed Bughra
 * @create 2023-02-07  1:28 AM
 */
public class GenericTest1 {

    @Test
    public void test1() {
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("ahmed");

        // use generic type in real development
        Order<String> order1 = new Order<String>("AA",123,"me");

        order1.setOrderT("AA:");
    }
        @Test
        public void test2 (){
          SubOrder sub1 = new SubOrder();
          sub1.setOrderT(123);

            SubOrder1<String> sub2 = new SubOrder1<>();
            sub2.setOrderT("order...");

    }

    @Test
    public void test3() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
        // it can not be copy just becaue the generic types are different
//        list1 = list2;

        Employee p1 = null;
        Employee p2 = null;
        p1 = p2;



    }
}
