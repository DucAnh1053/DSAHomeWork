package Hw4_21002117.ex1;

public class TestStack {
     public static void main(String[] args) {
          System.out.println("Testing ArrayStack...");
          ArrayStack<Integer> stack1 = new ArrayStack<>();
          stack1.push(1);
          stack1.push(2);
          stack1.push(3);
          stack1.push(4);
          System.out.println(stack1);
          System.out.println("First element is: " + stack1.top());
          System.out.print("Remove first element: ");
          stack1.pop();
          System.out.println(stack1);
          System.out.println("----------------------------------");
          System.out.println("Testing LinkedListStack...");
          LinkedListStack<Integer> stack2 = new LinkedListStack<>();
          stack2.push(5);
          stack2.push(6);
          stack2.push(7);
          stack2.push(8);
          System.out.println(stack2);
          System.out.println("First element is: " + stack2.top());
          System.out.print("Remove first element: ");
          stack2.pop();
          System.out.println(stack2);
     }
}
