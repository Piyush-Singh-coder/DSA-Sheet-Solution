package Pow;

// x^n
public class pow {
    public static long bruteForce(int x, int n) {
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= x;
        }
        return ans;
    }

    public static double optimal(int x, int n) {
        double ans = 1.0;
        long nn = n;
        if (nn < 0) {
            nn = -1 * nn;
        }
        while (nn > 0) {
            if (nn % 2 != 0) {
                ans *= x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(bruteForce(2, 5));
        System.out.println(optimal(2, 5));
    }
}
