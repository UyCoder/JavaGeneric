package dev.ahmed.exer;

/**
 * MyDate class contains:
 Private member variables year, month, day; and define getter and setter methods for each attribute;

 * @author ahmedBughra
 * @create 2023 09:55 PM
 */
public class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


// @Override
// public int compareTo(Object o) {
// if(o instanceof MyDate){
// MyDate m = (MyDate)o;
//
// // compare years
// int minusYear = this.getYear() - m.getYear();
// if(minusYear != 0){
// return minusYear;
// }
// // compare months
// int minusMonth = this.getMonth() - m.getMonth();
// if(minusMonth != 0){
// return minusMonth;
// }
// // compare day
// return this. getDay() - m. getDay();
// }
//
// throw new RuntimeException("The incoming data type is inconsistent!");
//
// }

    @Override
    public int compareTo(MyDate m) {
        // compare years
        int minusYear = this.getYear() - m.getYear();
        if(minusYear != 0){
            return minusYear;
        }
        // compare months
        int minusMonth = this.getMonth() - m.getMonth();
        if(minusMonth != 0){
            return minusMonth;
        }
        // compare day
        return this. getDay() - m. getDay();
    }
}