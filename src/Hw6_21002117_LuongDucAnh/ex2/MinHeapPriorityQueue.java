package Hw6_21002117_LuongDucAnh.ex2;

import Hw6_21002117_LuongDucAnh.ex1.ArrayPriorityQueue;
import Hw6_21002117_LuongDucAnh.ex1.Entry;

import java.util.Arrays;

public class MinHeapPriorityQueue<K extends Comparable<K>, E> extends ArrayPriorityQueue<K, E> {

     ArrEntry<K, E>[] heapPQ;
     int n = 0;
     int DEFAULT_SIZE = 100;

     @SuppressWarnings("unchecked")
     public MinHeapPriorityQueue() {
          heapPQ = (ArrEntry<K, E>[]) new ArrEntry[DEFAULT_SIZE];
     }

     @SuppressWarnings("unchecked")
     public MinHeapPriorityQueue(int capacity) {
          heapPQ = (ArrEntry<K, E>[]) new ArrEntry[capacity];
     }

     private void swap(int i, int j) {
          ArrEntry<K, E> temp = heapPQ[i];
          heapPQ[i] = heapPQ[j];
          heapPQ[j] = temp;
     }

     // Các phương thức bổ sung
     private void upHeap() {
          int idx = n;
          while (idx > 1 && heapPQ[idx / 2].getKey().compareTo(heapPQ[idx].getKey()) > 0) {
               swap(idx / 2, idx);
               idx /= 2;
          }
     }

     private void downHeap() {
          int idx = 1;
          int swapPos;
          while (idx <= n / 2) {
               if (2 * idx + 1 <= n) {
                    if (heapPQ[2 * idx].getKey().compareTo(heapPQ[2 * idx + 1].getKey()) < 0) {
                         swapPos = 2 * idx;
                    } else {
                         swapPos = 2 * idx + 1;
                    }
               } else {
                    swapPos = 2 * idx;
               }
               if (heapPQ[idx].getKey().compareTo(heapPQ[swapPos].getKey()) > 0) {
                    swap(idx, swapPos);
                    idx = swapPos;
               } else {
                    break;
               }
          }
     }

     @Override
     public int size() {
          return n;
     }

     @Override
     public boolean isEmpty() {
          return n == 0;
     }

     @Override
     public void insert(Entry<K, E> entry) {
          if (!(entry instanceof ArrEntry)) {
               throw new ClassCastException("Object was not of type ArrEntry");
          }
          if (n + 1 >= heapPQ.length) {
               heapPQ = Arrays.copyOf(heapPQ, heapPQ.length * 2);
          }
          heapPQ[++n] = (ArrEntry<K, E>) entry;
          upHeap();
     }

     @Override
     public void insert(K k, E e) {
          insert(new ArrEntry<>(k, e));
     }

     @Override
     public Entry<K, E> removeMin() {
          Entry<K, E> result = heapPQ[1];
          heapPQ[1] = heapPQ[n--];
          downHeap();
          return result;
     }

     @Override
     public Entry<K, E> min() {
          return heapPQ[1];
     }

     @Override
     public String toString() {
          if (isEmpty()) {
               return "";
          }
          StringBuilder sb = new StringBuilder("[");
          for (int i = 1; i <= n; i++) {
               sb.append(heapPQ[i]).append(", ");
          }
          sb.delete(sb.length() - 2, sb.length());
          sb.append("] size = ").append(n);
          return sb.toString();
     }
}