package Hw1_21002117.ex7;

import java.util.ArrayList;
import java.util.List;

public class App {
     public static void main(String[] args) {
          String paragraph = "Nory was a Catholic because her mother was a Catholic, and Nory\'s mother was a Catholic because her father was a Catholic, and her father was a Catholic because his mother was a Catholic, or had been.";
          paragraph = paragraph.replaceAll("[-+.^:,]", "").toLowerCase();
          String[] strArr = paragraph.split(" ");
          List<WordCount> list = new ArrayList<>();
          for (String str : strArr) {
               int idx = list.indexOf(new WordCount(str));
               if (idx >= 0) {
                    list.get(idx).addCount();
               } else {
                    list.add(new WordCount(str));
               }
          }
          for (WordCount wc : list) {
               System.out.println(wc);
          }
     }
}
