package Hw6_21002117_LuongDucAnh.ex3;

import Hw6_21002117_LuongDucAnh.ex2.MinHeapPriorityQueue;

import java.util.Arrays;

public class SortAlgorithm {
     public static <T extends Comparable<T>> void heapSort(T[] arr) {
          MinHeapPriorityQueue<T, T> heap = new MinHeapPriorityQueue<T, T>(arr.length);
          for (T e : arr) {
               heap.insert(e, e);
          }

          for (int i = 0; i < arr.length; i++) {
               arr[i] = heap.removeMin().getValue();
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

     public static <T extends Comparable<T>> void mergeSort(T[] arr) {
          mergeSort(arr, 0, arr.length - 1);
     }

     private static <T extends Comparable<T>> void mergeSort(T[] arr, int l, int r) {
          if (l < r) {
               int m = l + (r - l) / 2;
               mergeSort(arr, l, m);
               mergeSort(arr, m + 1, r);
               merge(arr, l, m, r);
          }
     }

     @SuppressWarnings("unchecked")
     private static <T extends Comparable<T>> void merge(T[] arr, int l, int m, int r) {
          int n1 = m - l + 1;
          int n2 = r - m;
          T[] L = (T[]) new Comparable[n1];
          T[] R = (T[]) new Comparable[n2];
//          for (int i = 0; i < n1; ++i) {
//               L[i] = arr[l + i];
//          }
//          for (int j = 0; j < n2; ++j) {
//               R[j] = arr[m + 1 + j];
//          }
          System.arraycopy(arr, l, L, 0, n1);
          System.arraycopy(arr, m + 1, R, 0, n2);
          int i = 0, j = 0;
          int k = l;
          while (i < n1 && j < n2) {
               if (L[i].compareTo(R[j]) <= 0) {
                    arr[k] = L[i];
                    i++;
               } else {
                    arr[k] = R[j];
                    j++;
               }
               k++;
          }
          while (i < n1) {
               arr[k] = L[i];
               i++;
               k++;
          }
          while (j < n2) {
               arr[k] = R[j];
               j++;
               k++;
          }
     }

     public static <T extends Comparable<T>> void quickSort(T[] arr) {
          quickSort(arr, 0, arr.length - 1);
     }

     private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
          if (low < high) {
               int idx = partition(arr, low, high);
               quickSort(arr, low, idx - 1);
               quickSort(arr, idx + 1, high);
          }
     }

     private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
          T pivot = arr[high];
          int i = (low - 1);

          for (int j = low; j <= high - 1; j++) {
               if (arr[j].compareTo(pivot) < 0) {
                    i++;
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
               }
          }
          T temp = arr[i + 1];
          arr[i + 1] = arr[high];
          arr[high] = temp;
          return i + 1;
     }
}
