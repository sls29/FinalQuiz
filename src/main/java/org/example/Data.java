package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Data {

    ArrayList<String> dataArray = new ArrayList<>();
    LinkedList<String> lineRead = new LinkedList<>();
    LinkedList<Package> Package = new LinkedList<>();

    public void getDataFromCSV() throws FileNotFoundException {

        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(
                    "data.csv"));
            scanner.useDelimiter(System.getProperty("line.separator"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        try {
            scanner.hasNextLine();
            while (scanner.hasNextLine()) {
                dataArray.add(scanner.nextLine());
            }
            scanner.close();
        } catch (NullPointerException e) {
            System.out.printf("Incorrect data!" + e.getMessage());
        }
    }

    public void getPackage() {
        for (String line : dataArray) {
            String[] packageData = line.split(",");
            lineRead.add(Arrays.toString(packageData));

            Package.add(new Package(packageData[0], Double.parseDouble(packageData[1]), Double.parseDouble(packageData[2]),
                    packageData[3]));
        }
    }

}
