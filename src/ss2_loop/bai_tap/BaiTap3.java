package ss2_loop.bai_tap;

public class BaiTap3 {
    public static void main(String[] args) {
        int N = 2;
        System.out.println("Các số nguyên tố nhỏ hơn 100 là: ");
        while (N < 100) {
            if (isPrime(N)) {
                System.out.println(N + " ");
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
