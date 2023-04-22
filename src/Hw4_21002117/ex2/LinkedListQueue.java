package Hw4_21002117.ex2;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
     class Node {
          E element;
          Node next;
     }

     private Node first;
     private Node last;
     private int size;

     @Override
     public E dequeue() {
          if (isEmpty()) {
               return null;
          }
          E result = first.element;
          first = first.next;
          size--;
          return result;
     }

     @Override
     public void enqueue(E e) {
          Node current = new Node();
          current.element = e;
          if (isEmpty()) {
               first = last = current;
          }
          last.next = current;
          last = current;
          size++;
     }

     @Override
     public E first() {
          return first.element;
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
          // Node current = first;
          // while (current != null) {
          // builder.append(current.element).append(", ");
          // current = current.next;
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
               private Node current = first;

               @Override
               public boolean hasNext() {
                    return current != null;
               }

               @Override
               public E next() {
                    E result = current.element;
                    current = current.next;
                    return result;
               }

          };
     }

}
