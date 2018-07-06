package part_6;

/**
 * 位运算
 * 不用任何比较判断找出两个数中比较大的数
 *
 * 题目：
 * 给定两个32位整数a和b，返回a和b中较大的
 *
 * 要求：
 * 不用任何比较判断
 * */
public class Demo96 {

    private int flip(int n) {
        return n^1;
    }

    private int sign(int n) {
        return flip((n>>31)&1);
    }

    public int getMax1(int a,int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }


}
