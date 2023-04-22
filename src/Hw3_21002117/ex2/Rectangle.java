package Hw3_21002117.ex2;

public class Rectangle extends Shape {
     private double width;
     private double height;

     public Rectangle(double width, double height) {
          this.width = width;
          this.height = height;
          setName("Rectangle[width=" + width + ", height=" + height + "]");
     }

     @Override
     protected double getArea() {
          return width * height;
     }

     @Override
     protected double getPerimeter() {
          return (width + height) * 2;
     }

     @Override
     protected double getVolume() {
          return 0;
     }

}
