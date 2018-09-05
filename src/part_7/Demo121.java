package part_7;

/**
 * 数组和矩阵问题
 * 边界都是1的最大正方形大小
 *
 * 题目：
 * 给定一个N*N的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度。
 * 例如：
 * 0    1   1   1   1
 * 0    1   0   0   1
 * 0    1   0   0   1
 * 0    1   1   1   1
 * 0    1   0   1   1
 * 这其中，边框全是1的最大正方形的大小为4*4，所以返回4
 * */
public class Demo121 {

    private void setBorderMap(int[][] m, int[][] right, int[][] down) {
        int r = m.length;
        int c = m[0].length;
        if (m[r - 1][c - 1] == 1) {
            right[r-1][c-1] = 1;
            down[r-1][c-1] = 1;
        }
        for (int i = r - 2; i != -1; i--) {
            if (m[i][c - 1] == 1) {
                right[i][c - 1] = 1;
                down[i][c - 1] = down[i+1][c-1] + 1;
            }
        }
        for (int i = c - 2; i != -1; i--) {
            if (m[r - 1][i] == 1) {
                right[r-1][i] = right[r-1][i+1] + 1;
                down[r - 1][i] = 1;
            }
        }
        for (int i = r - 2; i != -1 ; i--) {
            for (int j = c - 2; j != -1; j--) {
                if (m[i][j] == 1) {
                    right[i][j] = right[i][j+1] + 1;
                    down[i][j] = down[i+1][j] + 1;
                }
            }
        }
    }

    public int getMaxSize(int[][] m) {
        int[][] right = new int[m.length][m[0].length];
        int[][] down = new int[m.length][m[0].length];
        setBorderMap(m,right,down);
        for (int size = Math.min(m.length,m[0].length); size != 0 ; size--) {
            if (hasSizeOfBorder(size,right,down))
                return size;
        }
        return 0;
    }

    private boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
        for (int i = 0; i != right.length - size + 1; i++) {
            for (int j = 0; j != right[0].length - size + 1; j++) {
                if (right[i][j] >= size &&
                        down[i][j] >= size &&
                        right[i + size - 1][j] >= size &&
                        down[i][j + size - 1] >= size) {
                    return true;
                }
            }
        }
        return false;
    }
}
