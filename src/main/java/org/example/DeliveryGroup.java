package org.example;

import lombok.ToString;

import java.time.LocalDate;
import java.util.*;
@ToString
public class DeliveryGroup {
    private LocalDate deliveryDate;
    private final List<Package> packages = new ArrayList<>();
    private double value;
    private double revenue;

    public List<DeliveryGroup> createGroups(List<Package> packages){
        List<DeliveryGroup> groups = new ArrayList<>();
        packages
                .forEach(currentPackage -> {
                    if (!containsDate(groups, currentPackage.getDeliveryDate())) {
                        DeliveryGroup deliveryGroup = new DeliveryGroup();
                        deliveryGroup.deliveryDate = currentPackage.getDeliveryDate();
                        deliveryGroup.packages.add(currentPackage);
                        groups.add(deliveryGroup);
                    } else {
                        DeliveryGroup deliveryGroup = groups
                                .stream()
                                .filter(currentGroup -> currentGroup.deliveryDate.equals(currentPackage.getDeliveryDate()))
                                .findFirst()
                                .get();
                        deliveryGroup.packages.add(currentPackage);
                    }
                });

        return groups;
    }

    public double computeValue(){
        value = packages.stream()
                .map(Package::getValue)
                .mapToDouble(Double::doubleValue)
                .sum();
        return value;
    }

    public double computeRevenue(){
        revenue = packages.stream()
                .map(Package::getDistance)
                .mapToDouble(Double::doubleValue)
                .sum();
        return revenue;
    }

    boolean containsDate(List<DeliveryGroup> groups, LocalDate date) {
        for(DeliveryGroup group : groups) {
            if (group.deliveryDate == date) return true;
        }
        return false;
    }

}