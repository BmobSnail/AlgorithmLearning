package part_7;

/**数组和矩阵问题
 * 在行列都排好序的矩阵中找数
 *
 * 题目：
 * 给定一个有 N*M 的整型矩阵 matrix 和一个整数 K，matrix 的每一行和每一列都说排好序的。
 * 实现一个函数，判断 K 是否在 matrix 中。
 *
 * 例如:
 * 0    1   2   5
 * 2    3   4   7
 * 4    4   4   8
 * 5    7   7   9
 * 如果 K 为7，返回true:如果 K 为6，返回false
 * */
public class Demo107 {

    public boolean isContains(int[][] matrix, int K) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == K) {
                return true;
            } else if (matrix[row][col] > K) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

}
