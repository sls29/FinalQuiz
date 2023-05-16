package org.example;

public class Package {
    public String targetLocation;
    public double distance;
    public double packageValue;
    public String day;

    public Package(String targetLocation, double distance, double packageValue, String day) {
        this.targetLocation = targetLocation;
        this.distance = distance;
        this.packageValue = packageValue;
        this.day = day;
    }

    public String toString(){
        return "Destination: " + targetLocation +
                "- Distance: " + distance +
                "- Value: " + packageValue +
                "- Delevery date: " + day;
    }
}
