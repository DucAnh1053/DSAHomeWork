package Hw6_21002117_LuongDucAnh.ex1;

public class TestQueue {
     public static final String ANSI_RESET = "\u001B[0m";
     public static final String ANSI_GREEN = "\u001B[32m";
     public static final String ANSI_BLACK = "\u001B[30m";
     public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

     public static void testIntQueue(int type) {
          PriorityQueueInterface<Integer, Integer> queue;
          switch (type) {
               case 1 -> {
                    System.out.printf("%sTesting UnsortedArrayPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new UnsortedArrayPriorityQueue<>();
               }
               case 2 -> {
                    System.out.printf("%sTesting SortedArrayPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new SortedArrayPriorityQueue<>();
               }
               case 3 -> {
                    System.out.printf("%sTesting UnsortedLinkedPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new UnsortedLinkedPriorityQueue<>();
               }
               case 4 -> {
                    System.out.printf("%sTesting SortedLinkedPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new SortedLinkedPriorityQueue<>();
               }
               default -> throw new IllegalArgumentException("Invalid type");
          }

          if (queue.isEmpty()) {
               System.out.println("Queue is empty!");
          }
          System.out.println("Adding some elements...");
          queue.insert(15, 15);
          queue.insert(10, 10);
          queue.insert(30, 30);
          queue.insert(45, 45);
          System.out.println(queue);
          System.out.print("The element with the lowest priority is: ");
          System.out.println(queue.min());
          System.out.println("Remove the element with the lowest priority...");
          queue.removeMin();
          System.out.println(queue);
          if (!queue.isEmpty()) {
               System.out.println("Queue is not empty!");
          }
     }

     public static void testObjectQueue(int type) {
          PriorityQueueInterface<Double, String> queue;
          switch (type) {
               case 1 -> {
                    System.out.printf("%sTesting UnsortedArrayPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new UnsortedArrayPriorityQueue<>();
               }
               case 2 -> {
                    System.out.printf("%sTesting SortedArrayPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new SortedArrayPriorityQueue<>();
               }
               case 3 -> {
                    System.out.printf("%sTesting UnsortedLinkedPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new UnsortedLinkedPriorityQueue<>();
               }
               case 4 -> {
                    System.out.printf("%sTesting SortedLinkedPriorityQueue...%s%n", ANSI_GREEN, ANSI_RESET);
                    queue = new SortedLinkedPriorityQueue<>();
               }
               default -> throw new IllegalArgumentException("Invalid type");
          }

          if (queue.isEmpty()) {
               System.out.println("Queue is empty!");
          }
          System.out.println("Adding some elements...");
          queue.insert(99.235, "Sầu riêng");
          queue.insert(35.456, "Dưa hấu");
          queue.insert(120.0, "Chanh leo");
          queue.insert(28.734, "Xoài");

          System.out.println(queue);
          System.out.print("The element with lowest priority is: ");
          System.out.println(queue.min());
          System.out.println("Remove the element with the lowest priority...");
          queue.removeMin();
          System.out.println(queue);
          if (!queue.isEmpty()) {
               System.out.println("Queue is not empty!");
          }
     }

     public static void main(String[] args) {
          System.out.printf("%s%sTesting priority queue with integer numbers...%s%n", ANSI_GREEN_BACKGROUND, ANSI_BLACK, ANSI_RESET);
          for (int i = 1; i <= 4; i++) {
               testIntQueue(i);
               System.out.println("----------------------------");
          }
          System.out.printf("%s%sTesting priority queue with object...%s%n", ANSI_GREEN_BACKGROUND, ANSI_BLACK, ANSI_RESET);
          for (int i = 1; i <= 4; i++) {
               testObjectQueue(i);
               System.out.println("----------------------------");
          }
     }
}