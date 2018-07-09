package part_6;

/**
 * 位运算
 * 只用位运算不用算术运算实现整数的加减乘除运算
 *
 * 题目：
 * 给定两个32位整数a和b，可正、可负、可0.不能使用算术运算付，分别实现a和b的加减乘除运算。
 *
 * 要求：
 * 如果给定的a和b执行加减成熟的某些结果本来就会导致数的溢出，那么你实现的函数不必对那些结果负责
 *
 * */
public class Demo97 {

    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b)<<1;
            a = sum;
        }
        return sum;
    }


    private int negNum(int n) {
        return add(~n,1);
    }

    public int minus(int a, int b) {
        return add(a,negNum(b));
    }

    public int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res,a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    private boolean isNeg(int n) {
        return n < 0;
    }

    public int div(int a, int b) {
        int x = isNeg(a)?negNum(a) : a;
        int y = isNeg(b)?negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1 ; i = minus(i,1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x,y<<i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public int divide(int a, int b) {
        if (b == 0)
            throw new RuntimeException("divisor is 0");
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE)
            return 1;
        else if (b == Integer.MIN_VALUE)
            return 0;
        else if (a == Integer.MIN_VALUE) {
            int res = div(add(a,1),b);
            return add(res,div(minus(a,multi(res,b)),b));
        }else
            return div(a,b);
    }
}

