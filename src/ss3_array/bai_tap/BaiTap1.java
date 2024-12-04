package ss3_array.bai_tap;

import java.util.Scanner;

public class BaiTap1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Nhập giá trị X cần xóa: ");
        int x = scanner.nextInt();
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Phần tử " + x + " không có trong mảng");
        } else {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            n--;
            System.out.println("Mảng sau khi xóa phần tử " + x + ":");
            for (int i = 0; i < n; i++) {
                System.out.print(array[i] + " ");
            }
        }
        System.exit(0);
    }
}
