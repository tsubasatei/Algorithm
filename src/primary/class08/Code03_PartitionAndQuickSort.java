package primary.class08;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author xt
 * @Desc 快排
 */
public class Code03_PartitionAndQuickSort {
    // <=    >
    public static void splitNum1(int[] arr) {
        int lessR = -1;
        int N = arr.length;
        int index = 0;
        while (index < N) {
            if (arr[index] <= arr[N - 1]) {
                swap(arr, ++lessR, index++);
            } else {
                index++;
            }
        }
    }
    public static void splitNum2(int[] arr) {
        int N = arr.length;
        int lessR = -1;
        int moreL = N - 1;
        int index = 0;
        while (index < moreL) {
            if (arr[index] < arr[N - 1]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[N - 1]){
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, index, N - 1);
    }

    private static void quickSort1(int[] arr) {
        if (null == arr || arr.length < 2) return;
        process1(arr, 0, arr.length - 1);
    }

    private static void process1(int[] arr, int L, int R) {
        if (L >= R) return;
        int[] equalE = partition(arr, L, R);
        process1(arr, L, equalE[0] - 1);
        process1(arr, equalE[1] + 1, R);
    }

    // arr[L...R]范围上，拿arr[R]做划分值，
    // L....R < = >
    private static int[] partition(int[] arr, int L, int R) {
        int lessR = L - 1;
        int moreL = R;
        int index = L;
        while (index < moreL) {
            if (arr[index] < arr[R]) {
                swap(arr, ++lessR, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --moreL, index);
            } else {
                index++;
            }
        }
        swap(arr, moreL, R);
        return new int[]{lessR + 1, moreL};
    }

    public static class Job{
        public int L;
        public int R;

        public Job(int l, int r) {
            L = l;
            R = r;
        }
    }
    private static void quickSort2(int[] arr) {
        if (null == arr || arr.length < 2) return;
        Stack<Job> stack = new Stack<>();
        stack.push(new Job(0, arr.length - 1));
        while (!stack.isEmpty()) {
            Job cur = stack.pop();
            int[] equalE = partition(arr, cur.L, cur.R);
            if (equalE[0] > cur.L) { // 有< 区域
                stack.push(new Job(cur.L, equalE[0] - 1));
            }
            if (equalE[1] < cur.R) { // 有> 区域
                stack.push(new Job(equalE[1] + 1, cur.R));
            }
        }
    }

    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R); // <[R] =[R] >[R]
        return new int[] { less + 1, more };
    }

    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = netherlandsFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }

    public static void main(String[] args) {

//        int[] arr = { 7, 1, 3, 5, 4, 5, 1, 4, 2, 4, 2, 4 };
//        printArray(arr);
//		splitNum2(arr);
//		printArray(arr);

        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr1, arr3)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                printArray(arr3);
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

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
