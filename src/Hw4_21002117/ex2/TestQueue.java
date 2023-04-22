package Hw4_21002117.ex2;

public class TestQueue {
     public static void main(String[] args) {
          System.out.println("Testing ArrayQueue...");
          ArrayQueue<Integer> queue1 = new ArrayQueue<>();
          queue1.enqueue(1);
          queue1.enqueue(2);
          queue1.enqueue(3);
          queue1.enqueue(4);
          System.out.println(queue1);
          System.out.println("First element is: " + queue1.first());
          System.out.print("Remove first element: ");
          queue1.dequeue();
          System.out.println(queue1);
          System.out.print("Remove first element: ");
          queue1.dequeue();
          System.out.println(queue1);
          System.out.println("Add an element: ");
          queue1.enqueue(100);
          System.out.println(queue1);
          System.out.println("----------------------------------");
          System.out.println("Testing LinkedListStack...");
          LinkedListQueue<Integer> queue2 = new LinkedListQueue<>();
          queue2.enqueue(5);
          queue2.enqueue(6);
          queue2.enqueue(7);
          queue2.enqueue(8);
          System.out.println(queue2);
          System.out.println("First element is: " + queue2.first());
          System.out.print("Remove first element: ");
          queue2.dequeue();
          System.out.println(queue2);
          System.out.print("Remove first element: ");
          queue2.dequeue();
          System.out.println(queue2);
          System.out.println("Add an element: ");
          queue2.enqueue(100);
          System.out.println(queue2);
     }
}
