package Hw4_21002117.ex4;

import Hw4_21002117.ex1.LinkedListStack;
import Hw4_21002117.ex2.LinkedListQueue;

public class Palindrome {
     public static boolean isPalindrome(String s) {
          s = s.replaceAll("[^a-zA-Z0-9\\p{L}]", "").toLowerCase();
          LinkedListStack<Character> stack = new LinkedListStack<>();
          LinkedListQueue<Character> queue = new LinkedListQueue<>();
          for (int i = 0; i < s.length(); i++) {
               char c = s.charAt(i);
               stack.push(c);
               queue.enqueue(c);
          }
          while (!stack.isEmpty()) {
               if (!stack.pop().equals(queue.dequeue())) {
                    return false;
               }
          }
          return true;
     }

     public static void main(String[] args) {
          String[] sentences = {"No, it is opposition",
                  "Murder for a jar of red rum",
                  "Prepare before you go",
                  "Mr. Owl ate my metal worm",
                  "Ask people to correct you"};
          for (String s : sentences) {
               System.out.print("\"" + s + "\" ");
               if (isPalindrome(s)) {
                    System.out.println("is palindrome");
               } else {
                    System.out.println("is not palindrome");
               }
          }
     }
}
