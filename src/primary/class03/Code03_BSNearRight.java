package primary.class03;

import java.util.Arrays;

/**
 * @author xt
 * @Desc 有序数组中找到<=num最右的位置
 */
public class Code03_BSNearRight {

    // 在arr上，找满足<=value的最右位置
    public static int nearestIndex(int[] arr, int value) {
        if (null == arr || arr.length == 0) return -1;
        int L = 0;
        int R = arr.length - 1;
        int mid;
        int index = -1;
        while (L <= R) {
            mid = L + (R - L) / 2;
            if (arr[mid] <= value) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    // for test
    public static int test(int[] arr, int value) {
        if (null == arr || arr.length == 0) return -1;
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] <= value) {
                return i;
            }
        }
        return -1;
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
            if (nearestIndex(arr, num) != test(arr, num)) {
                System.out.println("Error");
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "Fucking fucked!");
    }
}
