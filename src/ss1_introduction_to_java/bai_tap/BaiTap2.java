package ss1_introduction_to_java.bai_tap;
import java.util.Scanner;
public class BaiTap2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double rate = 23000;
        System.out.println("Mời bạn nhập số tiền usd");
        double usd = Double.parseDouble(sc.nextLine());
        double vnd = usd * rate;
        System.out.println("Giá trị vnd: " + vnd);
    }
}
