package Hw7_21002117_LuongDucAnh;

import java.util.Arrays;

public class BinarySearchTree<T extends Number & Comparable<T>> {

     public static class Node<T> {
          T element;
          Node<T> left, right;

          public Node(T element) {
               this.element = element;
          }

          @Override
          public String toString() {
               return "Node{" +
                       "element=" + element +
                       ", left=" + left +
                       ", right=" + right +
                       '}';
          }
     }

     private Node<T> root;
     private int size;

     public BinarySearchTree() {
     }

     public BinarySearchTree(T... elements) {
          for (T e : elements) {
               insert(e);
          }
     }

     public void insert(T element) {
          root = insert(root, element);
     }

     private Node<T> insert(Node<T> current, T element) {
          if (current == null) {
               current = new Node<>(element);
               size++;
               return current;
          }
          if (current.element.compareTo(element) > 0) {
               current.left = insert(current.left, element);
          }
          if (current.element.compareTo(element) < 0) {
               current.right = insert(current.right, element);
          }
          return current;
     }

     public Node<T> search(T element) {
          return search(root, element);
     }

     private Node<T> search(Node<T> current, T element) {
          if (current == null || current.element.compareTo(element) == 0) {
               return current;
          }
          if (current.element.compareTo(element) > 0) {
               return search(current.left, element);
          }
          return search(current.right, element);
     }

     public Node<T> delete(T element) {
          if (isEmpty()) {
               throw new IllegalStateException("Tree is empty!");
          }
          return delete(root, element);
     }

     private Node<T> delete(Node<T> current, T element) {
          if (current == null) {
               return null;
          }
          if (current.element.compareTo(element) > 0) {
               current.left = delete(current.left, element);
               return current;
          } else if (current.element.compareTo(element) < 0) {
               current.right = delete(current.right, element);
               return current;
          } else {
               size--;
               if (current.left == null) {
                    return current.right;
               } else if (current.right == null) {
                    return current.left;
               } else {
                    Node<T> successorParent = current;
                    Node<T> successor = current.right;
                    while (successor.left != null) {
                         successorParent = successor;
                         successor = successor.left;
                    }
                    if (successorParent != current) {
                         successorParent.left = successor.right;
                    } else {
                         successorParent.right = successor.right;
                    }
                    current.element = successor.element;
                    return current;
               }
          }
     }

     public boolean isEmpty() {
          return root == null;
     }

     public static <T extends Comparable<T>> boolean isRepresentingBST(T[] arr) {
          for (int i = 0; i + 1 < arr.length; i++) {
               if (arr[i + 1].compareTo(arr[i]) <= 0) {
                    return false;
               }
          }
          return true;
     }

     @Override
     public String toString() {
          if (isEmpty()) {
               return "";
          }
          StringBuilder sb = new StringBuilder();
          inOrderString(root, sb);
//          sb.delete(sb.length() - 1, sb.length());
          sb.append("(size = ").append(size).append(")");
          return sb.toString();
     }

     private void inOrderString(Node<T> current, StringBuilder sb) {
          if (current != null) {
               inOrderString(current.left, sb);
               sb.append(current.element).append(" ");
               inOrderString(current.right, sb);
          }
     }

     public double findMedian() {
          if (isEmpty()) {
               throw new IllegalStateException("Tree is empty!");
          }
          double[] arr = inOrderArray();
          if (size % 2 != 0) {
               return arr[size / 2];
          } else {
               return (arr[size / 2] + arr[size / 2 - 1]) / 2;
          }
     }

     private double[] inOrderArray() {
          double[] result = new double[size];
          int count = 0;
          Node<T> current = root;
          while (current != null) {
               if (current.left == null) {
                    result[count++] = current.element.doubleValue();
                    current = current.right;
               } else {
                    Node<T> temp = current.left;
                    while (temp.right != null && temp.right != current) {
                         temp = temp.right;
                    }
                    if (temp.right == null) {
                         temp.right = current;
                         current = current.left;
                    } else {
                         temp.right = null;
                         result[count++] = current.element.doubleValue();
                         current = current.right;
                    }
               }
          }
          return result;
     }

     public T min() {
          if (isEmpty()) {
               throw new IllegalStateException("Tree is empty!");
          }
          Node<T> current = root;
          while (current.left != null) {
               current = current.left;
          }
          return current.element;
     }

     public Node<T> inOrderSuccessor(Node<T> x) {
          if (isEmpty()) {
               throw new IllegalStateException("Tree is empty!");
          }
          Node<T> successor = null;
          Node<T> current = root;
          while (current != null) {
               if (current.element.compareTo(x.element) <= 0) {
                    current = current.right;
               } else {
                    successor = current;
                    current = current.left;
               }
          }
          return successor;
     }

     @SuppressWarnings("unchecked")
     public Node<T>[] predecessorAndSuccessor(T x) {
          if (isEmpty()) {
               throw new IllegalStateException("Tree is empty!");
          }
          Node<T>[] result = (Node<T>[]) new Node[2];
          predecessorAndSuccessor(root, result, x);
          return result;
     }

     private void predecessorAndSuccessor(Node<T> current, Node<T>[] result, T x) {
          if (current == null) {
               return;
          }
          if (current.element.equals(x)) {
               if (current.left != null) {
                    Node<T> temp = current.left;
                    while (temp.right != null) {
                         temp = temp.right;
                    }
                    result[0] = temp;
               }
               if (current.right != null) {
                    Node<T> temp = current.right;
                    while (temp.left != null) {
                         temp = temp.left;
                    }
                    result[1] = temp;
               }
               return;
          }
          if (current.element.compareTo(x) > 0) {
               result[1] = current;
               predecessorAndSuccessor(current.left, result, x);
          } else {
               result[0] = current;
               predecessorAndSuccessor(current.right, result, x);
          }
     }

     public T ceil(T x) {
          if (search(x) != null) {
               return x;
          }
          Node<T>[] result = predecessorAndSuccessor(x);
          if (result[1] != null) {
               return result[1].element;
          }
          return null;
     }

     public T floor(T x) {
          if (search(x) != null) {
               return x;
          }
          Node<T>[] result = predecessorAndSuccessor(x);
          if (result[0] != null) {
               return result[0].element;
          }
          return null;
     }

     public static void main(String[] args) {
          BinarySearchTree<Integer> tree = new BinarySearchTree<>(10, 20, -10, -5, -3, 2, -15, 13, 20, 45, 34, 37, 49);
          System.out.println(tree);
          tree.delete(-15);
          tree.delete(34);
          System.out.println(tree);
          Node<Integer> temp = tree.search(45);
          System.out.println(temp);
          System.out.println(tree.inOrderSuccessor(temp));
          System.out.println(Arrays.toString(tree.predecessorAndSuccessor(35)));
          System.out.println("Median is " + tree.findMedian());
          System.out.println("Min is " + tree.min());
          System.out.println(tree.floor(38));
          System.out.println(tree.ceil(38));
     }
}
