package basic.class04;

import java.util.Arrays;

/**
 * @author xt
 * @Desc 归并排序的递归和非递归实现
 */
public class Code01_MergeSort {

    // 递归方法实现
    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // 请把arr[L..R]排有序
    // l...r N
    // T(N) = 2 * T(N / 2) + O(N)
    // O(N * logN)
    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int M = L + ((R - L) >> 1);
        process(arr, L, M);
        process(arr, M + 1, R);
        merge(arr, L, M, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int [R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }

    // 非递归实现
    public static void mergesort2(int[] arr) {
        if (null == arr || arr.length < 2) return;
        int N = arr.length;
        int step = 1; // 步长
        while (step < N) {
            // 当前左组的，第一个位置
            int L = 0;
            while (L < N) {
                if (step >= N - L) break;
                int M = L + step - 1;
                int R = M + Math.min(step, N - M - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 防止溢出
            if (step > (N >> 1)) break;
            step <<= 1;
        }
    }

    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean test(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return true;
        if (arr1 == null ^ arr2 == null) return false;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
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
        if (null == arr) return;
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
            int[] arr3 = copyArray(arr);
            mergeSort(arr1);
            mergesort2(arr2);
            comparator(arr3);
            if (!test(arr1, arr3) || !test(arr2, arr3)) {
                printArray(arr);
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
                success = false;
                break;
            }
        }
        System.out.println("test end");
        System.out.println(success ? "Nice" : "Fucked");
    }
}
