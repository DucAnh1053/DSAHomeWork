package Hw3_21002117.ex4;

public class SimpleLinkedList<T> {
     class Node {
          T data;
          Node next;
     }

     private Node top = null;
     private Node bot = null;
     private int n = 0;

     public void add(T data) {
          // Thêm phần tử vào đầu danh sách
          Node node = new Node();
          node.data = data;
          if (n == 0) {
               top = bot = node;
          } else {
               node.next = top;
               top = node;
          }
          n++;
     }

     public void addBot(T data) {
          // Thêm phần tử vào cuối danh sách
          Node node = new Node();
          node.data = data;
          if (n == 0) {
               top = bot = node;
          } else {
               bot.next = node;
               bot = node;
          }
          n++;
     }

     public T get(int i) {
          // Lấy phần tử ở vị trí thứ i
          if (i < 0 || i >= n) {
               throw new IndexOutOfBoundsException();
          }
          Node current = top;
          for (int j = 1; j <= i; j++) {
               current = current.next;
          }
          return current.data;
     }

     public void set(int i, T data) {
          // Gán giá trị ở vị trí i bằng data
          if (i < 0 || i >= n) {
               throw new IndexOutOfBoundsException();
          }
          Node current = top;
          for (int j = 1; j <= i; j++) {
               current = current.next;
          }
          current.data = data;
     }

     public boolean isContain(T data) {
          // Kiểm tra trong danh sách có chứa phần tử data hay không?
          if (n == 0) {
               return false;
          }
          Node current = top;
          while (current != null) {
               if (current.data.equals(data)) {
                    return true;
               }
               current = current.next;
          }
          return false;
     }

     public int size() {
          // Trả lại thông tin số phần tử có trong danh sách
          return n;
     }

     public boolean isEmpty() {
          // Kiểm tra danh sách có rỗng hay không?
          return n == 0;
     }

     public T removeTop() {

          // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
          if (n == 0) {
               return null;
          }
          if (n == 1) {
               T data = top.data;
               top = bot = null;
               n--;
               return data;
          }
          T data = top.data;
          top = top.next;
          n--;
          return data;
     }

     public T removeBot() {
          // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
          if (n == 0) {
               return null;
          }
          if (n == 1) {
               Node temp = top;
               top = bot = null;
               n--;
               return temp.data;
          }
          Node current = top;
          for (int i = 1; i < n - 1; i++) {
               current = current.next;
          }
          T data = current.next.data;
          current.next = null;
          bot = current;
          n--;
          return data;
     }

     public void remove(T data) {
          // Xóa tất cả các phần tử có giá trị bằng data
          Node previous = null;
          Node current = top;
          while (current != null) {
               if (current.data.equals(data)) {
                    if (previous == null) {
                         top = current.next;
                    } else {
                         previous.next = current.next;
                    }
                    n--;
               } else {
                    previous = current;
               }
               current = current.next;
          }
     }

     @Override
     public String toString() {
          if (n == 0) {
               return "[], size = 0";
          }
          StringBuilder str = new StringBuilder("[");
          Node current = top;
          while (current != null) {
               str.append(current.data).append(", ");
               current = current.next;
          }
          str.delete(str.length() - 2, str.length());
          str.append("], size = ").append(n);
          return str.toString();
     }

     public int indexOf(T data) {
          Node current = top;
          int idx = 0;
          while (current != null) {
               if (current.data.equals(data)) {
                    return idx;
               }
               current = current.next;
               idx++;
          }
          return -1;
     }
}
