package basic.class02;

/**
 * @author xt
 * @Desc
 */
public class Code01_Swap {

    public static void main(String[] args) {
        int a = 16;
        int b = 603;
        System.out.println(a + ", " + b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
        
        int[] arr = {3, 1, 100};
        int i = 0;
        int j = 1;
        System.out.println(arr[i] + ", " + arr[j]);
        swap(arr, i, j);
        System.out.println(arr[i] + ", " + arr[j]);

        i = 0;
        j = 0;
        System.out.println(arr[i] + ", " + arr[j]);
        swap(arr, i, j);
        System.out.println(arr[i] + ", " + arr[j]);
    }
    public static void swap (int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
