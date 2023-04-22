package Hw3_21002117.ex2;

public abstract class Shape {
     protected String name;

     protected abstract double getVolume();

     protected abstract double getArea();

     protected abstract double getPerimeter();

     protected void setName(String name) {
          this.name = name;
     }

     protected String getName() {
          return this.name;
     }
}