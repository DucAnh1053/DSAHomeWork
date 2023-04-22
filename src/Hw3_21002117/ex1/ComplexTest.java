package Hw3_21002117.ex1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ComplexTest {
     public static void randomComplex(Complex[] arr) {
          Random random = new Random();
          float real, image;
          for (int i = 0; i < arr.length; i++) {
               real = random.nextFloat(100);
               image = random.nextFloat(100);
               arr[i] = new Complex(real, image);
          }
     }

     public static Complex sumAll(Complex[] arr) {
          Complex sum = new Complex(0, 0);
          for (Complex c : arr) {
               sum = sum.add(c);
          }
          return sum;
     }

     public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.print("Enter number of complex numbers: ");
          int size = sc.nextInt();
          sc.close();
          Complex[] complexs = new Complex[size];
          randomComplex(complexs);
          System.out.println(Arrays.toString(complexs));
          System.out.print("Sum of all complex numbers is: " + sumAll(complexs));
     }
     /*
      * Một số ứng dụng của số phức:
      * 1. Tính toán số liệu và đồ hoạ
      * 2. Xử lí tín hiệu âm thanh và hình ảnh
      * 3. Mô phỏng các hệ thống vật lí
      * 4. Tính toán năng lương và tần số
      * 5. Tính toán đa thức và các hàm phức
      */
}
