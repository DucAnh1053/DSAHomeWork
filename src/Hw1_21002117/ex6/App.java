package Hw1_21002117.ex6;

public class App {
     public static void main(String[] args) {
          SimpleArrayList<Integer> list = new SimpleArrayList<>(10);
          list.add(3);
          list.add(55);
          list.add(1);
          list.add(34);
          System.out.println(list.get(0));
          list.set(0, 123);
          System.out.println(list.get(0));
          list.remove(55);
          list.isContain(5);

          for (Integer number : list) {
               System.out.print(number + " ");
          }
     }
}