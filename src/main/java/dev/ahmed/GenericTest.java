package dev.ahmed;

import org.junit.Test;

import java.util.*;

/**
 *
 * The use of generic types
 * 1. jdk 5.0 new features
 *
 * 2. Using generics in collections.
 * Summary.
 * ① Collection interfaces or collection classes are modified to structures with generics in jdk 5.0.
 * ② When instantiating a collection class, you can specify the specific generic type
 * ③ After specifying, whenever a class or interface is defined in a collection class or interface, the internal structure (e.g., methods, constructors, properties, etc.) that uses the generic type of the class is specified as the instantiated generic type.
 * For example: add(E e) ---> after instantiation: add(Integer e)
 * ④ Note: The type of the generic type must be a class, not a basic data type. Where a basic data type is needed, take the wrapper class instead
 * ⑤ If the type of the generic type is not specified when instantiating. The default type is java.lang.Object type.
 *
 * 3. How to customize the generic structure: generic classes, generic interfaces; generic methods. See GenericTest1.java
 *
 * @author ahmed Bughra
 * @create 2023 9:59 Pm
 */


public class GenericTest {

    /**
     *
     * The use of generic types
     * 1. jdk 5.0 new features
     *
     * 2. Using generics in collections.
         * Summary.
             * ① Collection interfaces or collection classes are modified to structures with generics in jdk 5.0.
             * ② When instantiating a collection class, you can specify the specific generic type
             * ③ After specifying, whenever a class or interface is defined in a collection class or interface, the internal structure (e.g., methods, constructors, properties, etc.) that uses the generic type of the class is specified as the instantiated generic type.
                  *   For example: add(E e) ---> after instantiation: add(Integer e)
             * ④ Note: The type of the generic type must be a class, not a basic data type. Where a basic data type is needed, take the wrapper class instead
             * ⑤ If the type of the generic type is not specified when instantiating. The default type is java.lang.Object type.
         *
     * 3. How to customize the generic structure: generic classes, generic interfaces; generic methods. See GenericTest1.java
     *
     * @author shkstart
     * @create 2019 9:59 am
     */// Before using generics in collections.
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //Requirement: store students' grades
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
        // Problem 1: type insecurity
        // list.add("Tom");

        for(Object score : list){
            // Problem 2: ClassCastException may occur when strong rotation
            int stuScore = (Integer) score;
            System.out.println(stuScore);

        }

    }

    //The case of using generics in collections: ArrayList as an example
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);
        // Type checking is done at compile time to keep the data safe
// list.add("Tom");

        // solution one.
        // for(Integer score : list){
        // // avoiding the strong-transfer operation
        // int stuScore = score;
        //
        // System.out.println(stuScore);
        //
        // }
        // solition two.
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }

    }

    // The case of using generics in collections: HashMap as an example
    @Test
    public void test3(){
// Map<String,Integer> map = new HashMap<String,Integer>();
        // jdk7 new feature: type inference
        Map<String,Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("Jerry",87);
        map.put("Jack",67);

// map.put(123, "ABC");
        // nesting of generic types
        Set<Map.Entry<String,Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "----" + value);
        }

    }


}
