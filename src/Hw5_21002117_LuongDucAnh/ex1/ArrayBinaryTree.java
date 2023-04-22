package Hw5_21002117_LuongDucAnh.ex1;

import java.util.Arrays;

public class ArrayBinaryTree<E> implements BinaryTreeInterface<E> {
     private E[] array;
     private int n = 0;
     private final int DEFAULT_SIZE = 100;

     public ArrayBinaryTree() {
          array = (E[]) new Object[DEFAULT_SIZE];
     }

     // update methods
     public void setRoot(E element) {
          // Set element to root of an empty tree

          if (!isEmpty()) {
               throw new IllegalStateException("Tree is not empty");
          }
          array[0] = element;
          n++;
     }

     public void setLeft(int p, E element) {
          // Set left child of p
          if (array[p] == null) {
               throw new IllegalArgumentException("No parent found");
          }
          int idx = 2 * p + 1;
          if (idx >= array.length) {
               array = Arrays.copyOf(array, array.length * 2 + 1);
          }
          if (array[idx] == null) {
               n++;
          }
          array[idx] = element;
     }

     public void setRight(int p, E element) {
          // Set right child of p
          if (array[p] == null) {
               throw new IllegalArgumentException("No parent found");
          }
          int idx = 2 * p + 2;
          if (idx >= array.length) {
               array = Arrays.copyOf(array, array.length * 2 + 1);
          }
          if (array[idx] == null) {
               n++;
          }
          array[idx] = element;
     }

     @Override
     public boolean isEmpty() {
          return n == 0;
     }

     private int find(E p) {
          for (int i = 0; i < array.length; i++) {
               if (array[i].equals(p)) {
                    return i;
               }
          }
          return -1;
     }

     @Override
     public E left(E p) {
          int idx = find(p);
          if (idx == -1) {
               return null;
          }
          idx = 2 * idx + 1;
          if (idx < array.length) {
               return array[idx];
          }
          return null;

     }

     @Override
     public int numChildren(E p) {
          int idx = find(p);
          int numOfChildren = 0;
          if (idx == -1) {
               return 0;
          }
          int left = 2 * idx + 1;
          if (left < array.length && array[left] != null) {
               numOfChildren++;
          }
          int right = 2 * idx + 2;
          if (right < array.length && array[right] != null) {
               numOfChildren++;
          }
          return numOfChildren;
     }

     @Override
     public E parent(E p) {
          int idx = find(p);
          if (idx <= 0) {
               return null;
          }
          if (idx % 2 == 0) {
               return array[(idx - 2) / 2];
          } else {
               return array[(idx - 1) / 2];
          }
     }

     @Override
     public E right(E p) {
          int idx = find(p);
          if (idx == -1) {
               return null;
          }
          idx = 2 * idx + 2;
          if (idx < array.length) {
               return array[idx];
          }
          return null;
     }

     @Override
     public E root() {
          return array[0];
     }

     @Override
     public E sibling(E p) {
          int idx = find(p);
          if (idx <= 0) {
               return null;
          }
          if (idx % 2 == 0) {
               return array[idx - 1];
          } else {
               return array[idx + 1];
          }
     }

     @Override
     public int size() {
          return n;
     }

     @Override
     public String toString() {
          if (isEmpty()) {
               return "";
          }
          StringBuilder sb = new StringBuilder();
          treeString(sb, 0, root());
          sb.delete(sb.length() - 1, sb.length());
          return sb.toString();
     }

     private void treeString(StringBuilder result, int level, E current) {
          if (current != null) {
               treeString(result, level + 1, right(current));
               result.append("    ".repeat(level)).append(current).append("\n");
               treeString(result, level + 1, left(current));
          }
     }
}
