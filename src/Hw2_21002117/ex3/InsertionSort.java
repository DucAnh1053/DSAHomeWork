package Hw2_21002117.ex3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
     public static int[] inputArray(int size, Scanner sc) {
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
               array[i] = sc.nextInt();
          }
          return array;
     }

     public static int[] randomArray(int size) {
          Random random = new Random();
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
               array[i] = random.nextInt(-1000, 1000);
          }
          return array;
     }

     public static void printArray(int[] arr) {
          System.out.println(Arrays.toString(arr));
     }

     public static void sort(int[] arr) {
          int compareCount = 0;
          int swapCount = 0;
          for (int i = 1; i < arr.length; i++) {
               int next = arr[i];
               int j;
               for (j = i - 1; j >= 0; j--) {
                    compareCount++;
                    if (arr[j] > next) {
                         arr[j + 1] = arr[j];
                         swapCount++;
                    } else {
                         break;
                    }
               }
               arr[j + 1] = next;
               printArray(arr);
          }
          System.out.println("Number of comparisons " + compareCount);
          System.out.println("Number of swaps: " + swapCount);
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.print("Enter size of array: ");
          int size = sc.nextInt();
          int[] array = inputArray(size, sc);
          sc.close();
          // int[] array = randomArray(size);
          // long start = System.nanoTime();
          sort(array);
          // long end = System.nanoTime();
          // System.out.println(end - start);
     }
}
