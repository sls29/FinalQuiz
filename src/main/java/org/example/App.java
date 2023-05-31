package org.example;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> lines = FileReader.readFile("data.csv");
        List<Package> packages = new ArrayList<>();

        for (String line : lines) {
            try {
                Package newPackage = Package.createPackage(line);
                packages.add(newPackage);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        List<DeliveryGroup> deliveryGroups = new DeliveryGroup().createGroups(packages);
        printDeliveries(deliveryGroups);
    }


    public static void printDeliveries(List<DeliveryGroup> deliveryGroups) {
        deliveryGroups.forEach(deliveryGroup -> new Thread(() -> {
            deliveryGroup.computeRevenue();
            deliveryGroup.computeValue();
            System.out.println(deliveryGroup);
        }).start());
    }
}