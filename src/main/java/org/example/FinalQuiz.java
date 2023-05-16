package org.example;


import java.io.FileNotFoundException;

public class FinalQuiz {
    public static void main(String[] args) throws FileNotFoundException {

        Data data = new Data();

        data.getDataFromCSV();
        data.getPackage();


    }
}