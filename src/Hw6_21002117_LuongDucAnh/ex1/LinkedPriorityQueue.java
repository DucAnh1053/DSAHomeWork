package Hw6_21002117_LuongDucAnh.ex1;

public abstract class LinkedPriorityQueue<K, E> implements PriorityQueueInterface<K, E> {
     public static class NodeEntry<K, E> implements Entry<K, E> {
          K key;
          E element;
          NodeEntry<K, E> next;

          public NodeEntry(K k, E e) {
               key = k;
               element = e;
          }

          @Override
          public K getKey() {
               return key;
          }

          @Override
          public E getValue() {
               return element;
          }

          public NodeEntry<K, E> getNext() {
               return next;
          }

          public void setNext(NodeEntry<K, E> next) {
               this.next = next;
          }

          @Override
          public String toString() {
               return element.toString();
          }
     }
}
