package ss3_array.bai_tap;

import java.util.Scanner;

public class BaiTap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n + 1];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.print("Nhập giá trị X cần chèn: ");
        int x = scanner.nextInt();
        System.out.print("Nhập vị trí cần chèn: ");
        int index = scanner.nextInt();
        if (index < 0 || index > n) {
            System.out.println("Không thể chèn phần tử vào mảng.");
        } else {
            for (int i = n; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = x;
            System.out.println("Mảng sau khi chèn phần tử là: ");
            for (int i = 0; i <= n; i++) {
                System.out.print(array[i] + " ");
            }
        }
        scanner.close();
    }
}
