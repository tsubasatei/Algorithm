package primary.class08;

/**
 * @author xt
 * @Desc 不要用任何比较判断返回两个数中较大的数
 */
public class Code01_GetMax {

    public static int flip(int n) {
        return n ^ 1;
    }

    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax1(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a); // 0
        int sb = sign(b); // 0
        int sc = sign(c); // 1
        int difSab = sa ^ sb; // 0
        int sameSab = flip(difSab); // 1
        int returnA = difSab * sa + sameSab * sc; // 1
        int returnB = flip(returnA); // 0
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        int a = -16;
        int b = -19;
        System.out.println(getMax1(a, b));
        System.out.println(getMax2(a, b));
        a = 2147483647;
        b = -2147480000;
        System.out.println(getMax1(a, b)); // wrong answer because of overflow
        System.out.println(getMax2(a, b));
    }
}
