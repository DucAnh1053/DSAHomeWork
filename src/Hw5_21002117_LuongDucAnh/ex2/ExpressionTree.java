package Hw5_21002117_LuongDucAnh.ex2;

import Hw5_21002117_LuongDucAnh.ex1.LinkedBinaryTree;

public class ExpressionTree<E> extends LinkedBinaryTree<E> {
     public void preOrderPrint(Node<String> p) {
          // pre-order traversal of tree with root p
          if (p == null) {
               return;
          }
          System.out.print(p.getElement() + " ");
          preOrderPrint(p.getLeft());
          preOrderPrint(p.getRight());
     }

     public void postOrderPrint(Node<String> p) {
          // post-order traversal of tree with root p
          if (p == null) {
               return;
          }
          postOrderPrint(p.getLeft());
          postOrderPrint(p.getRight());
          System.out.print(p.getElement() + " ");

     }

     public void inOrderPrint(Node<String> p) {
          // in-order traversal of tree with root p
          if (p == null) {
               return;
          }
          inOrderPrint(p.getLeft());
          System.out.print(p.getElement() + " ");
          inOrderPrint(p.getRight());
     }

     public static double evaluate(Node<String> current) {
          if (current == null) {
               return 0;
          }
          if (current.getLeft() == null && current.getRight() == null) {
               return Double.parseDouble(current.getElement());
          }
          double left = evaluate(current.getLeft());
          double right = evaluate(current.getRight());
          String operator = current.getElement();
          return calculate(left, operator, right);
     }

     public static double calculate(double operand1, String operator, double operand2) {
          switch (operator) {
               case "+":
                    return operand1 + operand2;
               case "-":
                    return operand1 - operand2;
               case "*":
                    return operand1 * operand2;
               case "/":
                    return operand1 / operand2;
               default:
                    return 0;
          }
     }

     public static void main(String[] args) {
          // expression = (20.8 + 4.6 * 2) / 5 - 15 / 3
          ExpressionTree<String> expressionTree = new ExpressionTree<>();
          Node<String> root = expressionTree.addRoot("-");
          expressionTree.addLeft(root, "/");
          expressionTree.addRight(root, "/");
          expressionTree.addLeft(root.getLeft(), "+");
          expressionTree.addRight(root.getLeft(), "5");
          expressionTree.addLeft(root.getLeft().getLeft(), "20.8");
          expressionTree.addRight(root.getLeft().getLeft(), "*");
          expressionTree.addLeft(root.getLeft().getLeft().getRight(), "4.6");
          expressionTree.addRight(root.getLeft().getLeft().getRight(), "2");
          expressionTree.addLeft(root.getRight(), "15");
          expressionTree.addRight(root.getRight(), "3");
          System.out.println("Tree diagram: ");
          System.out.println(expressionTree);
          System.out.print("preOrderPrint: ");
          expressionTree.preOrderPrint(root);
          System.out.println();
          System.out.print("postOrderPrint: ");
          expressionTree.postOrderPrint(root);
          System.out.println();
          System.out.print("inOrderPrint: ");
          expressionTree.inOrderPrint(root);
          System.out.println();
          System.out.print("Result: ");
          System.out.println(evaluate(root));
     }
}