package Hw6_21002117_LuongDucAnh.ex4;

import Hw6_21002117_LuongDucAnh.ex1.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Random;

public class PriorityQueueTest {
     public static final String ANSI_RESET = "\u001B[0m";
     public static final String ANSI_BLACK = "\u001B[30m";
     public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";

     public static int[] randomArray(int length) {
          Random generator = new Random(1);
          int[] arr = new int[length];
          for (int i = 0; i < length; i++) {
               arr[i] = generator.nextInt(-1000, 1000);
          }
          return arr;
     }

     public static String measureInsertTime(PriorityQueueInterface<Integer, Integer> queue, int[] arr) {
          long startTime = System.nanoTime();
          for (int e : arr) {
               queue.insert(e, e);
          }
          long endTime = System.nanoTime();
          return timeFormat(endTime - startTime);
     }

     public static String measureRemoveTime(PriorityQueueInterface<Integer, Integer> queue) {
          long startTime = System.nanoTime();
          while (!queue.isEmpty()) {
               queue.removeMin();
          }
          long endTime = System.nanoTime();
          return timeFormat(endTime - startTime);
     }

     private static String timeFormat(long time) {
          if (time < 1000000000) {
               return String.format("%d nanoseconds", time);
          }
          Duration duration = Duration.ofNanos(time);
          long hours = duration.toHours();
          long minutes = duration.toMinutes() % 60;
          long seconds = duration.getSeconds() % 60;
          long millis = duration.toMillis() % 1000;
          return String.format("%d:%02d:%02d.%03d", hours, minutes, seconds, millis);
     }

     public static void testPQ(int length, FileWriter fileWriter) throws IOException {
          int[] arr = randomArray(length);
          System.out.printf("%s%sn = %d%s%n", ANSI_GREEN_BACKGROUND, ANSI_BLACK, length, ANSI_RESET);
          fileWriter.write("n = %d%n".formatted(length));
          UnsortedArrayPriorityQueue<Integer, Integer> queue1 = new UnsortedArrayPriorityQueue<>(length);
          SortedArrayPriorityQueue<Integer, Integer> queue2 = new SortedArrayPriorityQueue<>(length);
          UnsortedLinkedPriorityQueue<Integer, Integer> queue3 = new UnsortedLinkedPriorityQueue<>();
          SortedLinkedPriorityQueue<Integer, Integer> queue4 = new SortedLinkedPriorityQueue<>();
          System.out.println("Inserting elements into UnsortedArrayPriorityQueue...");
          fileWriter.write("Inserting %d entries into UnsortedArrayPriorityQueue took %s\n".formatted(length, measureInsertTime(queue1, arr)));
          System.out.println("Inserting elements into SortedArrayPriorityQueue...");
          fileWriter.write("Inserting %d entries into SortedArrayPriorityQueue took %s\n".formatted(length, measureInsertTime(queue2, arr)));
          System.out.println("Inserting elements into UnsortedLinkedPriorityQueue...");
          fileWriter.write("Inserting %d entries into UnsortedLinkedPriorityQueue took %s\n".formatted(length, measureInsertTime(queue3, arr)));
          System.out.println("Inserting elements into SortedLinkedPriorityQueue...");
          fileWriter.write("Inserting %d entries into SortedLinkedPriorityQueue took %s\n".formatted(length, measureInsertTime(queue4, arr)));
          System.out.println("Removing elements from UnsortedArrayPriorityQueue...");
          fileWriter.write("Removing %d entries from UnsortedArrayPriorityQueue took %s\n".formatted(length, measureRemoveTime(queue1)));
          System.out.println("Removing elements from SortedArrayPriorityQueue...");
          fileWriter.write("Removing %d entries from SortedArrayPriorityQueue took %s\n".formatted(length, measureRemoveTime(queue2)));
          System.out.println("Removing elements from UnsortedLinkedPriorityQueue...");
          fileWriter.write("Removing %d entries from UnsortedLinkedPriorityQueue took %s\n".formatted(length, measureRemoveTime(queue3)));
          System.out.println("Removing elements from SortedLinkedPriorityQueue...");
          fileWriter.write("Removing %d entries from SortedLinkedPriorityQueue took %s\n".formatted(length, measureRemoveTime(queue4)));
     }

     public static void main(String[] args) throws IOException {
          int[] length = {1_000, 10_000, 100_000, 1_000_000};
          FileWriter fileWriter = new FileWriter("src/Hw6_21002117_LuongDucAnh/ex4/Result.txt");
          for (int l : length) {
               testPQ(l, fileWriter);
               fileWriter.write("\n");
          }
          fileWriter.close();
     }
}
