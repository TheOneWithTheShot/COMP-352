package A3.src.ElasticDatabase;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
public class main {

    protected static Sequence<Equipment> sequenceADT;
    protected static HashTable<Equipment> hashTableADT;
    protected static Scanner scanner = new Scanner(System.in);
    protected static boolean usingHashTableADT;
    protected static boolean usingSequenceADT;
    protected static boolean programIsRunning = true;


    /**
     * function that returns the size of the ADT
     * @return
     */
    public static int get_size() {
        return (usingHashTableADT) ? hashTableADT.get_size() : sequenceADT.get_size();
    }
    /**
     * return all keys in ElasticERL as a sorted sequence
     */
    public static void allKeys() {
        PrintWriter pw = null;
        String output = "A3/src/ElasticDatabase/logs/log.txt";
        File log = new File(output);
        try {
            System.out.println("Creating a log file to store all the keys.");
            pw = new PrintWriter(new FileOutputStream(log));
        } catch (FileNotFoundException e) {
            System.out.println("Error when creating the file. Try again.");
            System.exit(0);
        }

        System.out.println("\nFile has been created successfully: log.txt");
        System.out.println("\nProgram is currently sorting the keys and printing them on file.\n");

        Integer[] arrayKeys = new Integer[get_size()];
        if (usingHashTableADT){
            arrayKeys = hashTableADT.allKeys();
        } else {
            arrayKeys = sequenceADT.allKeys();
        }

        pw.println("Sorted keys:");
        if(get_size() == 0) {
            pw.println("No keys to print");
        } else {
            for(Integer each : arrayKeys) {
                pw.println(each);
            }
        }
        pw.println("\nEnd of sorting.");
        pw.flush();

        System.out.println("The process is done. Please open the file to see the result.");
        System.out.println("A log file has been generated.");
    }

    /**
     * Generate a non-existing key of length 8
     */
    public static void generateNonExistingKey() {
        if (usingHashTableADT){
            int size = hashTableADT.get_size();
            Equipment tempName = new Equipment("Equipment: "+ size);
            int key = generateRandomKey();
            hashTableADT.add(key, tempName);
        } else {
            int size = sequenceADT.get_size();
            Equipment tempName = new Equipment("Equipment: "+ size);
            int key = generateRandomKey();
            sequenceADT.add(key, tempName);
        }
        System.out.print("Generation of non-existing key has been been done.");
    }

    /**
     * A method to generate a random 8-digit number
     * @return
     */
    public static int generateRandomKey()
    {
        int randomNum = (int) Math.pow(10, 8 - 1);
        return randomNum + new Random().nextInt(9 * randomNum);
    }

    /**
     * Function to read the file that the user selected
     * @param option
     */
    public static void readChosenFile(int option) {
        String path1 = "A3/src/ElasticDatabase/tests/EHITS_test_file1.txt";
        String path2 = "A3/src/ElasticDatabase/tests/EHITS_test_file2.txt";
        String path3 = "A3/src/ElasticDatabase/tests/EHITS_test_file3.txt";
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
        int counter = 1;
        while (inStream.hasNextLine() && counter < sequenceADT.getEINThreshold()) {
            int key = inStream.nextInt();
            counter++;

            Equipment tempName = new Equipment("Equipment: " + counter);

            if (usingSequenceADT){
                sequenceADT.add(key, tempName);
            } else {
                hashTableADT.add(key, tempName);
            }
        }
        System.out.println(counter);
    }

    /**
     * function that changes the value of boolean programIsRunning
     * stops the program's menu.
     */
    private static void exitProgram(){
        System.out.println("Terminating the program. Good bye.");
        programIsRunning = false;
    }

    /**
     * Function that shows the program's menu
     * @return
     */
    private static int showMenu() {
        while (true) {
            System.out.println("\n========================");
            System.out.println("==== Program's menu ====");
            System.out.println("========================");
            System.out.println("Please select what you want to do\n");
            System.out.println("1. Show all keys (allKeys)");
            System.out.println("2. Generate new non-existing key of 8 digits(generate)");
            System.out.println("3. Add an entry for a given key and value(add)");
            System.out.println("4. Remove the entry for a given key(remove)");
            System.out.println("5. Return the value of a given key(getValues)");
            System.out.println("6. Return the key for the successor of a given key(nextKey)");
            System.out.println("7. Return the key for the predecessor of a given key(prevKey)");
            System.out.println("8. Returns the number of keys that are within a given range of 2 keys(rangeKey)");
            System.out.println("9. Exit Program");
            int option = scanner.nextInt();

            if (option < 1 || option > 9) {
                System.out.println("Please enter a valid option. Try again.\n");
            } else {
                return option;
            }
        }
    }

    public static void executeOption(int option){
        if (option == 1) {
            allKeys();
        } else if (option == 2) {
            generateNonExistingKey();
        } else if (option == 3) {

        } else if (option == 4) {

        } else if (option == 5) {

        } else if (option == 6) {

        } else if (option == 7) {

        } else if (option == 8) {

        } else if (option == 9) {
            exitProgram();
        }
    }
    /**
     * Start program loop
     * @return
     */
    private static void startProgramLoop(){
        while (programIsRunning) {
            int optionChoice = showMenu();
            executeOption(optionChoice);
        }
    }

    public static void main(String[] args) {
        boolean isValid = false;
        int option = 0;
        while (!isValid){
            System.out.println("\n\n----------Welcome to EHITS----------\n");
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
        if (threshold >= 1000) {
            hashTableADT = new HashTable<>();
            usingHashTableADT = true;
            usingSequenceADT = false;
            hashTableADT.setEINThreshold(threshold);
        } else {
            sequenceADT = new Sequence<>();
            usingSequenceADT = true;
            usingHashTableADT = false;
            sequenceADT.setEINThreshold(threshold);
        }
        readChosenFile(option);

        startProgramLoop();

    }
}
