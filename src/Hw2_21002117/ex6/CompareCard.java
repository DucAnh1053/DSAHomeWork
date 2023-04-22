package Hw2_21002117.ex6;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {

     @Override
     public int compare(Card o1, Card o2) {
          return o1.compareTo(o2);
     }

}
