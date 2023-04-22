package Hw1_21002117.ex6;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
     private T[] array;
     private int n = 0;
     private int defaultSize = 100;

     public SimpleArrayList() {
          array = (T[]) new Object[defaultSize];
     }

     public SimpleArrayList(int capacity) {
          // Hàm dựng với kích thước mảng là capacity
          array = (T[]) new Object[capacity];
     }

     public void add(T data) {
          if (n >= array.length) {
               array = Arrays.copyOf(array, array.length * 2);
          }
          array[n] = data;
          n++;
     }

     public T get(int i) {
          if (i < 0 || i >= n) {
               throw new IndexOutOfBoundsException();
          }
          return array[i];
     }

     public void set(int i, T data) {
          if (i < 0 || i >= n) {
               throw new IndexOutOfBoundsException();
          }
          array[i] = data;
     }

     public void remove(T data) {
          int dataIdx = -1;
          for (int i = 0; i < n; i++) {
               if (array[i] == data) {
                    dataIdx = i;
                    break;
               }
          }
          for (int i = dataIdx; i < n - 1; i++) {
               array[i] = array[i + 1];
          }
          n--;
     }

     public void isContain(T data) {
          for (int i = 0; i < n; i++) {
               if (array[i].equals(data)) {
                    System.out.println(data + " exists");
                    return;
               }
          }
          System.out.println(data + " does not exist");
     }

     public int size() {
          return n;
     }

     public boolean isEmpty() {
          return n == 0;
     }

     public Iterator<T> iterator() {
          return new Iterator<T>() {
               private int currentIdx = 0;

               @Override
               public boolean hasNext() {
                    return currentIdx < n;
               }

               @Override
               public T next() {
                    return array[currentIdx++];
               }
          };
     }
}