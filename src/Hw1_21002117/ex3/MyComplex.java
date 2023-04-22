package Hw1_21002117.ex3;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {
        real = 0.0;
        imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return real + " + " + imag + "i";
    }

    public boolean equals(double real, double imag) {
        return this.real == real && this.imag == imag;
    }

    public boolean equals(MyComplex another) {
        return real == another.real && imag == another.imag;
    }

    public MyComplex add(MyComplex right) {
        return new MyComplex(real + right.real, imag + right.imag);
    }

    public MyComplex subtract(MyComplex right) {
        return new MyComplex(real - right.real, imag - right.imag);
    }

    public MyComplex multiply(MyComplex right) {
        double newReal = real * right.real - imag * right.imag;
        double newImag = real * right.imag + imag * right.real;
        return new MyComplex(newReal, newImag);
    }

    public MyComplex divide(MyComplex right) {
        double newReal = (real * right.real + imag * right.imag) / (right.real * right.real + right.imag * right.imag);
        double newImag = (right.real * imag - right.imag * real) / (right.real * right.real + right.imag * right.imag);
        return new MyComplex(newReal, newImag);
    }
}
