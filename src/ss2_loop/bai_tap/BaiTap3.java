package ss2_loop.bai_tap;

public class BaiTap3 {
    public static void main(String[] args) {
        int number = 2;
        System.out.println(" số nguyên tố đầu tiền nhỏ hơn 100 là: ");
        while (number < 100) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(number);
            }
            number++;
        }
    }
}
