package primary.class03;

/**
 * @author xt
 * @Desc 局部最小值问题：整体无序，相邻的数不相等
 */
public class Code04_BSAwesome {
    // arr 整体无序
    // arr 相邻的数不相等！
    public static int oneMinIndex(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        int N = arr.length;
        if (N == 1) return 0;
        if (arr[0] < arr[1]) return 0;
        if (arr[N - 2] > arr[N - 1]) return N - 1;
        int L = 0;
        int R = N - 1;
        int mid;
        // L...R 肯定有局部最小
        while (L < R - 1) {
            mid = L + (R - L) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                return mid;
            } else {
                if (arr[mid] > arr[mid - 1]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return arr[L] < arr[R] ? L : R;
    }

    // 生成随机数组，且相邻数不相等
    public static int[] randomArray(int maxLen, int maxValue) {
        int len = (int) (Math.random() * (maxLen + 1));
        int[] arr = new int[len];

        if (len > 0) {
            arr[0] = (int) (Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
            for (int i = 1; i < len; i++) {
                do {
                    arr[i] = (int) (Math.random() * (maxValue + 1)) - (int)(Math.random() * maxValue);
                } while (arr[i] == arr[i - 1]);
            }
        }

        return arr;
    }

    // 也用于测试
    public static boolean check(int[] arr, int minIndex) {
        if (null == arr || arr.length == 0) return minIndex == -1;
        if (arr.length == 1) return minIndex == 0;
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[minIndex] < arr[left] : true;
        boolean rightBigger = right < arr.length ? arr[minIndex] < arr[right] : true;
        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr) {
        if (null == arr || arr.length == 0) return;
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int maxLen = 100;
        int maxValue = 200;
        int testTime = 1000000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = oneMinIndex(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("测试结束");

    }
}
