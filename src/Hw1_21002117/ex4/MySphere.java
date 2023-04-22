package Hw1_21002117.ex4;

public class MySphere {
     private double radius;
     private double posX;
     private double posY;
     private double posZ;

     public MySphere(double radius, double posX, double posY, double posZ) {
          this.radius = radius;
          this.posX = posX;
          this.posY = posY;
          this.posZ = posZ;
     }

     public double lateralArea() {
          return 4 * Math.PI * radius * radius;
     }

     public double totalArea() {
          return 4 * Math.PI * radius * radius * radius / 3;
     }

     public boolean isIntersecting(MySphere other) {
          return Math.sqrt((posX - other.posX) * (posX - other.posX) + (posY - other.posY) * (posY - other.posY)
                    + (posZ - other.posZ) * (posZ - other.posZ)) < radius + other.radius;
     }

     public boolean isOverlaping(MySphere other) {
          return Math.sqrt((posX - other.posX) * (posX - other.posX) + (posY - other.posY) * (posY - other.posY)
                    + (posZ - other.posZ) * (posZ - other.posZ)) + other.radius < radius;
     }

     @Override
     public String toString() {
          return "Sphere[radius=" + radius + ", position(" + posX + ", " + posY + ", " + posZ + ")]";
     }

}