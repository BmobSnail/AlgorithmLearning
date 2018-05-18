package part_4;


/**
 * 递归和动态规划
 * 字符串的交错组成
 *
 * 题目：
 * 给定sane字符串str1、str2和aim，如果aim包含且仅包含来自str1和str2的所有字符串，
 * 而且在aim中属于str1的字符串之间保持原来在str1的顺序，属于str2的字符串保持原顺序，
 * 那么aim就是str1和str2的交错组成。实现一个函数，判断aim是否是str1和str2的交错组成
 *
 * 举例：
 * str1="AB"
 * str2="12"
 * 那么"AB12"、"A1B2"、"A12B"、"1A2B"、,"1AB2"等都是交错组成
 * */
public class Demo64 {

    //空间复杂度O(M*N)
    public boolean isCross1(String str1, String str2, String aim) {
        if (str1==null || str2==null || aim==null)
            return false;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        if (chaim.length != chs1.length + chs2.length)
            return false;
        boolean[][] dp = new boolean[chs1.length+1][chs2.length+1];
        dp[0][0] = true;
        for (int i = 1; i <= chs1.length; i++) {
            if (chs1[i - 1] != chaim[i - 1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int j = 1; j <= chs2.length; j++) {
            if (chs2[j-1] != chaim[j-1])
                break;
            dp[0][j] = true;
        }
        for (int i = 1; i <= chs1.length; i++) {
            for (int j = 1; j <= chs2.length; j++) {
                if ((chs1[i - 1] == chaim[i + j - 1] && dp[i - 1][j])
                        || (chs2[i-1] == chaim[i+j-1] && dp[i][j-1])) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[chs1.length][chs2.length];
    }

    //空间压min{M*N}
    public boolean isCross2(String str1, String str2, String aim) {
        if (str1 == null || str2 == null || aim == null)
            return false;
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        char[] chaim = aim.toCharArray();
        if (chaim.length != chs1.length + chs2.length)
            return false;
        char[] longs = chs1.length >= chs2.length ? chs1 : chs2;
        char[] shorts = chs1.length < chs2.length ? chs1 : chs2;
        boolean[] dp = new boolean[shorts.length + 1];
        dp[0] = true;
        for (int i = 1; i <= shorts.length; i++) {
            if (shorts[i - 1] != chaim[i - 1])
                break;
            dp[i] = true;
        }
        for (int i = 1; i <= longs.length; i++) {
            dp[0] = dp[0] && longs[i-1] == chaim[i-1];
            for (int j = 1; j <= shorts.length; j++) {
                if ((longs[i - 1] == chaim[i + j - 1] && dp[j]) ||
                        (shorts[j - 1] == chaim[i + j - 1] && dp[j - 1])) {
                    dp[j] = true;
                } else {
                    dp[j] = false;
                }
            }
        }
        return dp[shorts.length];
    }
}
