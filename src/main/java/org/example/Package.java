
package org.example;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Package {
    private String location;
    private double distance;
    private double value;
    private LocalDate deliveryDate;

    public static Package createPackage(String line) {
        if (line.isEmpty() || line.split(",").length != 4) {
            throw new RuntimeException("Could not create package");
        }
        String[] tokens = line.split(",");
        return Package.builder()
                .location(tokens[0])
                .distance(Double.parseDouble(tokens[1]))
                .value(Double.parseDouble(tokens[2]))
                .deliveryDate(LocalDate.parse(tokens[3]))
                .build();
    }
}