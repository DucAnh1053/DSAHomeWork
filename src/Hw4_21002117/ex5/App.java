package Hw4_21002117.ex5;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
     public static void frame(JPanel panel) {
          JFrame frame = new JFrame();
          frame.add(panel);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setTitle("Tìm đường đi trong mê cung by LĐA");
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
     }

     public static void main(String[] args) {
          Maze maze = new Maze("src/Hw4_21002117/ex5/mazelayout.txt");
          frame(maze);
     }
}
