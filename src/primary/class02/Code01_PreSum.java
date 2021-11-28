package primary.class02;

/**
 * @author xt
 * @Desc 求前缀和
 * 假设有一个数组arr，用户总是频繁的查询arr中某一段的累加和。
 * 求sum(arr, L, R)
 */
public class Code01_PreSum {

    public static class RangeSum1 {
        private int[] arr;

        public RangeSum1(int[] arr) {
            this.arr = arr;
        }

        public int rangeSum(int L, int R) {
            int sum = 0;
            for (int i = L; i <= R; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }

    public static class RangeSum2 {
        private int[] preSum;

        public RangeSum2(int[] arr) {
            preSum = new int[arr.length];
            preSum[0] = arr[0];
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = arr[i] + preSum[i - 1];
            }
        }

        public int rangeSum(int L, int R) {
            return L == 0 ? preSum[R] : preSum[R] - preSum[L - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 1, 6, 7, 8};
        int L = 0;
        int R = 5;
        int sum1 = new RangeSum1(arr).rangeSum(L, R);
        int sum2 = new RangeSum2(arr).rangeSum(L, R);
        System.out.println(sum1 == sum2);
    }

    private static int getPreSum(int[] arr, int L, int R) {
        return L == 0 ? arr[R] : arr[R] - arr[L - 1];
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
