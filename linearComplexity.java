/**
 * linearComplexity class that has the algorithm of the linear recursive method
 * Student name: Xavier Guertin
 * Student id: 40213525
 */

public class linearComplexity {

    /**
     * calculates oddonacci with a linear complexity
     * @param i non-negative integer
     * @return triplets of oddonacci numbers
     */
    static int[] oddonacciLinearRecursive (int i){

        int temp; //declare temp int
        int[] oddonacciArray; //declare the array used

        if (i == 0) { //if statement if i==0 then result = 0
            return new int[] { 0, 0, 0 };
        }
        else if (i <= 3) { //if statement if i<=3 then result = 1
            return new int[] { 1, 1, 1 };
        }

        //calls function once (recursive)
        oddonacciArray = oddonacciLinearRecursive(i - 1);

        temp = oddonacciArray[0]; //assigns value to temp
        oddonacciArray[0] = oddonacciArray[1];
        oddonacciArray[1] = oddonacciArray[2];
        oddonacciArray[2] = temp + oddonacciArray[0] + oddonacciArray[1];

        return oddonacciArray; //return result
    }
}
