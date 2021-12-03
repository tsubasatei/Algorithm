package basic.class04;

/**
 * @author xt
 * @Desc
 */
public class Code04_BiggerThanRightTwice {

    public static int biggerTwice(int[] arr) {
        if (null == arr || arr.length < 2) return 0;
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return process(arr, L, M) + process(arr, M + 1, R) + merge(arr, L, M, R);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int ans = 0;
        // 目前囊括进来的数，是从[M+1, windowR)
        int windowR = M + 1;
        for (int i = L; i <= M; i++) {
            while (windowR <= R && arr[i] > arr[windowR] * 2) {
                windowR++;
            }
            ans += windowR - M - 1;
        }
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return ans;
    }

    public static int comparator(int[] arr) {
        if (null == arr || arr.length < 2) return 0;
        int ans = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                ans += arr[i] > arr[j] * 2 ? 1 : 0;
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
            if (biggerTwice(arr1) != comparator(arr2)) {
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
