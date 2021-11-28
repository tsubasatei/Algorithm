package primary.class01;

/**
 * @author xt
 * @Desc 打印一个整数32位
 */
public class Code01_PrintBinary {
    // 打印整数二进制
    public static void print(int num) {
        for (int i = 31; i >= 0 ; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int num = 4;
//        print(num);

//        int test = 1123123;
//        print(test);
//        print(test << 1);
//        print(test << 2);
//        print(test << 8);

//        int a = Integer.MAX_VALUE;
//        System.out.println(a);
//        print(a);

//        print(-1);
//        int a = Integer.MIN_VALUE;
//        print(a);

//        int b = 123823138;
//        int c = ~b;
//        print(b);
//        print(c);

//        print(-5);

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);

//        int a = 12319283;
//        int b = 3819283;
//        print(a);
//        print(b);
//        System.out.println("===========");
//        print(a | b);
//        print(a & b);
//        print(a ^ b);

//        int a = Integer.MIN_VALUE;
//        print(a);
//        print(a >> 1);
//        print(a >>> 1);

//        int c = 5;
//        int d = -c;
//        d = ~c + 1;
//        System.out.println(c);
//        System.out.println(d);

        int c = Integer.MIN_VALUE;
        print(c);
        print(~c+1);

        c = 0;
        print(c);
        print(~c+1);
    }
}
