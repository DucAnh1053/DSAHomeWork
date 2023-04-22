package Hw6_21002117_LuongDucAnh.ex1;

import java.util.Arrays;

public class SortedArrayPriorityQueue<K extends Comparable<K>, E> extends ArrayPriorityQueue<K, E> {
     ArrEntry<K, E>[] array;
     int n = 0;
     int first = 0;
     int DEFAULT_SIZE = 1000;

     @SuppressWarnings("unchecked")
     public SortedArrayPriorityQueue() {
          array = (ArrEntry<K, E>[]) new ArrEntry[DEFAULT_SIZE];
     }

     @SuppressWarnings("unchecked")
     public SortedArrayPriorityQueue(int capacity) {
          array = (ArrEntry<K, E>[]) new ArrEntry[capacity];
     }

     @SuppressWarnings("unchecked")
     private void enlarge() {
          ArrEntry<K, E>[] temp = (ArrEntry<K, E>[]) new ArrEntry[array.length * 2];
          System.arraycopy(array, first, temp, 0, array.length - first);
          System.arraycopy(array, 0, temp, array.length - first, first);
          first = 0;
          array = temp;
     }

     @Override
     public void insert(Entry<K, E> entry) {
          if (!(entry instanceof ArrEntry)) {
               throw new ClassCastException("Object was not of type ArrEntry");
          }
          if (n >= array.length) {
               enlarge();
          }
          int idx;
          for (idx = n - 1; (idx >= 0 && array[(idx + first) % array.length].getKey().compareTo(entry.getKey()) > 0); idx--) {
               array[(idx + first + 1) % array.length] = array[(idx + first) % array.length];
          }
          array[(idx + first + 1) % array.length] = (ArrEntry<K, E>) entry;
          n++;
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
          return array[first];
     }

     @Override
     public Entry<K, E> removeMin() {
          if (isEmpty()) {
               throw new IllegalStateException("Queue is empty!");
          }
          Entry<K, E> result = array[first];
          array[first] = null;
          first = (first + 1) % array.length;
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
               sb.append(array[(first + i) % array.length]).append(", ");
          }
          sb.delete(sb.length() - 2, sb.length());
          sb.append("] size = ").append(n);
          return sb.toString();
     }
}