package selectionsorttest;

import java.util.Arrays;
import java.util.Random;

public class SelectionSortTest {

    //حجمها
    static final int N = 100000;

    
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // Case 1: Random array
    public static int[] randomArray() {
        int[] arr = new int[N];
        Random random = new Random();

        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(1000000);
        }

        return arr;
    }

    // Case 2: Reverse sorted array
    public static int[] reverseArray() {
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = N - i;
        }

        return arr;
    }

    
    public static void testSort(String caseName, int[] original) {

       
        int[] arr = Arrays.copyOf(original, original.length);

        long startTime = System.nanoTime();

        selectionSort(arr);

        long endTime = System.nanoTime();

        
        double executionTime = (endTime - startTime) / 1000.0;

     
        boolean isSorted = true;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                isSorted = false;
                break;
            }
        }

       
        System.out.println("-------");
        System.out.println("Test case: " + caseName);
        System.out.println("Array size: " + N);
        System.out.printf("Execution time: %.2f microseconds%n",
                          executionTime);
        System.out.println("Correctly sorted: " + isSorted);
    }

    public static void main(String[] args) {

        System.out.println("Selection Sort Performance Test");
        System.out.println("Array size N = " + N);

       
        int[] random = randomArray();
        int[] reverse = reverseArray();

       //المصفوفة عشوائية
        testSort("Random Array", random);

        //المصفوفة مرتبة عكسيا
        testSort("Reverse Sorted Array", reverse);

       
    }
}
