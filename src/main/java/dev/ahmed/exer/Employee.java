package dev.ahmed.exer;

/**
 * Define an Employee class.
 The class contains: private member variables name,age,birthday, where birthday is an object of the MyDate class.
 and defines getter, setter methods for each of the properties.
 and override the toString method to output name, age, birthday

 * @author ahmedBughra
 * @create 2023 09:55 PM
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public Employee() {

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
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
    //Writing when specifying generics
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }

    //How to write when no generic type is specified
    //Sort by name
// @Override
// public int compareTo(Object o) {
// if(o instanceof Employee){
// Employee e = (Employee)o;
// return this.name.compareTo(e.name);
// }
//// return 0;
// throw new RuntimeException("The incoming data type is inconsistent!");
// }
}