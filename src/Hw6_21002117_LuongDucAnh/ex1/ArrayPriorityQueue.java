package Hw6_21002117_LuongDucAnh.ex1;

public abstract class ArrayPriorityQueue<K, E> implements PriorityQueueInterface<K, E> {
     public static class ArrEntry<K, E> implements Entry<K, E> {
          K key;
          E element;

          public ArrEntry(K k, E e) {
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

          @Override
          public String toString() {
               return element.toString();
          }
     }
}
