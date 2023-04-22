package Hw4_21002117.ex1;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
     private final int CAPACITY = 16;
     private E[] data;
     private int size;

     public ArrayStack() {
          data = (E[]) new Object[CAPACITY];
          size = 0;
     }

     @Override
     public boolean isEmpty() {
          return size == 0;
     }

     @Override
     public E pop() {
          if (isEmpty()) {
               return null;
          }
          E temp = data[size - 1];
          data[size - 1] = null;
          size--;
          return temp;
     }

     @Override
     public void push(E element) {
          if (size >= data.length) {
               data = Arrays.copyOf(data, data.length * 2);
          }
          data[size++] = element;
     }

     @Override
     public E top() {
          return data[size - 1];
     }

     @Override
     public Iterator<E> iterator() {
          return new Iterator<E>() {
               private int currentIdx = 0;

               @Override
               public boolean hasNext() {
                    return currentIdx < size;
               }

               @Override
               public E next() {
                    return data[currentIdx++];
               }

          };
     }

     @Override
     public String toString() {
          if (isEmpty()) {
               return "[]";
          }
          StringBuilder builder = new StringBuilder("[");
          for (E data : this) {
               builder.append(data).append(", ");
          }
          builder.delete(builder.length() - 2, builder.length());
          builder.append("]");
          return builder.toString();
     }

}
