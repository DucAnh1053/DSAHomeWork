package Hw4_21002117.ex1;

import java.util.Iterator;

public class LinkedListStack<E> implements StackInterface<E> {
     class Node {
          E element;
          Node next;
     }

     Node stack = null;

     @Override
     public void push(E element) {
          Node node = new Node();
          node.element = element;
          if (stack == null) {
               stack = node;
          } else {
               Node current = stack;
               while (current.next != null) {
                    current = current.next;
               }
               current.next = node;
          }
     }

     @Override
     public E pop() {
          if (stack == null) {
               return null;
          }
          if (stack.next == null) {
               E data = stack.element;
               stack = null;
               return data;
          }
          Node current = stack;
          while (current.next.next != null) {
               current = current.next;
          }
          E data = current.next.element;
          current.next = null;
          return data;
     }

     @Override
     public boolean isEmpty() {
          return stack == null;
     }

     @Override
     public E top() {
          Node current = stack;
          while (current.next != null) {
               current = current.next;
          }
          return current.element;
     }

     @Override
     public Iterator<E> iterator() {
          return new StackIterator();
     }

     class StackIterator implements Iterator<E> {
          private Node currentNode = stack;

          @Override
          public boolean hasNext() {
               return currentNode != null;
          }

          @Override
          public E next() {
               E data = currentNode.element;
               currentNode = currentNode.next;
               return data;
          }
     }

     @Override
     public String toString() {
          if (stack == null) {
               return "[]";
          }
          StringBuilder builder = new StringBuilder("[");
          for (E element : this) {
               builder.append(element).append(", ");
          }
          builder.delete(builder.length() - 2, builder.length());
          builder.append("]");
          return builder.toString();
     }

}
