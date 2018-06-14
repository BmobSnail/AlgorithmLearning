package part_5;

/**
 * 字符串问题
 * 根据字符串的有效性和最长有效长度
 *
 * 题目：
 * 给定一个字符串str，判断是不是整体有效的括号字符串。
 *
 * 举例：
 * str="()" 返回true,
 * str="(()()) 返回true,
 * str="(())" 返回true,
 * str="())" 返回false，
 * str="()(" 返回false,
 * str="()a()" 返回false
 *
 * 补充题目：
 * 给定一个括号字符串str,返回最长的有效括号字串
 *
 * 举例:
 * str="(()())" 返回6
 * str="())" 返回2
 * str="()(()()(" 返回4
 * */
public class Demo85 {

    public boolean isValid(String str) {
        if (str == null || str.equals(""))
            return false;
        char[] chas = str.toCharArray();
        int status = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != ')' && chas[i] != '(')
                return false;
            if (chas[i] == ')' && --status < 0)
                return false;
            if (chas[i] == '(')
                status++;
        }
        return status == 0;
    }

    public int maxLength(String str) {
        if (str == null || str.equals(""))
            return 0;
        char[] chas = str.toCharArray();
        int[] dp = new int[chas.length];
        int pre = 0;
        int res = 0;
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chas[pre] == '(') {
                    dp[i] = dp[i-1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

}
