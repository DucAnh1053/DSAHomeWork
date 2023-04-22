package Hw3_21002117.ex4;

public class App {
     public static void main(String[] args) {
          SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
          list.addBot(300);
          list.addBot(100);
          list.add(200);
          list.add(400);
          list.add(300);
          list.add(300);
          System.out.println(list);
          System.out.println(list.get(0));
          System.out.println(list.get(1));
          System.out.println(list.get(2));
          System.out.println(list.get(5));
          list.set(3, 500);
          System.out.println(list);
          System.out.println(list.isContain(100));
          list.removeTop();
          System.out.println(list);
          list.removeBot();
          System.out.println(list);
          list.remove(300);
          System.out.println(list);
     }
}
