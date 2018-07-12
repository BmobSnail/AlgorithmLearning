package part_7;

/**
 * 数组和矩阵问题
 * 转圈打印矩阵
 *
 * 题目：
 * 给定一个整形矩阵matrix，请按照转圈得方式打印它
 * 例如：
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 * 打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11，10
 * */
public class Demo101 {

    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }

    private void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
        if (tR == dR) {//子矩阵只有一行时
            for (int i = tC; i <= dC; i++) {
                System.out.println(m[tR][i] + " ");
            }
        } else if (tC == dC) {//子矩阵在只有一列时
            for (int i = tR; i <= dR; i++) {
                System.out.println(m[i][tC] + " ");
            }
        } else {//一般情况
            int curC = tC;
            int curR = tR;
            while (curC != dC) {
                System.out.println(m[tR][curC] + " ");
                curC++;
            }
            while (curR != dR) {
                System.out.println(m[curR][dC] + " ");
                curR++;
            }
            while (curC != tC) {
                System.out.println(m[dR][curC] + " ");
                curC--;
            }
            while (curR != tR) {
                System.out.println(m[curR][tC] + " ");
                curR--;
            }
        }
    }

}
