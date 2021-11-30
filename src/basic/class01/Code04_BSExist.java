package basic.class01;

import java.util.Arrays;

/**
 * @author xt
 * @Desc 二分法
 */
public class Code04_BSExist {
    public static boolean exist(int[] sortedArr, int num) {
        if (null == sortedArr || sortedArr.length == 0) return false;
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    public static boolean test(int[] sortedArr, int num) {
        if (null == sortedArr || sortedArr.length == 0) return false;
        for (int i = 0; i < sortedArr.length; i++) {
            for(int cur : sortedArr) {
                if(cur == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * maxValue);
        }
        return arr;
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
            Arrays.sort(arr);
            int value = (int)(Math.random() * (maxValue + 1));
            if (exist(arr, value) != test(arr, value)) {
                success = false;
                printArray(arr);
                System.out.println(value);
                System.out.println(exist(arr, value));
                System.out.println(test(arr, value));
                break;
            }
        }
        System.out.println("test end");
        System.out.println(success ? "Nice" : "Fucked");
    }
}
