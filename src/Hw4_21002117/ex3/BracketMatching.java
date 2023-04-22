package Hw4_21002117.ex3;

import javax.script.ScriptException;

import Hw4_21002117.ex1.LinkedListStack;

public class BracketMatching {
     public static boolean isValid(String e) {
          LinkedListStack<Character> stack = new LinkedListStack<>();
          char[] inChar = e.toCharArray();
          for (char c : inChar) {
               if (c == '(') {
                    stack.push(c);
               }
               if (c == ')') {
                    if (stack.isEmpty()) {
                         return false;
                    } else {
                         stack.pop();
                    }
               }
          }
          if (!stack.isEmpty()) {
               return false;
          }
          return true;
     }

     public static double evaluate(String s) {
          LinkedListStack<Double> operands = new LinkedListStack<>();
          LinkedListStack<Character> operators = new LinkedListStack<>();
          for (int i = 0; i < s.length(); i++) {
               char c = s.charAt(i);
               if (c == ' ') {
                    continue;
               } else if (c == '(') {
                    operators.push(c);
               } else if (c == ')') {
                    while (operators.top() != '(') {
                         double operand2 = operands.pop();
                         double operand1 = operands.pop();
                         char operator = operators.pop();
                         operands.push(calculate(operand1, operator, operand2));
                    }
                    operators.pop();
               } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                    while (!operators.isEmpty() && precedence(operators.top()) >= precedence(c)) {
                         double operand2 = operands.pop();
                         double operand1 = operands.pop();
                         char operator = operators.pop();
                         operands.push(calculate(operand1, operator, operand2));
                    }
                    operators.push(c);
               } else {
                    int j = i;
                    while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '.')) {
                         j++;
                    }
                    operands.push(Double.parseDouble(s.substring(i, j)));
                    i = j - 1;
               }
          }
          while (!operators.isEmpty()) {
               double operand2 = operands.pop();
               double operand1 = operands.pop();
               char operator = operators.pop();
               operands.push(calculate(operand1, operator, operand2));
          }
          return operands.pop();
     }

     public static double calculate(double operand1, char operator, double operand2) {
          switch (operator) {
               case '+':
                    return operand1 + operand2;
               case '-':
                    return operand1 - operand2;
               case '*':
                    return operand1 * operand2;
               case '/':
                    return operand1 / operand2;
               case '^':
                    return Math.pow(operand1, operand2);
               default:
                    return 0;
          }
     }

     public static int precedence(char operator) {
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

     public static void main(String[] args) throws ScriptException {
          String[] expressions = { "(1 + ((2 + 3) * (4 * 5)))",
                    "((50 - ((8 - 4) * (2 + 3))) + (3 * 4))",
                    "(10 - 8) / ( (2 + 5) * 17)",
                    "(10 - 8 / ( (2 + 5) * 17)",
                    "3 + (2 * 5 + 2*5) * 2",
                    "2 * 5 / (3 + 2",
                    "3 + 4.3 + 5 + 7/2" };
          for (String expression : expressions) {
               if (isValid(expression)) {
                    System.out.println(expression + " is valid");
                    System.out.println("Result: " + evaluate(expression));
               } else {
                    System.out.println(expression + " is not valid");
               }
          }
     }
}
