/**
 * tailRecursiveComplexity class that has the algorithm of the tail recursive method
 * Student name: Xavier Guertin
 * Student id: 40213525
 */

public class tailRecursive {

    private static int[] tailRecursiveArray = {1,1,1}; //array used for the tail recursive method

    /**
     * oddonacciTailRecursive method to calculate oddonacci's
     * number with a linear complexity
     * @param i
     * @return
     */
    static int[] oddonacciTailRecursive (int i) {

        if (i == 0) {
            return new int[] {0,0,0}; //returns this array so the result is 0
        }
        else if (i <= 3) {
            return tailRecursiveArray; //returns the array {1,1,1} so the result is 1
        }

        int temp = tailRecursiveArray[0]; //declare temp int that is used to move values
        tailRecursiveArray[0] = tailRecursiveArray[1]; //swap values
        tailRecursiveArray[1] = tailRecursiveArray[2]; //swap values
        tailRecursiveArray[2] = temp + tailRecursiveArray[0] + tailRecursiveArray[1]; //add values

        return oddonacciTailRecursive(i - 1); //tail recursive method
    }
}
