package part_7;

/**
 * 数组和矩阵问题
 * 将正方形矩阵顺时针转动90°
 *
 * 题目：
 * 给定一个N*N的矩阵matrix,吧这个颠调整成顺时针转动90°后的形式
 * 例如：
 * 1    2   3   4
 * 5    6   7   8
 * 9    10  11  12
 * 13   14  15  16
 *
 * 转动后
 * 13   9   5   1
 * 14   10  6   2
 * 15   11  7   3
 * 16   12  8   4
 * */
public class Demo102 {

    public void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR) {
            rotateEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }

    private void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC;//times是总的组数
        int tmp = 0;
        for (int i = 0; i != times; i++) {
            tmp = m[tR][tC+i];
            m[tR][tC+i] = m[dR - i][tC];
            m[dR-i][tC] = m[dR][dC-i];
            m[dR][dC-i] = m[tR+i][dC];
            m[tR+i][dC] = tmp;
        }
    }

}
