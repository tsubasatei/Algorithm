package basic.class01;

/**
 * @author xt
 * @Desc
 */
public class Code07_BSAwesome {
    public static int getLessIndex(int[] arr) {
        if (null == arr || arr.length == 0) return -1;
        int N = arr.length;
        if (N == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[N - 1] < arr[N - 2]) {
            return N - 1;
        }
        int L = 1;
        int R = arr.length - 2;
        int mid;
        while (L < R) {
            mid = (L + (R - L) >> 1);
            if (arr[mid - 1] < arr[mid]) {
                R = mid - 1;
            } else if (arr[mid + 1] < arr[mid]){
                L = mid + 1;
            } else{
                return mid;
            }
        }
        return L;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int len = (int) (Math.random() * (maxSize + 1));
        int[] arr = new int[len];
        if (arr.length > 0) {
            arr[0] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
            for (int i = 1; i < arr.length; i++) {
                do {
                    arr[i] = (int)(Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
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

    public static boolean testLessIndex(int[] arr, int index) {
        if (null == arr || arr.length == 0) return -1 == index;
        int N = arr.length;
        if (N == 1) return 0 == index;
        if (index == 0) return arr[0] < arr[index + 1];
        if (index == arr.length - 1) return arr[index] < arr[index - 1];
        return arr[index] < arr[index - 1] && arr[index] < arr[index + 1];
    }

    public static void main(String[] args) {
        int testTime = 50;
        int maxSize = 10;
        int maxValue = 200;
        boolean success = true;
        System.out.println("test begin");
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int index = getLessIndex(arr);
            if (!testLessIndex(arr, index)) {
                success = false;
                printArray(arr);
                System.out.println(index);
                break;
            }
        }
        System.out.println("test end");
        System.out.println(success ? "Nice" : "Fucked");
    }
}
