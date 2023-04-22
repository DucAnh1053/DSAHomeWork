package Hw5_21002117_LuongDucAnh.ex3;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ExpressionTreeBuilder {
     class Node {
          String element;
          Node left;
          Node right;

          public Node(String element) {
               this.element = element;
          }
     }

     class BracketException extends RuntimeException {
          public BracketException(String message) {
               super(message);
          }
     }

     private Node root;

     public ExpressionTreeBuilder(String expression) {
          List<String> postfix = postfix(expression);
          Stack<Node> stack = new Stack<>();
          for (String e : postfix) {
               if (e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/") || e.equals("^")) {
                    Node operand2 = stack.pop();
                    Node operand1 = stack.pop();
                    Node operator = new Node(e);
                    operator.left = operand1;
                    operator.right = operand2;
                    stack.push(operator);
               } else {
                    stack.push(new Node(e));
               }
          }
          root = stack.peek();
     }

     private List<String> postfix(String s) {
          Stack<Character> operators = new Stack<>();
          List<String> list = new ArrayList<>();
          for (int i = 0; i < s.length(); i++) {
               char c = s.charAt(i);
               if (c == ' ') {
                    continue;
               } else if (c == '(') {
                    operators.push(c);
               } else if (c == ')') {
                    while (operators.peek() != '(') {
                         list.add(String.valueOf(operators.pop()));
                    }
                    operators.pop();
               } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                         list.add(String.valueOf(operators.pop()));
                    }
                    operators.push(c);
               } else if (Character.isDigit(c) || c == '.') {
                    int pointCount = 0;
                    int j = i;
                    while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '.')) {
                         if (s.charAt(j) == '.') {
                              pointCount++;
                         }
                         if (pointCount > 1) {
                              throw new NumberFormatException();
                         }
                         j++;
                    }
                    list.add(s.substring(i, j));
                    i = j - 1;
               } else {
                    throw new IllegalArgumentException("Unsupported operation");
               }
          }
          while (!operators.isEmpty()) {
               if (operators.peek() == '(') {
                    throw new BracketException("Brackets are not balanced");
               }
               list.add(String.valueOf(operators.pop()));
          }
          return list;
     }

     public double evaluate() {
          return calculate(root);
     }

     private double calculate(Node current) {
          if (current == null) {
               return 0;
          }
          if (current.left == null && current.right == null) {
               return Double.parseDouble(current.element);
          }
          double left = calculate(current.left);
          double right = calculate(current.right);
          String operator = current.element;
          return calculate(left, operator, right);
     }

     private double calculate(double operand1, String operator, double operand2) {
          switch (operator) {
               case "+":
                    return operand1 + operand2;
               case "-":
                    return operand1 - operand2;
               case "*":
                    return operand1 * operand2;
               case "/":
                    return operand1 / operand2;
               case "^":
                    return Math.pow(operand1, operand2);
               default:
                    return 0;
          }
     }

     private int precedence(char operator) {
          switch (operator) {
               case '+':
               case '-':
                    return 1;
               case '*':
               case '/':
                    return 2;
               case '^':
                    return 3;
               default:
                    return 0;
          }
     }

     private void treeString(StringBuilder result, int level, Node current) {
          if (current != null) {
               treeString(result, level + 1, current.right);
               result.append("    ".repeat(level)).append(current.element).append("\n");
               treeString(result, level + 1, current.left);
          }
     }

     @Override
     public String toString() {
          StringBuilder sb = new StringBuilder();
          treeString(sb, 0, root);
          sb.delete(sb.length() - 1, sb.length());
          return sb.toString();
     }

     public static void main(String[] args) {
          System.out.println("1. Run some test cases");
          System.out.println("2. Manually enter your expression");
          System.out.print("Enter your choice (1 or 2): ");
          Scanner sc = new Scanner(System.in);
          int op;
          while (true) {
               try {
                    op = Integer.parseInt(sc.nextLine());
                    if (op == 1 || op == 2) {
                         break;
                    } else {
                         System.out.print("Invalid Choice. Try again (1 or 2): ");
                         continue;
                    }
               } catch (NumberFormatException e) {
                    System.out.print("Please enter a valid number (1 or 2): ");
               }
          }
          System.out.println("------------------------");

          if (op == 1) {
               String expression1 = "(6 / 2 + 3) * (7 - 4)";
               System.out.println("Expression1: " + expression1);
               ExpressionTreeBuilder expressionTree1 = new ExpressionTreeBuilder(expression1);
               System.out.println("Tree diagram: ");
               System.out.println(expressionTree1);
               System.out.print("Result: ");
               System.out.println(expressionTree1.evaluate());
               System.out.println("------------------------");

               String expression2 = "10.5 * 2 / 3 + 100 - 9.2 * 5";
               System.out.println("Expression2: " + expression2);
               ExpressionTreeBuilder expressionTree2 = new ExpressionTreeBuilder(expression2);
               System.out.println("Tree diagram: ");
               System.out.println(expressionTree2);
               System.out.print("Result: ");
               System.out.println(expressionTree2.evaluate());

               String expression3 = "5 ^ (1 + 2) * 3 - 1000";
               System.out.println("Expression3: " + expression3);
               ExpressionTreeBuilder expressionTree3 = new ExpressionTreeBuilder(expression3);
               System.out.println("Tree diagram: ");
               System.out.println(expressionTree3);
               System.out.print("Result: ");
               System.out.println(expressionTree3.evaluate());
          } else {
               while (true) {
                    System.out.print("Enter your expression: ");
                    String expression = sc.nextLine();
                    try {
                         ExpressionTreeBuilder expressionTree = new ExpressionTreeBuilder(expression);
                         System.out.println("Tree diagram: ");
                         System.out.println(expressionTree);
                         System.out.print("Result: ");
                         System.out.println(expressionTree.evaluate());
                    } catch (EmptyStackException e) {
                         System.out.println("Please enter valid expression.");
                         continue;
                    } catch (NumberFormatException e) {
                         System.out.println("Please enter valid number.");
                         continue;
                    } catch (IllegalArgumentException e) {
                         System.out.println("Unsupported operation.");
                         continue;
                    } catch (BracketException e) {
                         System.out.println("Brackets are not balanced.");
                    }
                    System.out.print("Do you want to try another expression (y/n): ");
                    String opt;
                    while (true) {
                         opt = sc.nextLine().toLowerCase();
                         if (!opt.equals("y") || !opt.equals("yes") || !opt.equals("n") || !opt.equals("no")) {
                              break;
                         } else {
                              System.out.print("Invalid choice. Try again: ");
                         }
                    }
                    if (opt.equals("n") || opt.equals("no")) {
                         break;
                    }
                    System.out.println("------------------------");
               }
          }
          sc.close();
     }
}
