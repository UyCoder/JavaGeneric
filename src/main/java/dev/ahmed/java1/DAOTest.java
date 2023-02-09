package dev.ahmed.java1;

import org.junit.Test;

import java.util.List;

/**
 * @author Ahmed Bughra
 * @create 2023-02-10  12:15 AM
 */
public class DAOTest {

    @Test
    public void test() {
        CustomerDAO customerDAO = new CustomerDAO();

        customerDAO.add(new Customer());
        List<Customer> forList = customerDAO.getForList(10);
    }

    @Test
    public void test1() {
        StudentDAO studentDAO = new StudentDAO();
        Student index = studentDAO.getIndex(2);

    }
}
