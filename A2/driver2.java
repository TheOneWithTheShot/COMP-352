package A2;
/**
 * Driver class
 * Student name: Xavier Guertin
 * Student id: 40213525
 */
import java.io.*;
import java.util.Scanner;
//import recursiveAlgo;

public class driver2 {

    //path of where I want the report file to be created, you have to modify this path respectively to your system
    private static String outputFile = "C:\\Users\\xavie\\OneDrive - Concordia University - Canada\\2nd year\\3rd session\\Workspace JB\\COMP-352\\A2\\Reports\\out.txt";
    private static String inputFile = "C:\\Users\\xavie\\OneDrive - Concordia University - Canada\\2nd year\\3rd session\\Workspace JB\\COMP-352\\A2\\Reports\\in.txt";
    static int nbOfSets = 0;

    public static void main(String[] args) {

        System.out.println("Process has started");

        createOutFile(outputFile);

        writeToReportFile(outputFile, "Recursive Method results:\n");

        //calls recursive algorithm with the sets and prints to out.txt
        //which return the message to print to the report.
//        writeToReportFile(outputFile, recursiveAlgo.recursive(getInput(inputFile)));

        writeToReportFile(outputFile, "Stack Method results:\n");


        System.out.println("The process has ended. Please refer to the output file.");
    }


    private static String[][] getInput(String inputFile) {
        String[][] sets = new String[0][1];
        try {
            File myObj = new File(inputFile);
            Scanner myReader = new Scanner(myObj);

            nbOfSets = Integer.parseInt(myReader.nextLine());
            sets = new String[nbOfSets][1];

            while (myReader.hasNextLine()) {
                for (int i = 0; i < nbOfSets; i++) {
                    sets[i][0] = String.valueOf(myReader.nextLine().split(" "));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return sets;
    }

    private static void createOutFile (String outputFile) {

        File reportFile = new File(outputFile);

        if (reportFile.exists()) { //if report exists then delete it
            reportFile.delete();
        }

        try { //try-catch block to create the new file
            reportFile.createNewFile();
        } catch (IOException e) {
            System.out.println("There was a problem with the creation of the file: " + e.getMessage());
        }
    }
    private static void writeToReportFile(String fileName, String message) {

        BufferedWriter outStream = null;

        try { //try-catch block to write the message on the file
            outStream = new BufferedWriter(new FileWriter(fileName, true));
            outStream.write(message);
        } catch (IOException e) {
            System.out.println("There was a problem while writing on the file: " + e.getMessage());
        } finally {
            try {
                outStream.close(); //close stream buffer
            } catch (IOException e) {
                System.out.println("There was a problem while closing the stream: " + e.getMessage());
            }
        }
    }
}
