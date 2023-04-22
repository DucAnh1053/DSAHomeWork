package Hw1_21002117.ex7;

public class WordCount {
     private String word;
     private int count;

     public WordCount(String word) {
          this.word = word;
          count = 1;
     }

     @Override
     public boolean equals(Object obj) {
          if (obj == this) {
               return true;
          }
          if (!(obj instanceof WordCount)) {
               return false;
          }
          WordCount wc = (WordCount) obj;
          return word.equals(wc.word);
     }

     public void addCount() {
          count++;
     }

     @Override
     public String toString() {
          return word + " : " + count;
     }

}
