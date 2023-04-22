package Hw5_21002117_LuongDucAnh.ex1;

import java.io.FileWriter;
import java.io.IOException;

public class ArrayBinaryTreeTest {
     public static void main(String[] args) throws IOException {
          ArrayBinaryTree<Integer> binaryTree = new ArrayBinaryTree<>();
          binaryTree.setRoot(1);
          binaryTree.setLeft(0, 2);
          binaryTree.setRight(0, 3);
          binaryTree.setLeft(1, 4);
          binaryTree.setRight(1, 5);
          binaryTree.setLeft(2, 6);
          binaryTree.setRight(2, 7);
          System.out.println(binaryTree);
          FileWriter fileWriter = new FileWriter("src/Hw5_21002117_LuongDucAnh/ex1/ArrayBT.txt");
          fileWriter.write(binaryTree.toString());
          fileWriter.close();
          System.out.print("Value of the root is: ");
          System.out.println(binaryTree.root());
          System.out.print("Number of children of parent node with value of 2 is: ");
          System.out.println(binaryTree.numChildren(2));
          System.out.print("Number of children of parent node with value of 4 is: ");
          System.out.println(binaryTree.numChildren(4));
     }
}
