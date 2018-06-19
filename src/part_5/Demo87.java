package part_5;

/**
 * 字符串问题
 * 0左边必有1的二进制字符串数量
 *
 * 题目：
 * 给定一个整数N，求由 "0" 字符和 "1" 字符组成的长度为N的所有字符串中满足 "0"
 * 左边必有 "1" 的字符串数量
 *
 * 举例:
 * N=1,由"0"与"1"组成的字符串有："0"、"1".只有字符串"1"满足要求，返回 1
 * N=2,由"0"与"1"组成的字符串有："00"、"01"、"10"、"11",只有 "10"、"11"满足要求，返回 2
 * N=3,由"0"与"1"组成的字符串有: "000"、"001"、"010"、"011"、"100"、"101"、"110"、"111"，只有"101"、"110"、"111"满足要求，返回 3
 * */
public class Demo87 {

    public int getNum1(int n) {
        if (n < 1)
            return 0;
        return process(1,n);
    }

    private int process(int i, int n) {
        if (i == n - 1)
            return 2;
        if (i == n)
            return 1;
        return process(i+1,n) + process(n + 2,n);
    }

    public int getNum2(int n) {
        if (n < 1)
            return 0;
        if (n == 1)
            return 1;
        int pre = 1;
        int cur = 1;
        int tmp = 0;
        for (int i = 2; i < n+1; i++) {
            tmp = cur;
            cur += pre;
            pre = tmp;
        }
        return cur;
    }

    public int getNum3(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n ==2)
            return n;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return 2 * res[0][0] + res[1][0];
    }

    private int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (;  p != 0 ; p>>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(tmp,tmp);
            }
            tmp = muliMatrix(tmp,tmp);
        }
        return res;
    }

    private int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0;k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }

            }
        }
        return res;
    }

}
