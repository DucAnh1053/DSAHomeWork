package Hw8_21002117_LuongDucAnh;

import java.util.*;
import java.lang.*;
import java.io.*;

public class AdjacencyList {
     public static void main(String[] args) throws NumberFormatException, IOException {
          ArrayList<ArrayList<Integer>> adj = new ArrayList<>(List.of(new ArrayList<>(List.of(1, 4)),
                    new ArrayList<>(List.of(0, 2, 3, 4)),
                    new ArrayList<>(List.of(1, 3)),
                    new ArrayList<>(List.of(1, 2, 4)),
                    new ArrayList<>(List.of(0, 1, 3))));

          ArrayList<ArrayList<Integer>> ans = printGraph(adj.size(), adj);
          for (int i = 0; i < ans.size(); i++) {
               for (int j = 0; j < ans.get(i).size() - 1; j++) {
                    System.out.print(ans.get(i).get(j) + "-> ");
               }
               System.out.print(ans.get(i).get(ans.get(i).size() - 1));
               System.out.println();
          }

     }

     public static ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
          ArrayList<ArrayList<Integer>> result = new ArrayList<>();
          for (int i = 0; i < V; i++) {
               ArrayList<Integer> arr = new ArrayList<>();
               arr.add(i);
               arr.addAll(adj.get(i));
               result.add(arr);
          }
          return result;
     }

}
