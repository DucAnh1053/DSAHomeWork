package Hw5_21002117_LuongDucAnh.ex1;

public class LinkedBinaryTree<E> implements BinaryTreeInterface<E> {
     protected static class Node<E> {
          private E element; // an element stored at this node
          private Node<E> parent; // a reference to the parent node (if any)
          private Node<E> left; // a reference to the left child
          private Node<E> right; // a reference to the right child
          // Constructs a node with the given element and neighbors. ∗/

          public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
               element = e;
               parent = above;
               left = leftChild;
               right = rightChild;
          }

          public E getElement() {
               return element;
          }

          public void setElement(E element) {
               this.element = element;
          }

          public Node<E> getParent() {
               return parent;
          }

          public void setParent(Node<E> parent) {
               this.parent = parent;
          }

          public Node<E> getLeft() {
               return left;
          }

          public void setLeft(Node<E> left) {
               this.left = left;
          }

          public Node<E> getRight() {
               return right;
          }

          public void setRight(Node<E> right) {
               this.right = right;
          }

     }

     private Node<E> root;
     private int size = 0;

     // update methods
     public Node<E> addRoot(E element) {
          // Add element to root of an empty tree
          if (!isEmpty()) {
               throw new IllegalStateException("Tree is not empty");
          }
          root = new Node<E>(element, null, null, null);
          size++;
          return root;
     }

     private boolean isContain(Node<E> current, Node<E> target) {
          if (current == null) {
               return false;
          } else if (current == target) {
               return true;
          } else {
               return isContain(current.left, target) || isContain(current.right, target);
          }
     }

     private boolean validate(Node<E> p) {
          if (!isContain(root, p)) {
               throw new IllegalArgumentException("p is not in the tree");
          }
          return true;
     }

     private Node<E> find(E p) {
          Node<E> result = findNode(root, p);
          if (result == null) {
               throw new IllegalArgumentException("Node with element p doesn't exist");
          }
          return result;
     }

     private Node<E> findNode(Node<E> current, E p) {
          if (current == null) {
               return null;
          } else if (current.element.equals(p)) {
               return current;
          } else {
               Node<E> result = findNode(current.left, p);
               if (result != null) {
                    return result;
               }
               return findNode(current.right, p);
          }
     }

     public Node<E> addLeft(Node<E> p, E element) {
          // Add element to left child node of p if empty
          validate(p);
          if (p.left == null) {
               p.left = new Node<E>(element, p, null, null);
               size++;
          }
          return p.left;
     }

     public Node<E> addRight(Node<E> p, E element) {
          // Add element to right child node of p if empty
          validate(p);
          if (p.right == null) {
               p.right = new Node<E>(element, p, null, null);
               size++;
          }
          return p.right;
     }

     public void set(Node<E> p, E element) {
          // set element to node p
          validate(p);
          p.element = element;
     }

     @Override
     public boolean isEmpty() {
          return root == null;
     }

     @Override
     public E left(E p) {
          Node<E> current = find(p);
          if (current.left != null) {
               return current.left.element;
          }
          return null;
     }

     @Override
     public int numChildren(E p) {
          Node<E> current = find(p);
          int num = 0;
          if (current.left != null) {
               num++;
          }
          if (current.right != null) {
               num++;
          }
          return num;
     }

     @Override
     public E parent(E p) {
          Node<E> current = find(p);
          return current.parent.element;
     }

     @Override
     public E right(E p) {
          Node<E> current = find(p);
          if (current.right != null) {
               return current.right.element;
          }
          return null;
     }

     @Override
     public E root() {
          return root.element;
     }

     @Override
     public E sibling(E p) {
          Node<E> current = find(p);
          Node<E> cParent = current.parent;
          if (cParent.left == current && cParent.right != null) {
               return cParent.right.element;
          }
          if (cParent.left != null) {
               return cParent.left.element;
          }
          return null;
     }

     @Override
     public int size() {
          return size;
     }

     private void treeString(StringBuilder result, int level, Node<E> current) {
          if (current != null) {
               treeString(result, level + 1, current.right);
               result.append("    ".repeat(level)).append(current.element).append("\n");
               treeString(result, level + 1, current.left);
          }
     }

     @Override
     public String toString() {
          if (isEmpty()) {
               return "";
          }
          StringBuilder sb = new StringBuilder();
          treeString(sb, 0, root);
          sb.delete(sb.length() - 1, sb.length());
          return sb.toString();
     }

}