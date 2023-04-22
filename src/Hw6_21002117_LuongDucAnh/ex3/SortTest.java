package Hw6_21002117_LuongDucAnh.ex3;

import java.util.Random;

public class SortTest {
     public static final String ANSI_RESET = "\u001B[0m";
     public static final String ANSI_BLACK = "\u001B[30m";
     public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

     public static long measureExecutionTime(Runnable function) {
          long startTime = System.nanoTime();
          function.run();
          long endTime = System.nanoTime();
          return endTime - startTime;
     }

     public static Integer[] randomArray(int length) {
          Random generator = new Random(1);
          Integer[] arr = new Integer[length];
          for (int i = 0; i < length; i++) {
               arr[i] = generator.nextInt(-1000, 1000);
          }
          return arr;
     }

     public static void testSortAlgorithm(int length) {
          Integer[] oriArr = randomArray(length);
          Integer[] copyArr1 = oriArr.clone();
          Integer[] copyArr2 = oriArr.clone();
          Integer[] copyArr3 = oriArr.clone();
          Integer[] copyArr4 = oriArr.clone();
          System.out.printf("The heap sort algorithm's total time for a %d-element array is %d nanosecond%n",
                  length, measureExecutionTime(() -> SortAlgorithm.heapSort(copyArr1)));
          System.out.printf("The selection sort algorithm's total time for a %d-element array is %d nanosecond%n",
                  length, measureExecutionTime(() -> SortAlgorithm.selectionSort(copyArr2)));
          System.out.printf("The merge sort algorithm's total time for a %d-element array is %d nanosecond%n",
                  length, measureExecutionTime(() -> SortAlgorithm.mergeSort(copyArr3)));
          System.out.printf("The quick sort algorithm's total time for a %d-element array is %d nanosecond%n",
                  length, measureExecutionTime(() -> SortAlgorithm.quickSort(copyArr4)));
     }

     public static void main(String[] args) {
          int[] length = {100000};
          for (int l : length) {
               System.out.printf("%s%sTest sorting algorithm with %d-element array...%s%n",
                       ANSI_GREEN_BACKGROUND, ANSI_BLACK, l, ANSI_RESET);
               testSortAlgorithm(l);
          }
     }
}
