package Hw6_21002117_LuongDucAnh.ex1;

public class UnsortedLinkedPriorityQueue<K extends Comparable<K>, E> extends LinkedPriorityQueue<K, E> {
     private NodeEntry<K, E> head;
     private NodeEntry<K, E> tail;
     int n = 0;

     @Override
     public void insert(Entry<K, E> entry) {
          if (!(entry instanceof NodeEntry<K, E> current)) {
               throw new ClassCastException("Object was not of type NodeEntry");
          }
          if (isEmpty()) {
               head = tail = current;
          } else {
               tail.setNext(current);
               tail = current;
          }
          n++;
     }

     @Override
     public void insert(K k, E e) {
          insert(new NodeEntry<>(k, e));
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
          NodeEntry<K, E> min = head;
          NodeEntry<K, E> current = head.getNext();
          while (current != null) {
               if (current.getKey().compareTo(min.getKey()) < 0) {
                    min = current;
               }
               current = current.getNext();
          }
          return min;
     }

     @Override
     public Entry<K, E> removeMin() {
          if (isEmpty()) {
               throw new IllegalStateException("Queue is empty!");
          }
          NodeEntry<K, E> current = head;
          if (n == 1) {
               head = tail = null;
               n--;
               return current;
          }
          NodeEntry<K, E> min = (NodeEntry<K, E>) min();
          while (current != null) {
               if (current.getNext() == min) {
                    current.setNext(current.getNext().getNext());
                    break;
               }
               current = current.getNext();
          }
          n--;
          return min;
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
          NodeEntry<K, E> current = head;
          while (current != null) {
               sb.append(current).append(", ");
               current = current.getNext();
          }
          sb.delete(sb.length() - 2, sb.length());
          sb.append("] size = ").append(n);
          return sb.toString();
     }
}
