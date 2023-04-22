package Hw5_21002117_LuongDucAnh.ex1;

import java.io.FileWriter;
import java.io.IOException;

import Hw5_21002117_LuongDucAnh.ex1.LinkedBinaryTree.Node;

public class LinkedBinaryTreeTest {
     public static void main(String[] args) throws IOException {
          LinkedBinaryTree<Integer> binaryTree = new LinkedBinaryTree<>();
          Node<Integer> root = binaryTree.addRoot(1);
          Node<Integer> leftRoot = binaryTree.addLeft(root, 2);
          Node<Integer> rightRoot = binaryTree.addRight(root, 3);
          binaryTree.addLeft(leftRoot, 4);
          binaryTree.addRight(leftRoot, 5);
          binaryTree.addLeft(rightRoot, 6);
          binaryTree.addRight(rightRoot, 7);
          System.out.println(binaryTree);
          FileWriter fileWriter = new FileWriter("src/Hw5_21002117_LuongDucAnh/ex1/LinkedBT.txt");
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
