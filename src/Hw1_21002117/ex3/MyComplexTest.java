package Hw1_21002117.ex3;

public class MyComplexTest {
    public static void main(String[] args) {
        MyComplex complex1 = new MyComplex(1, 2);
        System.out.println("Complex1 = " + complex1);
        MyComplex complex2 = new MyComplex(3, 4);
        System.out.println("Complex2 = " + complex2);
        MyComplex complex3 = new MyComplex(5, 6);
        System.out.println("Complex3 = " + complex3);
        System.out.print("Complex1 + Complex2 = ");
        System.out.println("(" + complex1 + ") + (" + complex2 + ") = " + complex1.add(complex2));
        System.out.print("Complex1 * Complex2 = ");
        System.out.println("(" + complex1 + ") * (" + complex2 + ") = " + complex1.multiply(complex2));
        System.out.print("Complex1 + Complex2 + Complex3 = ");
        System.out.println("(" + complex1 + ") + (" + complex2 + ") + (" + complex3 + ") = " + complex1.add(complex2).add(complex3));
        System.out.print("Complex1 * Complex2 * Complex3 = ");
        System.out.println("(" + complex1 + ") * (" + complex2 + ") * (" + complex3 + ") = " + complex1.multiply(complex2).multiply(complex3));
    }
}
