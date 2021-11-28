package primary.class08;

import java.util.Arrays;

/**
 * @author xt
 * @Desc 归并排序
 */
public class Code02_MergeSort {

    // 递归实现
    public static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) return;
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;
        int p = L;
        int q = M + 1;
        while (p <= M && q <= R) {
            help[index++] = arr[p] <= arr[q] ? arr[p++] : arr[q++];
        }
        // 要么p越界，要么q越界
        // 不可能出现：共同越界
        while (p <= M) {
            help[index++] = arr[p++];
        }
        while (q <= R) {
            help[index++] = arr[q++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }

    // 非递归实现
    public static void mergeSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int step = 1;
        while (step < N) {
            int L = 0;
            while (L < N ) {
                int M = 0;
                if (N - L >= step) {
                    M = L + step - 1;
                } else {
                    M = N -1;
                }
                if (M == N - 1) {
                    break;
                }
                int R = 0;
                if (N - 1 - M >= step) {
                    R = M + step;
                } else {
                    R = N - 1;
                }
                merge(arr, L, M, R);
                if (R == N - 1) {
                    break;
                } else {
                    L = R + 1;
                }
            }

            if (step > N / 2) {
                break;
            }
            step *= 2;
        }

    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("test end");
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static int[] generateArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * (maxLen + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
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

    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (null == arr1 && null == arr2) return true;
        if ((null == arr1 && arr2 != null) || (null != arr1 && arr2 == null)) return false;
        int len1 = arr1.length;
        int len2 = arr2.length;
        if (len1 != len2) return false;
        for (int i = 0; i < len1; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


