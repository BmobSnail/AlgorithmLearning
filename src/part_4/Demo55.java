package part_4;

/**
 * 递归和动态规划
 * 斐波那契系列问题的递归和动态规划
 *
 * 题目1：给定整数N，返回斐波那契数列的第N项
 * 题目2：给定整数N，代表台阶数，一次可以跨2个或者1个，返回有多少种走法
 * 题目3：假设农场成熟的母牛每年只会生1头小母牛，并且永远不会死。第一年农场有1只成熟母牛，第二年开始，母牛开始生小母牛。
 *       每只小母牛3年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量
 *
 * 要求：对以上所有问题，请实现时间复杂度O(logN)的解法
 * */
public class Demo55 {

    //O(2^N)的方法，暴力递归
    public int f1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return f1(n-1) + f1(n-2);
    }

    //O(N)的方法，顺序计算
    public int f2(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int res = 1;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    //O(logN)的方法，状态矩阵
    public int f3(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return res[0][0] + res[1][0];
    }


    //垮台阶O(2^N)方法
    public int s1(int n) {
        if (n < 1)
            return 0;
        if (n == 1|| n == 2)
            return n;
        return s1(n-1) + s1(n-2);
    }

    //跨台阶O(N)方法
    public int s2(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return n;
        int res = 2;
        int pre = 1;
        int tmp = 0;
        for (int i = 3; i <= n; i++) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }
        return res;
    }

    //跨台阶O(logN)方法
    public int s3(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return n;
        int[][] base = {{1,1},{1,0}};
        int[][] res = matrixPower(base,n-2);
        return 2*res[0][0]+res[1][0];
    }

    //牛生牛O(2^N)方法
    public int c1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2 || n == 3)
            return n;
        return c1(n-1) + c1(n-3);
    }

    //牛生牛O(N)方法
    public int c2(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2 || n == 3)
            return n;
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }

    //牛生牛O(logN)方法
    public int c3(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2 || n == 3)
            return n;
        int[][] base = {{1,1,0},{0,0,1},{1,0,0}};
        int[][] res = matrixPower(base,n-3);
        return 3*res[0][0] + 2*res[1][0] + res[2][0];
    }


    //求矩阵中某值
    private int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        //先把res设为单位矩阵，相当于整数中的1
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] tmp = m;
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0)
                res = muliMatrix(res,tmp);
            tmp = muliMatrix(tmp,tmp);
        }
        return res;
    }

    //代入求解矩阵状态值
    private int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }


}
