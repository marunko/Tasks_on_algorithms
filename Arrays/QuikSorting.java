package Arrays;

import java.util.Arrays;

public class QuikSorting {
    public static void main(String[] args) {
        int[] array = {5,2,3,1,4,6,7,9};
        // I. 42315679 (one c)
        // I-L. 1234 (2 cycle: 4-1 | 2-2)      I.R
        array = proxySort(array);
        Arrays.stream(array).forEach(System.out::println);


    }
    static int[] sortQuik(int[] array, int low, int high){

        // Checks for zero
        if(array.length ==0) return array;

        //!! End recursive calls
        if(low >=high) return array;

        //Count middle element
        int middle = (low+high)/2;

        //Cycling
        int i = low, j = high;
        while (i<=j){

            // By parts checks and pointers reassign
            while (array[i] < array[middle]){
                i++; //low ----->>>> to middle ||
            }
            while (array[j] > array[middle]){
                j--; // middle  <<<<------ high
            }
            if(i<=j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++; // if both are same add and minus to stop cycle
                j--; // if both are same add and minus to stop cycle
            }
        }
        //Left part recursion
        if(low < j){
            sortQuik(array, low, j);
        }
        //Right part recursion
        if(i < high){
            sortQuik(array, i, high);
        }

        return array;
    }
    static  int[]  proxySort(int[] array){
        return sortQuik(array, 0, array.length-1);
    }
}
