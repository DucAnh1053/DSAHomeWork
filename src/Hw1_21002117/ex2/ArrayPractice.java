package Hw1_21002117.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayPractice {
     public static int[] inputArray(Scanner sc) {
          System.out.print("Enter size of array: ");
          int size = sc.nextInt();
          int[] array = new int[size];
          for (int i = 0; i < size; i++) {
               array[i] = sc.nextInt();
          }
          return array;
     }

     public static void printArray(int[] array) {
          System.out.println(Arrays.toString(array));
     }

     public static int indexOf(int[] array, int element) {
          for (int i = 0; i < array.length; i++) {
               if (array[i] == element) {
                    return i;
               }
          }
          return -1;
     }

     public static void sortArray(int[] array, boolean isAsc) {
          int order = isAsc ? 1 : -1;
          for (int i = 0; i < array.length - 1; i++) {
               for (int j = 0; j < array.length - i - 1; j++) {
                    if (order * array[j] > order * array[j + 1]) {
                         int temp = array[j];
                         array[j] = array[j + 1];
                         array[j + 1] = temp;
                    }
               }
          }
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          // Nhập mảng
          int[] myArray = inputArray(sc);
          System.out.print("Entered array is: ");

          // In mảng
          printArray(myArray);

          // Tìm kiếm trong mảng
          System.out.print("Enter a number: ");
          int n = sc.nextInt();
          int idx = indexOf(myArray, n);
          if (idx >= 0) {
               System.out.println("Index position of " + n + " is: " + idx);
          } else {
               System.out.println(n + " does not exist in the array");
          }

          // Sắp xếp mảng tăng dần
          System.out.println("Sort array ascending");
          sortArray(myArray, true);
          printArray(myArray);

          // Sắp xếp mảng giảm dần
          System.out.println("Sort array descending");
          sortArray(myArray, false);
          printArray(myArray);

          // Sử dụng Generic đối với phần tử mảng
          List<Integer> list = new ArrayList<>(List.of(1, 5, 7));
          int m = list.get(1);
          System.out.println(m + list.get(0));
     }
}
