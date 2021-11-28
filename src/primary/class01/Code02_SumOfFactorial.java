package primary.class01;

/**
 * @author xt
 * @Desc  求 1! + 2! + 3! + 4! + … + N! 的结果
 */
public class Code02_SumOfFactorial {
    public static void main(String[] args) {
        int N = 10;
        System.out.println(f1(N));
        System.out.println(f2(N));
    }

    private static long f1(int N) {
        long ans = 0;
        long cur = 1;
        for (int i = 1; i <= N; i++) {
            cur *= i;
            ans += cur;
        }
        return ans;
    }


    private static long f2(int N) {
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }
        return ans;
    }

    private static long factorial(int N) {
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        return ans;
    }
}
