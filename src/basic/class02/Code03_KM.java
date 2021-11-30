package basic.class02;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xt
 * @Desc 一个数组中有一种数出现K次，其他数都出现了M次，M > 1,  K < M，
 *              1）找到，出现了K次的数，
 *                  要求，额外空间复杂度O(1)，时间复杂度O(N)
 *              2）若没有出现K次，返回-1
 */
public class Code03_KM {

    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == k) {
                return i;
            }
        }
        return -1;
    }

    // 记录 0-31位置
    public static HashMap<Integer, Integer> map = new HashMap<>();
    // 请保证arr中，只有一种数出现了K次，其他数都出现了M次
    public static int onlyKTimes(int[] arr, int k, int m) {
        if (map.size() == 0) {
            mapCreator(map);
        }
        int[] t = new int[32];
        // t[0] 0位置的1出现了几个
        // t[i] i位置的1出现了几个
        for (int num : arr) {
            while (num != 0) {
                int rightOne = num & (~num + 1);
                t[map.get(rightOne)]++;
                num ^= rightOne;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m != 0) {
                if (t[i] % m == k) {
                    ans |= 1 << i;
                } else {
                    return -1;
                }
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) return -1;
        }

        return ans;
    }

    private static void mapCreator(HashMap<Integer, Integer> map) {
        int value = 1;
        for (int i = 0; i < 32; i++) {
            map.put(value, i);
            value <<= 1;
        }
    }

    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        // 出现K次的值
        int kTimeNum = randomNumber(range);
        // 真命天子出现的次数
        int time = Math.random() < 0.5 ? k : (int)(Math.random() * (m - 1)) + 1;
        // 至少有2种数
        int numKinds = (int)(Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) * m
        int[] arr = new int[time + (numKinds - 1) * m];
        // 填数组
        int index = 0;
        for (; index < time; index++) {
            arr[index] = kTimeNum;
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(kTimeNum);
        numKinds--;
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        // arr 填好了，打乱顺序，让 i 位置的数，随机和j位置的数做交换
        for (int i = 0; i < arr.length; i++) {
            int j = (int)(Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    // [-range, +range]
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

    public static void printArray(int[] arr) {
        if (null == arr || arr.length == 0) return;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int kinds = 5; // 数种
        int range = 30; // 数的范围
        int testTime = 100000;
        int max = 9;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int a = (int) (Math.random() * max) + 1; // a 1 ~ 9
            int b = (int) (Math.random() * max) + 1; // b 1 ~ 9
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                printArray(arr);
                System.out.println(ans1);
                System.out.println(ans2);
                System.out.println("出错了！");
                break;
            }
        }
        System.out.println("测试结束");

    }
}
