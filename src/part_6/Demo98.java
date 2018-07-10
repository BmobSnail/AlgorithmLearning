package part_6;

/**
 * 位运算
 * 整数的二进制表达中又多少个1
 *
 * 题目：
 * 给定一个32位整数n,可为0,也可为负,返回该整数二进制表达中1的个数。
 * */
public class Demo98 {

    public int count1(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public int count2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n-1);
            res++;
        }
        return res;
    }

    public int count3(int n) {
        int res = 0;
        while (n != 0) {
            n -= n & (~n + 1);
            res ++;
        }
        return res;
    }

    public int count4(int n) {
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);
        return n;
    }
}
