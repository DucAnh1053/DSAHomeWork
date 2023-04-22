package Hw2_21002117.ex6;

public class Card implements Comparable<Card> {
     private final String[] CARD_SUIT = { "Clubs", "Diamonds", "Hearts", "Spades" };
     private final String[] CARD_RANK = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
               "King" };
     private int suit, rank;

     public Card(int suit, int rank) {
          this.suit = suit;
          this.rank = rank;
     }

     public int getSuit() {
          return suit;
     }

     public int getRank() {
          return rank;
     }

     @Override
     public String toString() {
          return CARD_RANK[rank] + " of " + CARD_SUIT[suit];
     }

     @Override
     public int compareTo(Card o) {
          int suitComparison = Integer.compare(suit, o.suit);
          if (suitComparison != 0) {
               return suitComparison;
          }
          return Integer.compare(rank, o.rank);
     }
}
