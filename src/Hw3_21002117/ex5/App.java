package Hw3_21002117.ex5;

import Hw3_21002117.ex3.SimpleArrayList;

public class App {
     public static void main(String[] args) {
          String paragraph = "We cannot solve problems with the kind of thinking we employed when we came up with them";
          paragraph = paragraph.replaceAll("[^a-zA-Z0-9\\p{L} ]", "").toLowerCase();
          String[] strArr = paragraph.split(" ");
          SimpleArrayList<WordCount> list = new SimpleArrayList<>();
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
          System.out.println(list);
     }
}