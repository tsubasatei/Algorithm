package basic.class01;

import java.util.Arrays;

/**
 * @author xt
 * @Desc
 */
public class Code06_BSNearRight {

    // 在arr上，找满足<=value的最右位置
    public static int nearestIndex(int[] sortedArray, int value) {
        if (null == sortedArray || sortedArray.length == 0) return -1;
        int L = 0;
        int R = sortedArray.length - 1;
        int index = -1;
        int mid;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArray[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    public static int test(int[] sortedArray, int value) {
        if (null == sortedArray || sortedArray.length == 0) return -1;
        for (int i = sortedArray.length - 1; i >= 0; i--) {
            if (sortedArray[i] <= value) {
                return i;
            }
        }
        return -1;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
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
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 200;
        boolean success = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int value = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
            Arrays.sort(arr);
            if (nearestIndex(arr, value) != test(arr, value)) {
                success = false;
                printArray(arr);
                System.out.println(value);
                System.out.println(nearestIndex(arr, value));
                System.out.println(test(arr, value));
                break;
            }
        }
        System.out.println("test end");
        System.out.println(success ? "Nice" : "Fucked");
    }
}
