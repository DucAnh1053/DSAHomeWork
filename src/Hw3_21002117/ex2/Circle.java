package Hw3_21002117.ex2;

public class Circle extends Shape {
     private double radius;

     public Circle(double radius) {
          this.radius = radius;
          setName("Circle[radius=" + radius + "]");
     }

     @Override
     protected double getArea() {
          return Math.PI * radius * radius;
     }

     @Override
     protected double getPerimeter() {
          return 2 * Math.PI * radius;
     }

     @Override
     protected double getVolume() {
          return 0;
     }

}
