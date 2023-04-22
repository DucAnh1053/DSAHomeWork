package Hw6_21002117_LuongDucAnh.ex1;

public class SortedLinkedPriorityQueue<K extends Comparable<K>, E> extends LinkedPriorityQueue<K, E> {
     private NodeEntry<K, E> head;
     private NodeEntry<K, E> tail;
     int n = 0;

     @Override
     public void insert(Entry<K, E> entry) {
          if (!(entry instanceof NodeEntry<K, E> castNode)) {
               throw new ClassCastException("Object was not of type NodeEntry");
          }
          if (isEmpty()) {
               head = tail = castNode;
          } else {
               NodeEntry<K, E> previous = null;
               NodeEntry<K, E> current = head;
               while (current != null && current.getKey().compareTo(castNode.getKey()) < 0) {
                    previous = current;
                    current = current.getNext();
               }
               if (previous == null) {
                    castNode.setNext(head);
                    head = castNode;
               } else if (current == null) {
                    tail.setNext(castNode);
                    tail = castNode;
               } else {
                    castNode.setNext(current);
                    previous.setNext(castNode);
               }
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
          return head;
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
          head = head.getNext();
          n--;
          return current;
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
