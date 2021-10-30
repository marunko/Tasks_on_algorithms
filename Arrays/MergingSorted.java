package Arrays;


import java.util.Arrays;

public class MergingSorted {
    public static void main(String[] args) {
        int[] array1 = {1,3,5,6,11};
        int[] array2 = {2,4,5,7,9,10,12,13};


        int[] arr3 = mergeSorted(array1, array2);
        Arrays.stream(arr3).forEach(System.out::println);
    }
    static int[] mergeSorted(int[] arr1, int[] arr2){

        int[] array = new int[arr1.length + arr2.length];

        int j=0, i=0, k=0;
        while (i<arr1.length && j < arr2.length){

            if(arr1[i] < arr2[j]){
                array[k++] = arr1[i++];
            }
            else if(arr1[i] > arr2[j]){

                array[k++] = arr2[j++];

            }
            else{
                array[k++] = arr1[i++];
                array[k++] = arr1[j++];
            }

        }
        while (i<arr1.length){
            array[k++] = arr1[i++];
        }
        while (j<arr2.length){
            array[k++] = arr2[j++];
        }

        return array;
    }

}
