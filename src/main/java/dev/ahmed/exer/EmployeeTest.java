package dev.ahmed.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Create 5 objects of this class, and put these objects into the TreeSet collection (next chapter: TreeSet needs to be defined using generics)
 Sort the elements in the collection in the following two ways, and iterate over the output:

 1). Make Employee implement Comparable interface and sort by name
 2). Pass in the Comparator object when creating the TreeSet, and sort by birthday date.

 *
 * @author ahmedBughra
 * @create 2023 09:55 PM
 */
public class EmployeeTest {

    //Question 2: Sort by birthday date.
    @Test
    public void test2(){

        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            //Writing after using generics
            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1. getBirthday();
                MyDate b2 = o2. getBirthday();

                return b1. compareTo(b2);
            }
            //Writing before using generics
            //@Override
// public int compare(Object o1, Object o2) {
// if(o1 instanceof Employee && o2 instanceof Employee){
// Employee e1 = (Employee)o1;
// Employee e2 = (Employee)o2;
//
// MyDate b1 = e1. getBirthday();
// MyDate b2 = e2. getBirthday();
//                    //method one:
//// // compare year
//// int minusYear = b1.getYear() - b2.getYear();
//// if(minusYear != 0){
//// return minusYear;
//// }
//// // compare month
//// int minusMonth = b1.getMonth() - b2.getMonth();
//// if(minusMonth != 0){
//// return minusMonth;
//// }
//// //Compare day
//// return b1.getDay() - b2.getDay();
//
// //Method 2:
// return b1. compareTo(b2);
//
// }
//// return 0;
// throw new RuntimeException("The incoming data type is inconsistent!");
// }
        });

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangzhaowei",21,new MyDate(1978,12,4));

        set. add(e1);
        set. add(e2);
        set. add(e3);
        set. add(e4);
        set. add(e5);

        Iterator<Employee> iterator = set. iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    //Question 1: Use natural sorting
    @Test
    public void test1(){
        TreeSet<Employee> set = new TreeSet<Employee>();

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1987,5,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1987,5,9));
        Employee e4 = new Employee("liming",51,new MyDate(1954,8,12));
        Employee e5 = new Employee("liangzhaowei",21,new MyDate(1978,12,4));

        set. add(e1);
        set. add(e2);
        set. add(e3);
        set. add(e4);
        set. add(e5);

        Iterator<Employee> iterator = set. iterator();
        while (iterator.hasNext()){
            Employee employee = iterator. next();
            System.out.println(employee);
        }
    }
}