package Hw1_21002117.ex5;

public class App {
     public static void printList(SimpleLinkedList list) {
          if (list.size() == 0) {
               System.out.println("[]");
               return;
          }
          StringBuilder builder = new StringBuilder("[");
          for (int i = 0; i < list.size() - 1; i++) {
               builder.append(list.get(i)).append(", ");
          }
          builder.append(list.get(list.size() - 1));
          builder.append("]");
          System.out.println(builder);
     }

     public static void main(String[] args) {
          SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
          list.addBot(100);
          list.addBot(300);
          list.add(200);
          list.add(400);
          System.out.println(list.size());
          printList(list);
          if (list.isContain(300)) {
               System.out.println("300 exists");
          }
          list.removeTop();
          printList(list);
     }
}
