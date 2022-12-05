package A3.src.ElasticDatabase;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    protected static Sequence<Equipment> sequenceADT;
    protected static HashTable<Equipment> hashTableADT;
    protected static Scanner scanner = new Scanner(System.in);
    protected static boolean usingHashTableADT;
    protected static boolean usingSequenceADT;
    protected static boolean programIsRunning = true;

    /**
     * method that returns the size of the ADT
     * @return - returns the size
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
     *  add an entry for the given key and value
     * @param key - key
     */
    public static void add(int key, String name){
        Equipment temp = new Equipment(name);

        if(usingHashTableADT) {
            System.out.println("\nThe program is adding: "+ key +" to the hash table ADT.");
            hashTableADT.add(key, temp);
        } else {
            System.out.println("\nThe program is adding: "+ key +" to the sequence ADT.");
            sequenceADT.add(key, temp);
        }
        System.out.println("The key has been successfully added.");
    }

    /**
     * remove the entry for the given key
     * @param key - key
     */
    public static void remove(int key) {
        DatabaseEntry<Equipment> result = null;
        if(usingHashTableADT) {
            System.out.println("\nThe program is removing this key: "+ key +" from the hash table ADT.");
            result = hashTableADT.remove(key);
        } else {
            System.out.println("\nThe program is removing this key: "+ key +" from the sequence ADT.");
            result = sequenceADT.remove(key);
        }
        if (result != null) {
            System.out.println(key + " has been removed successfully.");
        } else {
            System.out.println("Key " + key + " does not exist");
        }
    }

    /**
     * return the values of the given key
     * @param key - key
     */
    public static void getValues(int key) {
        Equipment temp = (usingHashTableADT) ? hashTableADT.getValues(key) : sequenceADT.getValues(key);

        if(temp == null) {
            System.out.println("No keys have been found");
        } else {
            System.out.println("Here's the value of key " + key +": " + temp);
        }
    }

    /**
     * return the key for the successor of key
     * @param key - key
     */
    public static void nextKey(int key) {
        int nextKey = (usingHashTableADT) ? hashTableADT.nextKey(key) : sequenceADT.nextKey(key);

        if(nextKey != 0) {
            System.out.println("Current key: " + key + ". Next key is: " + nextKey);
        }
    }

    /**
     * return the key for the predecessor of key
     * @param key - key
     */
    public static void prevKey(int key){
        int prevKey = (usingHashTableADT) ? hashTableADT.prevKey(key) : sequenceADT.prevKey(key);

        if(prevKey != 0) {
            System.out.println("Current key: " + key + ". Previous key is: " + prevKey);
        }
    }

    /**
     * returns the number of keys that are within the specified range of
     * the two keys key1 and key2
     * @param key1 - First key
     * @param key2 - Second Keyy
     */
    public static void rangeKey(int key1, int key2) {
        int counter = 1;
        Integer[] arrayKeys = new Integer[get_size()];
        int indexFirstKey = 0;
        int indexSecondKey = 0;
        if(usingHashTableADT) {
            System.out.println("\nSearching for the number of keys within the following range: [" + key1 + ", " + key2 + "] in the hash table ADT.");

            arrayKeys = hashTableADT.allKeys();
            for (int i=0; i<arrayKeys.length-1;i++) {
                if (arrayKeys[i] == key1) {
                    indexFirstKey = i;
                }
                if (arrayKeys[i] == key2) {
                    indexSecondKey = i;
                }
            }
        } else {
            System.out.println("\nSearching for the number of keys within the following range: [" + key1 + ", " + key2 + "] in the sequence ADT.");

            arrayKeys = sequenceADT.allKeys();
            for (int i=0; i<arrayKeys.length-1;i++) {
                if (arrayKeys[i] == key1) {
                    indexFirstKey = i;
                }
                if (arrayKeys[i] == key2) {
                    indexSecondKey = i;
                }
            }
        }
        counter = indexSecondKey-indexFirstKey + 1;

        if (counter <= 0) {
            System.out.println("The range is not valid. Please try again.");
        } else {
            System.out.println("There are: " + counter + " keys within the following range: [" + key1 + ", " + key2 + "]");
        }
    }

    /**
     * Generate a non-existing key of length 8
     */
    public static void generateNonExistingKey() {
        Equipment tempName;
        boolean unique = false;
        int key = 0;

        if (usingHashTableADT){
            tempName = new Equipment("Equipment: " + hashTableADT.get_size());
            while (!unique) {
                key = generateRandomKey();
                Equipment result = hashTableADT.getValues(key);
                if (result == null) {
                    unique = true;
                }
            }
            hashTableADT.add(key, tempName);
        } else {
            tempName = new Equipment("Equipment: " + sequenceADT.get_size());
            while (!unique) {
                key = generateRandomKey();
                Equipment result = sequenceADT.getValues(key);
                if (result == null) {
                    unique = true;
                }
            }
            sequenceADT.add(key, tempName);
        }
        System.out.println("Generation of non-existing key has been been done. The new key is: " + key);
    }

    /**
     * A method to generate a random 8-digit number
     * @return - returns random 8-digit number
     */
    public static int generateRandomKey() {
        int randomNum = (int) Math.pow(10, 8 - 1);
        return randomNum + new Random().nextInt(9 * randomNum);
    }

    /**
     * method to read the file that the user selected
     * @param option - opens chosen test file and read data based on threshold
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
        } else {
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
        int threshold = 0;

        if (usingHashTableADT) {
            threshold = hashTableADT.getEINThreshold();
        } else {
            threshold = sequenceADT.getEINThreshold();
        }
        while (inStream.hasNextLine() && counter < threshold) {
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
     * method that changes the value of boolean programIsRunning
     * stops the program's menu.
     */
    private static void exitProgram(){
        System.out.println("Terminating the program. Good bye.");
        programIsRunning = false;
    }

    /**
     * method that shows the program's menu
     * @return - return option chosen by user
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

    /**
     * method that deals with the option chosen by user
     * @param option -option chosen by user
     */
    public static void executeOption(int option){
        boolean isValid = false;
        int key=0;
        int key2=0;
        if (option == 1) {
            allKeys();
        } else if (option == 2) {
            generateNonExistingKey();
        } else if (option == 3) {
            while (!isValid) {
                System.out.println("What is the key that you want to insert(8 digits):");
                key = scanner.nextInt();
                if (String.valueOf(key).length() != 8) {
                    System.out.println("Please provide a valid key. Try again.");
                } else {
                    isValid = true;
                }
            }
            System.out.println("What is the name of the key(Equipment: X)");
            String value = scanner.next();
            add(key,value);

        } else if (option == 4) {
            while (!isValid) {
                System.out.println("What is the key that you want to remove(8 digits):");
                key = scanner.nextInt();
                if (String.valueOf(key).length() != 8) {
                    System.out.println("Please provide a valid key. Try again.");
                } else {
                    isValid = true;
                }
            }
            remove(key);

        } else if (option == 5) {
            while (!isValid) {
                System.out.println("What is the key that you want the value(8 digits):");
                key = scanner.nextInt();
                if (String.valueOf(key).length() != 8) {
                    System.out.println("Please provide a valid key. Try again.");
                } else {
                    isValid = true;
                }
            }
            getValues(key);

        } else if (option == 6) {
            while (!isValid) {
                System.out.println("What is the key that you want to know the next key(8 digits):");
                key = scanner.nextInt();
                if (String.valueOf(key).length() != 8) {
                    System.out.println("Please provide a valid key. Try again.");
                } else if (usingHashTableADT && hashTableADT.getValues(key) == null) {
                    System.out.println("The provided key has not been found. Try again.");
                } else if (usingSequenceADT && sequenceADT.getValues(key) == null) {
                    System.out.println("The provided key has not been found. Try again.");
                } else {
                    isValid = true;
                }
            }
            nextKey(key);

        } else if (option == 7) {
            while (!isValid) {
                System.out.println("What is the key that you want to know the previous key(8 digits):");
                key = scanner.nextInt();
                if (String.valueOf(key).length() != 8) {
                    System.out.println("Please provide a valid key. Try again.");
                } else if (usingHashTableADT && hashTableADT.getValues(key) == null) {
                    System.out.println("The provided key has not been found. Try again.");
                } else if (usingSequenceADT && sequenceADT.getValues(key) == null) {
                    System.out.println("The provided key has not been found. Try again.");
                } else {
                    isValid = true;
                }
            }
            prevKey(key);
        } else if (option == 8) {
            while (!isValid) {
                System.out.println("What is the first key(8 digits):");
                key = scanner.nextInt();
                if (String.valueOf(key).length() != 8) {
                    System.out.println("Please provide a valid key. Try again.");
                } else if (usingHashTableADT && hashTableADT.getValues(key) == null) {
                    System.out.println("The provided key has not been found. Try again.");
                } else if (usingSequenceADT && sequenceADT.getValues(key) == null) {
                    System.out.println("The provided key has not been found. Try again.");
                } else {
                    isValid = true;
                }
            }
            isValid = false;
            while (!isValid) {
                System.out.println("What is the second key(8 digits):");
                key2 = scanner.nextInt();
                if (String.valueOf(key2).length() != 8) {
                    System.out.println("Please provide a valid key. Try again.");
                } else {
                    isValid = true;
                }
            }
            rangeKey(key,key2);
        } else if (option == 9) {
            exitProgram();
        }
    }

    /**
     * Start program loop
     * 
     */
    private static void startProgramLoop(){
        while (programIsRunning) {
            int optionChoice = showMenu();
            executeOption(optionChoice);
        }
    }

    /**
     * Main method
     * @param args - main
     */
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
