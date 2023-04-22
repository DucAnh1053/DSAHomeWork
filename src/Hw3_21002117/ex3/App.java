package Hw3_21002117.ex3;

public class App {
     public static void main(String[] args) {
          SimpleArrayList<Integer> list = new SimpleArrayList<>(10);
          list.add(3);
          list.add(55);
          list.add(1);
          list.add(34);
          System.out.println(list);
          System.out.println(list.get(0));
          list.set(0, 123);
          System.out.println(list);
          list.remove(55);
          System.out.println(list);
          System.out.println(list.isContain(5));

          for (Integer num : list) {
               System.out.print(num + " ");
          }
          System.out.println();
     }
}