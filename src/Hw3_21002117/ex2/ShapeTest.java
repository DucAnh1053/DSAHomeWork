package Hw3_21002117.ex2;

public class ShapeTest {
     public static void main(String[] args) {
          Shape[] shapes = new Shape[3];
          shapes[0] = new Circle(5);
          shapes[1] = new Sphere(5);
          shapes[2] = new Rectangle(3, 4);
          for (Shape s : shapes) {
               System.out.println(s.getName());
               System.out.println("Area is " + s.getArea());
               if (s instanceof Sphere) {
                    System.out.println("Volume is " + s.getVolume());
               } else {
                    System.out.println("Perimeter is " + s.getPerimeter());
               }
          }
     }
     /*
      * Một số ứng dụng:
      * 1. Tính toán diện tích và chu vi
      * 2. Vẽ các hình học lên màn hình
      * 3. Xác định toạ độ
      * 4. Tương tác
      */
}