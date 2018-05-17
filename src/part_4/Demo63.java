package part_4;

/**
 * 递归和动态规划
 * 最小编辑代价
 *
 * 题目：
 * 给定两个字符串str1和str2，在给定三个整数ic，dc和rc。
 * 分别代表插入、删除、代替的代价，返回将str1编辑成str2的最小代价
 *
 * 举例：
 * str1="abc",str2="adc",ic=5,dc=3,rc=2
 * 从"abc"编集成"adc"，把 b 替换成 d 是代价最小的，所以返回2
 * str1="abc",str2="adc",ic=5,dc=3,rc=100
 * 从"abc"编集成"adc"，先删除 b 再插入 d 是代价最小的，所以返回8
 * */
public class Demo63 {

    //额外空间复杂度O(M*N)
    public int minCost1(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null)
            return 0;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = chs1.length + 1;
        int col = chs2.length + 1;
        int[][] dp = new int[row][col];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dc * i;
        }
        for (int i = 1; i < col; i++) {
            dp[0][i] = ic * i;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (chs1[i - 1] == chs2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i-1][j-1] +rc;
                }
                dp[i][j] = Math.min(dp[i][j],dp[i][j-1] + rc);
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j] +dc);
            }
        }
        return dp[row - 1][col - 1];
    }


    //空间压缩法
    public int minCost2(String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null)
            return 0;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] longs = chs1.length >= chs2.length ? chs1: chs2 ;
        char[] shorts = chs1.length < chs2.length ? chs1 : chs2;
        if (chs1.length < chs2.length) {
            int temp = ic;
            ic = dc;
            dc = temp;
        }
        int[] dp = new int[shorts.length + 1];
        for (int i = 1; i < shorts.length; i++) {
            dp[i] = ic * i;
        }
        for (int i = 1; i <= longs.length; i++) {
            int pre = dp[0];
            dp[0] = dc * i;
            for (int j= 1; j <=shorts.length ; j++) {
                int tmp = dp[j];
                if (longs[i - 1] == shorts[j - 1]) {
                    dp[j] = pre;
                } else {
                    dp[j] = pre + rc;
                }
                dp[j] = Math.min(dp[j],dp[j-1]+ic);
                dp[j] = Math.min(dp[j],tmp+rc);
                pre = tmp;
            }
        }
        return dp[shorts.length];
    }

}
