package primary.class03;

import java.util.Arrays;

/**
 * @author xt
 * @Desc 二分查找
 */
public class Code01_BSExist {
    // arr保证有序
    public static boolean find(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        int mid;
        while (L <= R) {
            mid = L + (R - L ) / 2;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return false;
    }

    // for test
    public static boolean test(int[] sortedArr, int num) {
        if (null == sortedArr || sortedArr.length == 0) {
            return false;
        }
        for (int cur : sortedArr) {
            if (cur == num) return true;
        }
        return false;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            int num = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (find(arr, num) != test(arr, num)) {
                System.out.println("Error");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");
    }
}
