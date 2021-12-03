package basic.class04;

/**
 * @author xt
 * @Desc
 */
public class Code03_ReversePair {
    public static int reversePairNumber(int[] arr) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    // arr[L..R]既要排好序，也要求逆序对数量返回
    // 所有merge时，产生的逆序对数量，累加，返回
    // 左 排序 merge并产生逆序对数量
    // 右 排序 merge并产生逆序对数量
    private static int process(int[] arr, int L, int R) {
        if (L == R) return 0;
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = help.length - 1;
        int p1 = M;
        int p2 = R;
        int ans = 0;
        while (p1 >= L && p2 > M) {
            ans += arr[p1] > arr[p2] ? (p2 - M) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 > M) {
            help[i--] = arr[p2--];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
        return ans;
    }

    public static int comparator(int[] arr) {
        if (null == arr || arr.length < 2) return 0;
        int ans = 0;
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        if (null == arr) return null;
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static void printArray(int[] arr) {
        if (null == arr || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 100000;
        int maxSize = 100;
        int maxValue = 200;
        boolean success = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            if (reversePairNumber(arr1) != comparator(arr2)) {
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                success = false;
                break;
            }
        }
        System.out.println("test end");
        System.out.println(success ? "Nice" : "Fucked");
    }
}
