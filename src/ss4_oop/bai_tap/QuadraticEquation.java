package ss4_oop.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b + Math.sqrt(delta)) / (2 * a);
        }
        return 0;
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b - Math.sqrt(delta)) / (2 * a);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập giá trị a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập giá trị b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập giá trị c: ");
        double c = scanner.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        double delta = equation.getDiscriminant();
        if (delta > 0) {
            System.out.println("Phương trình có hai nghiệm phân biệt:");
            System.out.println("Nghiệm thứ nhất: " + equation.getRoot1());
            System.out.println("Nghiệm thứ hai: " + equation.getRoot2());
        } else if (delta == 0) {
            System.out.println("Phương trình có nghiệm kép:");
            System.out.println("Nghiệm kép: " + equation.getRoot1());
        } else {
            System.out.println("Phương trình không có nghiệm thực.");
        }
    }
}

