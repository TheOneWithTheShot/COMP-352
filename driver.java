import java.util.stream.IntStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class driver {

    public static int[] array = { 1, 1, 1 };
    private static String resultsFile = "C:\\Users\\xavie\\OneDrive - Concordia University - Canada\\2nd year\\3rd session\\Workspace JB\\COMP-352-A1\\Reports\\OddoOut.txt";
    private static String executionTimeFile = "C:\\Users\\xavie\\OneDrive - Concordia University - Canada\\2nd year\\3rd session\\Workspace JB\\COMP-352-A1\\Reports\\OddoExecutionTime.txt";

    public static void main(String[] args) {

        long startCounter;
        long endCounter;

        int result;

        int[] oddonacciLinearRecursive_results = new int[20];
        int[] oddonacciExponentialRecursive_results = new int[20];
        int counter = 0;

        String numbers; //String of the numbers of the algorithms for the report
        StringBuilder sb = new StringBuilder(); //String builder to append the string "numbers"

        createOutputFile(resultsFile);

        writeToFile(resultsFile, "This file has been generated by the driver's class. This class has been made by myself and myself only." +
                                    "\nStudent name: Xavier Guertin\nStudent number: 40213525\n\n");


        /**
         * Linear complexity algorithm
         */
        //Starting timer of the Oddonacci recursive linear complexity algorithm.
        startCounter = System.currentTimeMillis();

        //for loop that store every oddonacci number into an array that will be put in the report
        for (int i = 0; i<20 ; i++){
            oddonacciLinearRecursive_results[counter] = (linearComplexity.oddonacciLinearRecursive(i))[2];
            counter ++;
        }

        //ends the counter
        endCounter = System.currentTimeMillis();

        //for loop that appends every oddonacci number to a string
        for(int i = 0; i<20; i++) {
            numbers = String.valueOf(oddonacciLinearRecursive_results[i]);
            sb.append(numbers + ", ");
        }

        //calls the function that writes the str to the report file
        writeToFile(resultsFile, "Oddonacci recursive linear complexity results: [START] {" + sb + "} [END]" +
                                    "\nThe execution time is: " + (endCounter - startCounter) + " ms\n\n");


        /**
         * Exponential complexity algorithm
         */
        //reset variables
        startCounter = 0;
        endCounter = 0;
        numbers = "";
        sb.setLength(0);
        counter = 0;

        //Starting timer of the Oddonacci recursive exponential complexity algorithm.
        startCounter = System.currentTimeMillis();

        //for loop that store every oddonacci number into an array that will be put in the report
        for (int i = 0; i<20 ; i++){
            oddonacciExponentialRecursive_results[counter] = (exponentialComplexity.oddonacciExponentialRecursive(i));
            counter ++;
        }

        //ends the counter
        endCounter = System.currentTimeMillis();

        //for loop that appends every oddonacci number to a string
        for(int i = 0; i<20; i++) {
            numbers = String.valueOf(oddonacciExponentialRecursive_results[i]);
            sb.append(numbers + ", ");
        }

        //calls the function that writes the str to the report file
        writeToFile(resultsFile, "Oddonacci recursive exponential complexity results: [START] {" + sb + "} [END]" +
                "\nThe execution time is: " + (endCounter - startCounter) + " ms\n\n");



        // Tail_Linear Oddonacci Recursion much faster than binary

//        startCounter = System.currentTimeMillis();
//
//        linear_numbers = oddonacci_tailLinear(totalNumbers);
//
//        endCounter = System.currentTimeMillis();
//
//        writeToFile(resultsFile, "Tail Linear Recursion result= " + linear_numbers[2]);
//
//        writeToFile(executionTimeFile,
//
//                "Tail Linear Recursion execution time:: " + (endCounter - startCounter) + " Milliseconds");

        System.out.println("Done!!");
    }

    private static void createOutputFile(String outputFileName) {

        File resultsFile = new File(outputFileName);

        if (resultsFile.exists()) {
            resultsFile.delete();

            try {
                resultsFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Output file not found" + e.getMessage());
            }
        }
    }
    private static void writeToFile(String outputFileName, String str) {

        BufferedWriter out = null;

        try {
            out = new BufferedWriter(new FileWriter(outputFileName, true));
            out.write(str);
        } catch (IOException e1) {
            System.out.println("Writing to file failed." + e1.getMessage());
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                System.out.println("Output buffer can't close." + e.getMessage());
            }
        }
    }
}

//    public static void main(String[] args) {
//
////        System.out.println("[START]:");
////        for (int i=5; i<=100; i += 5) {
////            System.out.print(exponentialComplexity.oddonacciRecursive(i) + ", ");
////        }
////        System.out.println("\n[END]");
//
//        System.out.println("[START]:");
//        for (int i=0; i<=20; i ++) {
//            System.out.print(IntStream.of(linearComplexity.oddonacciTail(i)).sum() + ", ");
//        }
//        System.out.println("\n[END]");
//    }