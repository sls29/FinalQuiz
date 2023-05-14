package org.example;

public class Package {
    public String targetLocation;
    public double distance;
    public double packageValue;
    public int dateYear;
    public int dateMonth;
    public int dateDay;

    public Package(String targetLocation, double distance, double packageValue,
                   int dateYear, int dateMonth, int dateDay) {
        this.targetLocation = targetLocation;
        this.distance = distance;
        this.packageValue = packageValue;
        this.dateYear = dateYear;
        this.dateMonth = dateMonth;
        this.dateDay = dateDay;
    }

    public String toString(){
        return "Destination: " + targetLocation +
                "- Distance: " + distance +
                "- Value: " + packageValue +
                "- Delevery date: " + dateYear + "-" + dateMonth + "-" + dateDay;
    }
}
