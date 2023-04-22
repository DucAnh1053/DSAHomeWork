package Hw2_21002117.ex2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
     //Hàm nhập mảng theo cỡ size
     public static int[] inputArray(int size, Scanner sc) {
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
               array[i] = sc.nextInt();
          }
          return array;
     }

     //Hàm tạo mảng ngẫu nhiên cỡ size
     public static int[] randomArray(int size) {
          Random random = new Random(42);
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
               array[i] = random.nextInt(-1000, 1000);
          }
          return array;
     }

     //Hàm in mảng
     public static void printArray(int[] arr) {
          System.out.println(Arrays.toString(arr));
     }

     //Sắp xếp theo thuật toán Selection Sort
     public static void sort(int[] arr) {
          int compareCount = 0;
          int swapCount = 0;
          for (int i = arr.length - 1; i > 0; i--) {
               int maxIdx = i;
               for (int j = 0; j < i; j++) {
                    compareCount++;
                    if (arr[j] > arr[maxIdx]) {
                         maxIdx = j;
                    }
               }
               if (i != maxIdx) {
                    int temp = arr[maxIdx];
                    arr[maxIdx] = arr[i];
                    arr[i] = temp;
                    swapCount++;
               }
               printArray(arr);
          }
          System.out.println("Number of comparisons " + compareCount);
          System.out.println("Number of swaps: " + swapCount);
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.print("Enter size of array: ");
          int size = sc.nextInt();
          // int[] array = inputArray(size, sc);
          sc.close();
          int[] array = randomArray(size);
          // long start = System.nanoTime();
          sort(array);
          // long end = System.nanoTime();
          // System.out.println(end - start);
     }
}
