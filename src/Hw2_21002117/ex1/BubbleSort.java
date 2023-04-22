package Hw2_21002117.ex1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
     //Hàm để nhập vào mảng có cỡ size
     public static int[] inputArray(int size, Scanner sc) {
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
               array[i] = sc.nextInt();
          }
          return array;
     }

     //Hàm tạo mảng ngẫu nhiên có cỡ size
     public static int[] randomArray(int size) {
          Random random = new Random(42);
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
               array[i] = random.nextInt(-1000, 1000);
          }
          return array;
     }

     //Hàm in ra mảng
     public static void printArray(int[] arr) {
          System.out.println(Arrays.toString(arr));
     }

     //Hàm sắp xếp theo thuật toán Bubble Sort
     public static void sort(int[] arr) {
          int compareCount = 0;
          int swapCount = 0;
          for (int i = 0; i < arr.length; i++) {
               boolean isSorted = true;
               for (int j = 1; j < arr.length - i; j++) {
                    compareCount++;
                    if (arr[j - 1] > arr[j]) {
                         int temp = arr[j - 1];
                         arr[j - 1] = arr[j];
                         arr[j] = temp;
                         isSorted = false;
                         swapCount++;
                    }
                    // printArray(arr);
               }
               if (isSorted) {
                    break;
               }
          }
          System.out.println("Number of comparisons " + compareCount);
          System.out.println("Number of swaps: " + swapCount);
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.print("Enter size of array: ");
          int size = 10;
          // int[] array = inputArray(size, sc);
          sc.close();
          int[] array = randomArray(size);
          // long start = System.nanoTime();
          sort(array);
          // long end = System.nanoTime();
          // System.out.println(end - start);
     }
}