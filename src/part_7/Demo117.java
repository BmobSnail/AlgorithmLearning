package part_7;

/**数组和矩阵问题
 * 子矩阵的最大累加和问题
 *
 * 题目：
 * 给定一个矩阵matrix，其中的值有正、负、有0，返回子矩阵的最大累加和。
 * 例如，矩阵matrix为：
 * -90  48  78
 * 64   -40 64
 * -81  -7  66
 *
 * 其中最大的累加和子矩阵为:
 * 48   78
 * -40  64
 * -7   66
 * 所以返回累加和为 209
 *
 * */
public class Demo117 {

    public int maxSum(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0 ;
        int[] s = null;
        for (int i = 0; i != m.length; i++) {
            s = new int[m[0].length];
            for (int j = 0; j != m.length; j++) {
                cur = 0;
                for (int k = 0; k != s.length; k++) {
                    s[k] += m[j][k];
                    cur += s[k];
                    max = Math.max(max,cur);
                    cur = cur < 0 ? 0 : cur;
                }
            }
        }
        return max;
    }

}
