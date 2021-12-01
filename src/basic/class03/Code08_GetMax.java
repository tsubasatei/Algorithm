package basic.class03;

/**
 * @author xt
 * @Desc 递归求最大值
 */
public class Code08_GetMax {
    // 求arr中的最大值
    public static int getMax(int[] arr) {
        if (null == arr && arr.length == 0) throw new RuntimeException("数组为空");
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]范围上求最大值  L ... R   N
    private static int process(int[] arr, int L, int R) {
        // arr[L..R]范围上只有一个数，直接返回，base case
        if (L == R) {
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, 0, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
