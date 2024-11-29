package ss2_loop.bai_tap;

import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Chọn chức năng \n" + "1. Print the rectangle\n" + "2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)\n" + "3.  Print isosceles triangle\n" + "4. Exit");
            int choose = Integer.parseInt(sc.nextLine());
            String sao = "*";
            switch (choose) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            System.out.print(sao);
                        }
                        System.out.println();
                    }
                    System.out.println("--------------Print the rectangle-------");
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print(sao);
                        }
                        System.out.println(" ");
                    }
                    System.out.println();
                    for (int i = 5; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print(sao);
                        }
                        System.out.println(" ");
                    }
                    System.out.println();
                    for (int i = 5; i > 0; i--) {
                        for (int j = 0; j < 5 - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print(sao);
                        }
                        System.out.println();
                    }
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print(sao);
                        }
                        System.out.println();
                    }
                    System.out.println("---------------Print the square triangle----------");
                    break;
                case 3:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 5 - i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = 1; j <= 2 * i - 1; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("-------------Print isosceles triangle----------------------");
                    break;
                case 4:
                    System.out.println("--------Exit----------------------");
                    System.exit(0);
            }
        }
    }
}