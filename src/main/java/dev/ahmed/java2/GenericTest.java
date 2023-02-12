package dev.ahmed.java2;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author ahmed
 * @create 2023 2:13
 */
public class GenericTest {

    /*
      1. The embodiment of generics in inheritance
        Although class A is the parent class of class B, G<A> and G<B> do not have a child-parent relationship, and the two are in a parallel relationship.
        Supplement: Class A is the parent class of class B, and A<G> is the parent class of B<G>
    */
    @Test
    public void test1(){

        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;
//compilation failed
// Date date = new Date();
// str = date;
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //The types of list1 and list2 at this time do not have a child-parent relationship
        //compilation failed
// list1 = list2;
         /*
         Counter-evidence:
         Suppose list1 = list2;
            list1.add(123); causes non-String data to be mixed. error.

          */

        show(list1);
        show1(list2);

    }



    public void show1(List<String> list){

    }

    public void show(List<Object> list){

    }

    @Test
    public void test2(){

        AbstractList<String> list1 = null;
        List<String> list2 = null;
        ArrayList<String> list3 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();

    }

   /*
     2. Use of wildcards
        Wildcard: ?

        Class A is the parent class of class B, G<A> and G<B> are irrelevant, the common parent class of both is: G<?>


      */

    @Test
    public void test3(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list1;
        list = list2;
        // compile passed
//        print(list1);
//        print(list2);


        //
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");
        list = list3;
//Add (write): For List<?>, you cannot add data to it.
        //in addition to adding null.
// list.add("DD");
//        list.add('?');

        list.add(null);

//Get (read): Allows to read data, the type of data read is Object.
        Object o = list.get(0);
        System.out.println(o);


    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }

    /*
       3. Use of wildcards with restrictions.
           ? extends A:
                   G<? extends A> can be used as the parent class of G<A> and G<B>, where B is a subclass of A

           ? super A:
                   G<? super A> can be used as the parent class of G<A> and G<B>, where B is the parent class of A

        */
    @Test
    public void test4(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;
//Read data:
        list1 = list3;
        Person p = list1. get(0);
        //compilation failed
        //Student s = list1. get(0);

        list2 = list4;
        Object obj = list2. get(0);
        ////Compilation failed
// Person obj = list2. get(0);

        //data input:
        //compilation failed
// list1. add(new Student());

        // compile passed
        list2. add(new Person());
        list2. add(new Student());

    }

}
