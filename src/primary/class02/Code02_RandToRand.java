package primary.class02;

/**
 * @author xt
 * @Desc
 */
public class Code02_RandToRand {
    // 此函数只能用，不能修改
    // 等概率返回1~5
    public static int f() {
        return (int)(Math.random() * 5) + 1;
    }

    // 等概率得到0和1
    public static int f2() {
        int ans;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 等概率返回0~6
    public static int f3() {
        int ans;
        do{
            // 000 ~ 111 做到等概率 0 ~ 7等概率返回一个
            ans =  (f2() << 2) + (f2() << 1) + (f2() << 0);
        } while (ans > 6);
        return ans;
    }

    // 等概率返回1~7
    public static int g() {
        return f3() + 1;
    }

    // 这个结构是唯一的随机机制
    // 你只能初始化并使用，不可修改
    public static class RandomBox {
        private final int min;
        private final int max;

        // 初始化时请一定不要让min == max
        public RandomBox(int min, int max) {
            this.min = min;
            this.max = max;
        }

        // 13 ~ 17
        // 13 + [0,4]
        public int random() {
            return min + (int) (Math.random() * (max - min + 1));
        }

        public int min() {
            return min;
        }

        public int max() {
            return max;
        }
    }

    // 利用条件RandomBox，如何等概率返回0和1
    public static int rand01(RandomBox randomBox) {
        int min = randomBox.min();
        int max = randomBox.max();
        // 个数
        int size = max - min + 1;
        // size 是否是奇数
        boolean odd = (size & 1) != 0;
        int mid = size / 2;
        int ans;
        do{
            ans = randomBox.random() - min;
        } while (odd && ans == mid);
        return ans < mid ? 0 : 1;
    }

    // 给你一个RandomBox，这是唯一能借助的随机机制
    // 等概率返回from~to范围上任何一个数
    // 要求from<=to
    public static int random(RandomBox randomBox, int from, int to) {
        if (from == to) return from;
        int range = to - from;
        int num = 1;
        // 求0～range需要几个2进制位
        while (1 << num - 1 < range) {
            num++;
        }
        // 我们一共需要num位
        // 最终的累加和，首先+0位上是1还是0，1位上是1还是0，2位上是1还是0...
        int ans = 0;
        do{
            for (int i = 0; i < num; i++) {
                ans |= (rand01(randomBox)) << i;
            }
        } while (ans > range);
        return ans + from;
    }
    public static void main(String[] args) {
        System.out.println("测试开始");
        // Math.random() -> double -> [0,1)
        int testTimes = 10000000;
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.75) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);

        System.out.println("=========================");

        // [0,1) -> [0,8)
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count ++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println((double)5 / (double)8);

        System.out.println("-------------");
        // [0,K) -> [0,8]，验证等概率
        int K = 9;
        int[] counts = new int[K];
        for (int i = 0; i < testTimes; i++) {
            counts[(int)(Math.random() * K)]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }

        System.out.println("==================");

        count = 0;
        double x = 0.17;
        for (int i = 0; i < testTimes; i++) {
            if (xToXPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double)testTimes);
        System.out.println(Math.pow(x, 2));
        System.out.println((double) 1 - Math.pow((double)1 - x, 2));

        System.out.println("============");
        
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double)testTimes);

        System.out.println("===============");

        counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            counts[g()]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数，出现了 " + counts[i] + " 次");
        }

        System.out.println("==============");
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (y() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double)testTimes);

        System.out.println("==============");

        counts = new int[2];// 0 1
        for (int i = 0; i < testTimes; i++) {
            int ans = y();
            counts[ans]++;
        }
        System.out.println(counts[0] + " , " + counts[1]);

		double zeroP = 0.88;
		RandomBox2 randomBox = new RandomBox2(zeroP);
		count = 0;
		for (int i = 0; i < testTimes; i++) {
			if (rand02(randomBox) == 0) {
				count++;
			}
		}
		System.out.println((double) count / (double) testTimes);
    }

    // 返回[0,1)的一个小数
    // 任意的x，x属于[0,1)，[0,x)范围上的数出现概率由原来的x调整成x平方
    private static double xToXPower2() {
        return Math.max(Math.random(), Math.random());
    }

    // 你只能知道，x会以固定概率返回0和1，但是x的内容，你看不到！
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    // 等概率返回0和1
    public static int y() {
        int ans;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

    // 这个结构是唯一的随机机制
    // 你只能初始化并使用，不可修改
    public static class RandomBox2 {
        private final double p;

        // 初始化时请一定满足：0 < zeroP < 1
        public RandomBox2(double zeroP) {
            p = zeroP;
        }

        public int random() {
            return Math.random() < p ? 0 : 1;
        }

    }

    // 底层依赖一个以p概率返回0，以1-p概率返回1的随机函数rand01p
    // 如何加工出等概率返回0和1的函数
    public static int rand02(RandomBox2 randomBox) {
        int num;
        do {
            num = randomBox.random();
        } while (num == randomBox.random());
        return num;
    }
}
