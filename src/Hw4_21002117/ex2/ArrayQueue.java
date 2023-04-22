package Hw4_21002117.ex2;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {

     private final int CAPACITY = 100;
     private E[] data;
     private int first;
     private int size;

     public ArrayQueue() {
          data = (E[]) new Object[CAPACITY];
     }

     public ArrayQueue(int capacity) {
          data = (E[]) new Object[capacity];
     }

     @Override
     public E dequeue() {
          if (isEmpty()) {
               return null;
          }
          E result = data[first];
          data[first] = null;
          first = (first + 1) % data.length;
          size--;
          return result;
     }

     private void enlarge() {
          E[] temp = (E[]) new Object[data.length * 2];
          System.arraycopy(data, first, temp, 0, data.length - first);
          System.arraycopy(data, 0, temp, data.length - first, first);
          first = 0;
          data = temp;
     }

     @Override
     public void enqueue(E e) {
          if (size >= data.length) {
               enlarge();
          }
          int avail = (first + size) % data.length;
          data[avail] = e;
          size++;
     }

     @Override
     public E first() {
          if (isEmpty()) {
               return null;
          }
          return data[first];
     }

     @Override
     public boolean isEmpty() {
          return size == 0;
     }

     @Override
     public int size() {
          return size;
     }

     @Override
     public String toString() {
          if (isEmpty()) {
               return "[]";
          }
          StringBuilder builder = new StringBuilder("[");
          // for (int i = first; i < first + size; i++) {
          // builder.append(data[i]).append(", ");
          // }
          for (E e : this) {
               builder.append(e).append(", ");
          }
          builder.delete(builder.length() - 2, builder.length());
          builder.append("]");
          return builder.toString();
     }

     @Override
     public Iterator<E> iterator() {
          return new Iterator<E>() {
               private int currentIdx = first;
               private int n = 0;

               @Override
               public boolean hasNext() {
                    return n < size;
               }

               @Override
               public E next() {
                    E result = data[(currentIdx + n) % data.length];
                    n++;
                    return result;
               }
          };
     }
}
