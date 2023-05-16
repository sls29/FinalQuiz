package org.example;

public class Day {
    public int year;
    public int month;
    public int day;

    public Day(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
