package ss15_exception;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Nhập cạnh thứ nhất: ");
            double side1 = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ hai: ");
            double side2 = scanner.nextDouble();

            System.out.print("Nhập cạnh thứ ba: ");
            double side3 = scanner.nextDouble();

            checkTriangle(side1, side2, side3);

            System.out.println("Tam giác hợp lệ.");

        } catch (IllegalTriangleException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }

    public static void checkTriangle(double side1, double side2, double side3) throws IllegalTriangleException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalTriangleException("Các cạnh của tam giác phải là số dương.");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException("Tổng 2 cạnh bất kỳ phải lớn hơn cạnh còn lại.");
        }
    }
}
