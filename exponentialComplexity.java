public class exponentialComplexity {

    /**
     * oddonacciRecursive method to calculate oddonacci's
     * number with an exponential complexity
     *
     * @param i the non-negative integer
     * @return the result
     */
    static int oddonacciExponentialRecursive(int i)
    {
        if (i == 0 || i == 1){
            return i;
        }
        else if (i == 2 || i == 3) {
            return 1;
        }
        else {
            return oddonacciExponentialRecursive(i-1) + oddonacciExponentialRecursive(i-2) + oddonacciExponentialRecursive(i-3);
        }
    }
}
