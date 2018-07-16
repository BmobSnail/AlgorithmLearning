package part_7;

/**
 * 数组和矩阵问题
 * “之”字形打印矩阵
 *
 * 题目 :
 * 给定一个矩阵matrix,按照“之”字形的方式打印这个矩阵，例如：
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11   12
 *
 * 之字形打印结果为：1，2，5，9，6，3，4，7，10，11，8，12
 * */
public class Demo103 {

    public void printMatrixZigZag(int[][] martix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = martix.length - 1;
        int endC = martix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(martix,tR,tC,dR,dC,fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    private void printLevel(int[][] m, int tR, int tC, int dR, int dC, boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.println(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.println(m[dR--][dC++]+" ");
            }
        }
    }

}
