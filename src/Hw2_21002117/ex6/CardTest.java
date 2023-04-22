package Hw2_21002117.ex6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import Hw2_21002117.ex5.SortAlgorithm;

public class CardTest {
     public static void main(String[] args) {
          Card[] deck = new Card[52];
          int idx = 0;
          for (int suit = 0; suit < 4; suit++) {
               for (int rank = 0; rank < 13; rank++) {
                    deck[idx] = new Card(suit, rank);
                    idx++;
               }
          }
          shuffleArray(deck);
          System.out.println("Bộ bài sau khi trộn: ");
          System.out.println(Arrays.toString(deck));
          System.out.println("---------------------------------------");
          Card[] deckCopy1 = Arrays.copyOf(deck, deck.length);
          CompareCard compareCard = new CompareCard();
          System.out.println("Sắp xếp lại sử dụng thư viện: ");
          Arrays.sort(deckCopy1, compareCard);
          System.out.println(Arrays.toString(deckCopy1));
          System.out.println("---------------------------------------");
          Card[] deckCopy2 = Arrays.copyOf(deck, deck.length);
          System.out.println("Sắp xếp lại sử dụng thuật toán sắp xếp ở bài 5: ");
          SortAlgorithm.insertionSort(deckCopy2);
          System.out.println(Arrays.toString(deckCopy2));
     }

     public static <T> void shuffleArray(T[] arr) {
          List<T> inList = Arrays.asList(arr);
          Collections.shuffle(inList);
          inList.toArray(arr);
     }
}
