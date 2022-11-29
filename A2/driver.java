package A2;

public class driver {
    static boolean isValidConfiguration(int[] a, int n, boolean[] flag, int currentIndex) {

        if(a[currentIndex] == 0) //base case
            return true;
        flag[currentIndex] = true;
        int val = a[currentIndex];
        if(currentIndex-val<0) //no space in left
        {
            if(currentIndex+val>n-1) //no space in right
                return false;
            if(flag[currentIndex+val] == true) //we have already traversed its right path
                return false;
            return isValidConfiguration(a, n, flag, currentIndex+val); //go to right
        }
        else if(flag[currentIndex-val] == true) //left is already visited
        {
            if(currentIndex+val>n-1) //no space in right
                return false;
            if(flag[currentIndex+val] == true) //we have already traversed its right path
                return false;
            return isValidConfiguration(a, n, flag, currentIndex-val); //go to right
        }
        else //go to left
        {
            if(isValidConfiguration(a, n, flag, currentIndex-val))
                return true;
            else if(isValidConfiguration(a, n, flag, currentIndex+val))
            {
                return true;
            }
            else
                return false;
        }
    }

    public static void main(String[] args) {
//You can initialize array and set n accordingly as per your requirement
// int a[] = {4, 8, 5, 2, 3, 5, 1, 6, 4, 0};
// int n = 10;
//        int a[] = {4, 8, 5, 2, 3, 5, 1, 6, 4, 0};
        int a[] = {5, 8, 2, 3, 1, 5, 0};
        int n = 7;
        int currentIndex = 0; //intitalize with index pointed by marker

//create boolean array to keep track about which index has already been reached
        boolean[] flag = new boolean[n];
        for(int i=1;i<n;i++)
            flag[i] = false;
        if(isValidConfiguration(a, n, flag, currentIndex))
        {
            System.out.print("This is a valid configuration for game");
        }
        else
        {
            System.out.print("This is not a valid configuration for game");
        }
    }

}
