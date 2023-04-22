package Hw2_21002117.ex5;

public class SortAlgorithm {
     public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
          for (int i = 0; i < arr.length; i++) {
               boolean isSorted = true;
               for (int j = 1; j < arr.length - i; j++) {
                    if (arr[j - 1].compareTo(arr[j]) == 1) {
                         T temp = arr[j - 1];
                         arr[j - 1] = arr[j];
                         arr[j] = temp;
                         isSorted = false;
                    }
               }
               if (isSorted) {
                    break;
               }
          }
     }

     public static <T extends Comparable<T>> void selectionSort(T[] arr) {
          for (int i = arr.length - 1; i > 0; i--) {
               int maxIdx = i;
               for (int j = 0; j < i; j++) {
                    if (arr[j].compareTo(arr[maxIdx]) == 1) {
                         maxIdx = j;
                    }
               }
               T temp = arr[maxIdx];
               arr[maxIdx] = arr[i];
               arr[i] = temp;
          }
     }

     public static <T extends Comparable<T>> void insertionSort(T[] arr) {
          for (int i = 1; i < arr.length; i++) {
               T next = arr[i];
               int j;
               for (j = i - 1; j >= 0 && arr[j].compareTo(next) == 1; j--) {
                    arr[j + 1] = arr[j];
               }
               arr[j + 1] = next;
          }
     }

     public static void main(String[] args) {
          String[] alphabet = { "a", "b", "c", "z", "d" };
          bubbleSort(alphabet);
     }
}