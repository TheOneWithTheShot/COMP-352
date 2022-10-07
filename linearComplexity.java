public class linearComplexity {

    /**
     * calculate oddonacci with a linear complexity
     * @param i non-negative integer
     * @return triplets of oddonacci numbers
     */
    static int[] oddonacciLinearRecursive (int i){

        int temp;
        int[] oddonacciArray;

        if (i <= 3) {
            return new int[] { 1, 1, 1 };
        }

        oddonacciArray = oddonacciLinearRecursive(i - 1);

        temp = oddonacciArray[0];
        oddonacciArray[0] = oddonacciArray[1];
        oddonacciArray[1] = oddonacciArray[2];
        oddonacciArray[2] = temp + oddonacciArray[0] + oddonacciArray[1];

        return oddonacciArray;
    }
}
