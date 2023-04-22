package Hw3_21002117.ex1;

public class Complex {
     private float real;
     private float image;

     public Complex(float r, float i) {
          real = r;
          image = i;
     }

     public Complex add(Complex c) {
          float newReal = real + c.real;
          float newImage = image + c.image;
          return new Complex(newReal, newImage);
     }

     public Complex minus(Complex c) {
          float newReal = real - c.real;
          float newImage = image - c.image;
          return new Complex(newReal, newImage);
     }

     public Complex time(Complex c) {
          float newReal = real * c.real - image * c.image;
          float newImage = real * c.image + image * c.real;
          return new Complex(newReal, newImage);
     }

     public float realPart() {
          return real;
     }

     public float imagePart() {
          return image;
     }

     @Override
     public String toString() {
          if (real == 0 && image == 0) {
               return "0";
          }
          if (real == 0) {
               return image + "i";
          }
          if (image == 0) {
               return real + "";
          }
          return real + " + " + image + "i";
     }
}