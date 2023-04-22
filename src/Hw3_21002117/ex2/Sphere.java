package Hw3_21002117.ex2;

public class Sphere extends Shape {
     private double radius;

     public Sphere(double radius) {
          this.radius = radius;
          setName("Sphere[radius=" + radius + "]");
     }

     @Override
     protected double getArea() {
          return 4 * Math.PI * radius * radius;
     }

     @Override
     protected double getPerimeter() {
          return 0;
     }

     @Override
     protected double getVolume() {
          return 4 * Math.PI * radius * radius * radius / 3;
     }

}
