package Hw1_21002117.ex4;

public class MySphereTest {
     public static void main(String[] args) {
          MySphere sphere1 = new MySphere(5, 0, 0, 0);
          System.out.println("Sphere1: " + sphere1);
          System.out.println("Lateral Area: " + sphere1.lateralArea());
          System.out.println("Total Area: " + sphere1.totalArea());
          MySphere sphere2 = new MySphere(10, 3, 4, 5);
          System.out.println("Sphere2: " + sphere2);
          if (sphere1.isIntersecting(sphere2)) {
               System.out.println("Sphere1 intersects Sphere2");
          } else {
               System.out.println("Sphere1 do not intersect Sphere2");
          }
          if (sphere1.isOverlaping(sphere2)) {
               System.out.println("Sphere1 overlaps Sphere2");
          } else {
               System.out.println("Sphere1 do not overlap Sphere2");
          }
     }
}
