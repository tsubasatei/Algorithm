package primary.class01;

/**
 * @author xt
 * @Desc
 */
public class Code03_Sort {
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void selectSort(int[] arr) {
        if (null == arr || arr.length < 2) return;
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[minValueIndex] > arr[j] ? j : minValueIndex;
            }
            swap(arr, minValueIndex, i);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) return;
        int N = arr.length;
        for (int end = N - 1; end > 0 ; end--) {
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    public static void insertSort(int[] arr) {
        if (null == arr || arr.length < 2) return;
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            for (int pre = end - 1 ; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        for (int end = 1; end < N; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;
            }
        }
    }
    public static int[] generateArray(int maxLen, int maxValue) {
        int len = (int)(Math.random() * maxLen);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int)(Math.random() * maxValue);
        }
        return arr;
    }

    public static int[] copyArr(int[] arr) {
        if (null == arr) return null;
        int[] ans = new int[arr.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static void printArr(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static boolean checkSort(int[] arr) {
        if (arr == null || arr.length < 2) return true;
        boolean isSorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }
    public static void main(String[] args) {
        int testTimes = 1000;
        int maxLen = 100;
        int maxValue = 1000;
        boolean success = true;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = generateArray(maxLen, maxValue);
            int[] tmp = copyArr(arr);
//            selectSort(arr);
//            bubbleSort(arr);
//            insertSort(arr);
            insertSort2(arr);
            success = checkSort(arr);
            if (!success) {
                success = false;
                printArr(tmp);
                break;
            }
        }
        System.out.println(success ? "Nice" : "Fucking fucked!");
    }
}
