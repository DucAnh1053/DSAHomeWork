package Hw4_21002117.ex5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Maze extends JPanel implements ActionListener {
     class Position {
          int x;
          int y;
          int dir;

          public Position(int x, int y) {
               this.x = x;
               this.y = y;
               dir = 0;
          }

          @Override
          public String toString() {
               return "(" + x + ", " + y + ")";
          }

          public void nextDir() {
               dir++;
          }

          public Position move() {
               switch (dir) {
                    case 0:
                         return moveRight();
                    case 1:
                         return moveDown();
                    case 2:
                         return moveLeft();
                    case 3:
                         return moveUp();
                    default:
                         return null;
               }
          }

          private Position moveRight() {
               return new Position(x, y + 1);
          }

          private Position moveDown() {
               return new Position(x + 1, y);
          }

          private Position moveLeft() {
               return new Position(x, y - 1);
          }

          private Position moveUp() {
               return new Position(x - 1, y);
          }
     }

     private int cellSize;
     private final int PATH = 0;
     private final int WALL = 1;
     private final int START = -2;
     private final int END = -1;
     private final int VISITED = 2;
     private final int DEAD = 3;

     private Timer timer;
     private Position start;
     private Position end;
     private boolean running;
     private List<List<Integer>> mazeLayout;
     private Stack<Position> path = new Stack<>();

     public Maze(String filePath) {
          running = true;
          inputMaze(filePath);
          path.push(start);
          setCellSize();
          setPreferredSize(new Dimension(cellSize * mazeLayout.size(), cellSize * mazeLayout.get(0).size()));
          setBackground(Color.BLACK);
          timer = new Timer(60, this);
          timer.start();
     }

     private void setCellSize() {
          cellSize = 720 / mazeLayout.size();
     }

     private void inputMaze(String filePath) {
          try {
               mazeLayout = new ArrayList<>();
               File file = new File(filePath);
               Scanner sc = new Scanner(file);
               while (sc.hasNextLine()) {
                    String data = sc.nextLine();
                    List<Integer> row = new ArrayList<>();
                    for (int i = 0; i < data.length(); i++) {
                         char c = data.charAt(i);
                         if (c == 's') {
                              start = new Position(row.size(), i);
                              row.add(START);
                         } else if (c == 'e') {
                              end = new Position(row.size(), i);
                              row.add(END);
                         } else {
                              row.add(c - '0');
                         }
                    }
                    mazeLayout.add(row);
               }
               sc.close();
          } catch (FileNotFoundException e) {
               e.printStackTrace();
               System.out.println("File không tồn tại");
          }
     }

     @Override
     public void actionPerformed(ActionEvent e) {
          if (running) {
               next();
          } else {
               timer.stop();
               StringBuilder sb = new StringBuilder();
               int temp = 0;
               System.out.println(path.size());
               System.out.println(end);
               for (Position p : path) {
                    sb.append(p).append(" > ");
                    temp++;
                    if (temp == 10) {
                         sb.append("\n");
                         temp = 0;
                    }
               }
               if (temp != 0) {
                    sb.delete(sb.length() - 3, sb.length());
               } else {
                    sb.delete(sb.length() - 4, sb.length());
               }
               JOptionPane.showMessageDialog(null, sb.toString(), "Đường đi thích hợp",
                         JOptionPane.PLAIN_MESSAGE);
          }
          repaint();
     }

     @Override
     public void paint(Graphics g) {
          super.paint(g);
          // g.translate(0, 30);
          for (int i = 0; i < mazeLayout.size(); i++) {
               for (int j = 0; j < mazeLayout.get(0).size(); j++) {
                    switch (mazeLayout.get(i).get(j)) {
                         case PATH:
                              g.setColor(Color.WHITE);
                              break;
                         case WALL:
                              g.setColor(Color.BLACK);
                              break;
                         case START:
                              g.setColor(Color.BLUE);
                              break;
                         case VISITED:
                              g.setColor(Color.GREEN);
                              break;
                         case DEAD:
                              g.setColor(Color.DARK_GRAY);
                              break;
                         case END:
                              g.setColor(Color.RED);
                              break;
                    }
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
               }
          }
     }

     private boolean isValidMove(Position pos) {
          if (pos == null) {
               return false;
          }
          if (!(pos.x >= 0 && pos.y < mazeLayout.size() && pos.y >= 0 && pos.x < mazeLayout.get(0).size())) {
               return false;
          }
          int value = mazeLayout.get(pos.x).get(pos.y);
          return value <= PATH && value != START;
     }

     private void next() {
          while (true) {
               Position next = path.peek().move();
               path.peek().nextDir();
               if (isValidMove(next)) {
                    if (mazeLayout.get(next.x).get(next.y) != START && mazeLayout.get(next.x).get(next.y) != END) {
                         mazeLayout.get(next.x).set(next.y, VISITED);
                    }
                    path.push(next);
                    break;
               } else {
                    if (path.peek().dir >= 4) {
                         Position temp = path.pop();
                         mazeLayout.get(temp.x).set(temp.y, DEAD);
                         break;
                    }
               }
          }
          if (path.peek().x == end.x && path.peek().y == end.y) {
               running = false;
          }
     }
}
