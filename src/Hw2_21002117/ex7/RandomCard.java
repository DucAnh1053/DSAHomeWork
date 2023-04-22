package Hw2_21002117.ex7;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import Hw2_21002117.ex6.Card;

public class RandomCard {
     public static void main(String[] args) {
          // Tạo 52 số nguyên ngẫu nhiên < 52 và >= 0
          Set<Integer> randNum = new LinkedHashSet<>();
          Random random = new Random();
          while (randNum.size() < 52) {
               randNum.add(random.nextInt(0, 52));
          }
          // Tạo bộ bài đã sắp sẵn
          Card[] deck = new Card[52];
          int idx = 0;
          for (int suit = 0; suit < 4; suit++) {
               for (int rank = 0; rank < 13; rank++) {
                    deck[idx] = new Card(suit, rank);
                    idx++;
               }
          }
          // Tạo bộ bài ngẫu nhiên theo thứ tự các số đã tạo ở trên
          Card[] randDesk = new Card[52];
          idx = 0;
          for (int num : randNum) {
               randDesk[idx] = deck[num];
          }
          System.out.println(Arrays.toString(randDesk));
          Arrays.sort(randDesk);
          System.out.println("After sorting: ");
          System.out.println(Arrays.toString(randDesk));
     }
}
