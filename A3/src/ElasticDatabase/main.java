package A3.src.ElasticDatabase;

import java.io.*;
import java.util.Scanner;

public class main {

    private final static int IDLENGTH = 8;
    protected static Sequence<Equipment> sequenceADT;
    protected static Scanner scanner = new Scanner(System.in);

    /**
     * Function to read the file that the user selected
     * @param option
     */
    public static void readChosenFile(int option) {
        String path1 = "./tests/EHITS_test_file1.txt";
        String path2 = "./tests/EHITS_test_file2.txt";
        String path3 = "./tests/EHITS_test_file3.txt";
        File fileToOpen = null;

        if (option == 1) {
            fileToOpen = new File(path1);
        } else if (option == 2) {
            fileToOpen = new File(path2);
        } else if (option == 3) {
            fileToOpen = new File(path3);
        }

        Scanner inStream = null;
        try {
            System.out.println("\nThe program is currently opening file " + option + "...\n");
            inStream = new Scanner(new FileInputStream(fileToOpen));
        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file");
            System.exit(0);
        }
        int counter = 0;
        while (inStream.hasNextLine()) {
            long key = inStream.nextInt();
            counter++;

            Equipment tempName = new Equipment("Equipment: " + counter);

//            sequenceADT.add(key, tempName);
        }
    }

    public static void main(String[] args) {

        sequenceADT = new Sequence<>();

        boolean isValid = false;
        int option = 0;
        while (!isValid){
            System.out.println("Welcome to EHITS.\n");
            System.out.println("Please select which file you want to test:");
            System.out.println("1. test file 1 containing 50 000 entries");
            System.out.println("2. test file 2 containing 50 000 entries");
            System.out.println("3. test file 3 containing 1 000 000 entries");
            option = scanner.nextInt();

            if (option != 1 && option != 2 && option != 3) {
                System.out.println("Please enter a valid option. Try again.\n");

            } else {
                isValid = true;
            }
        }
        isValid = false;
        int threshold = 0;
        while (!isValid) {
            System.out.println("\nPlease provide the number of data you want to retrieve(between 100 and 500000)");
            threshold = scanner.nextInt();

            if (threshold < 100 || threshold > 500000) {
                System.out.println("Please enter a valid threshold. Try again.\n");
            } else {
                isValid = true;
            }
        }
        sequenceADT.setEINThreshold(threshold);
        readChosenFile(option);
    }
}
