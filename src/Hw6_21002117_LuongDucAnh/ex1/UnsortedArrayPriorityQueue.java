package Hw6_21002117_LuongDucAnh.ex1;

import java.util.Arrays;

public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> extends ArrayPriorityQueue<K, E> {
     ArrEntry<K, E>[] array;
     int n = 0;
     int DEFAULT_SIZE = 1000;

     @SuppressWarnings("unchecked")
     public UnsortedArrayPriorityQueue() {
          array = (ArrEntry<K, E>[]) new ArrEntry[DEFAULT_SIZE];
     }

     @SuppressWarnings("unchecked")
     public UnsortedArrayPriorityQueue(int capacity) {
          array = (ArrEntry<K, E>[]) new ArrEntry[capacity];
     }

     @Override
     public void insert(Entry<K, E> entry) {
          if (!(entry instanceof ArrEntry)) {
               throw new ClassCastException("Object was not of type ArrEntry");
          }
          if (n >= array.length) {
               array = Arrays.copyOf(array, array.length * 2);
          }
          array[n++] = (ArrEntry<K, E>) entry;
     }

     @Override
     public void insert(K k, E e) {
          insert(new ArrEntry<>(k, e));
     }

     @Override
     public boolean isEmpty() {
          return n == 0;
     }

     @Override
     public Entry<K, E> min() {
          if (isEmpty()) {
               throw new IllegalStateException("Queue is empty!");
          }
          Entry<K, E> result = array[0];
          for (int i = 1; i < n; i++) {
               if (array[i].getKey().compareTo(result.getKey()) < 0) {
                    result = array[i];
               }
          }
          return result;
     }

     @Override
     public Entry<K, E> removeMin() {
          if (isEmpty()) {
               throw new IllegalStateException("Queue is empty!");
          }
          int minIdx = 0;
          for (int i = 1; i < n; i++) {
               if (array[i].getKey().compareTo(array[minIdx].getKey()) < 0) {
                    minIdx = i;
               }
          }
          Entry<K, E> result = array[minIdx];
          for (int i = minIdx + 1; i < n; i++) {
               array[i - 1] = array[i];
          }
          n--;
          return result;
     }

     @Override
     public int size() {
          return n;
     }

     @Override
     public String toString() {
          if (isEmpty()) {
               return "[]";
          }
          StringBuilder sb = new StringBuilder("[");
          for (int i = 0; i < n; i++) {
               sb.append(array[i]).append(", ");
          }
          sb.delete(sb.length() - 2, sb.length());
          sb.append("] size = ").append(n);
          return sb.toString();
     }
}