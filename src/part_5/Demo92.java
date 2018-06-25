package part_5;

/**
 * 字符串问题
 * 回文最少分割数
 *
 * 题目：
 * 给定一个字符串str，返回把str全部切成回文子串的最小分割数
 *
 * 举例：
 * str="ABA",
 * 不需要切割，str本身就是回文串，所以返回0
 * str="ACDCDCDAD"
 * 最少需要切2次编程3哥回文子串，比如"A"、"CDCDC"和"DAD"，所以返回 2
 * */
public class Demo92 {

    public int munCut(String str) {
        if (str == null || str.equals(""))
            return 0;
        char[] chas = str.toCharArray();
        int len = chas.length;
        int[] dp = new int[len+1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0 ; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (chas[i] == chas[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i],dp[j+1] + 1);
                }
            }
        }
        return dp[0];
    }

}
