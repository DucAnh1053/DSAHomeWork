package Hw6_21002117_LuongDucAnh.ex2;

public class MinHeapPQTest {
     public static void main(String[] args) {
          MinHeapPriorityQueue<Integer, Integer> heap = new MinHeapPriorityQueue<>();
          if (heap.isEmpty()) {
               System.out.println("Heap is empty!");
          }
          System.out.println("Adding some elements...");
          heap.insert(15, 15);
          heap.insert(10, 10);
          heap.insert(12, 12);
          heap.insert(5, 5);
          heap.insert(23, 23);
          heap.insert(25, 25);
          heap.insert(27, 27);
          heap.insert(2, 2);
          heap.insert(3, 3);
          heap.insert(40, 40);
          System.out.println(heap);
          System.out.print("The element with the lowest priority is: ");
          System.out.println(heap.min());
          System.out.println("Remove the element with the lowest priority...");
          heap.removeMin();
          System.out.println(heap);
          System.out.print("The element with the lowest priority is: ");
          System.out.println(heap.min());
          System.out.println("Remove the element with the lowest priority...");
          heap.removeMin();
          heap.removeMin();
          heap.removeMin();
          heap.removeMin();
          heap.removeMin();
          heap.removeMin();
          heap.removeMin();
          heap.removeMin();
          heap.removeMin();
          System.out.println(heap);
          if (!heap.isEmpty()) {
               System.out.println("Heap is not empty!");
          }
     }
}
