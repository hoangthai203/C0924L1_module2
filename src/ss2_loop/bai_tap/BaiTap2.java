package ss2_loop.bai_tap;

public class BaiTap2 {
    public static void main(String[] args) {
        int count = 0;
        int N = 2;
        System.out.println("20 số nguyên tố đầu tiền là: ");
        while (count < 20) {
            if (isPrime(N)) {
                System.out.println(N + " ");
                count++;
            }
            N++;
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
