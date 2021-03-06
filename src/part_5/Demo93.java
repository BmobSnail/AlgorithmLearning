package part_5;

/**
 * 字符串问题
 * 字符串匹配问题
 *
 * 题目：
 * 给定字符串str,其中绝对不含有字符'.'和'*'。再给定字符串exp,其中可以含有'.'或'*'，
 * '*'字符不能是exp的首字符，平且任意两个'*'字符不相邻。exp中的'.'代表任何一个字符，
 * exp中的'*'表示'*'的前一个字符可以又0个或者多个。请写一个函数，判断str是否被exp匹配。
 *
 * 举例：
 * str="abc",exp="abc"，返回true
 * str="abc",exp="a.b"，返回true
 * str="abcd",exp=".*"，返回true
 * str="",exp="..*"，返回false
 * */
public class Demo93 {

    private boolean isValid(char[] s, char[] e) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '*' || s[i] == '.')
                return false;
        }
        for (int i = 0; i < e.length; i++) {
            if (e[i] == '*' && (i == 0 || e[i-1] == '*'))
                return false;
        }
        return true;
    }

    public boolean isMatch1(String str, String exp) {
        if (str == null || exp == null)
            return false;
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        return isValid(s, e) && process(s, e, 0, 0);
    }

    private boolean process(char[] s, char[] e, int si, int ei) {
        if (ei == e.length)
            return si == s.length;
        if (ei + 1 == e.length || e[ei+1] != '*')
            return si !=s.length && (e[ei] == s[si] || e[ei] == '.'
            && process(s,e,si+1,ei+1));
        while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
            if (process(s,e,si,ei+2))
                return true;
            si++;
        }
        return process(s,e,si,ei+2);
    }

    public boolean isMatchDP(String str, String exp) {
        if (str == null || exp == null)
            return false;
        char[] s = str.toCharArray();
        char[] e = exp.toCharArray();
        if (!isValid(s,e))
            return false;
        boolean[][] dp = initDPMap(s,e);
        for (int i = s.length - 2; i > -1 ; i--) {
            for (int j = e.length - 2; j > -1 ; j--) {
                if (e[j + 1] != '*') {
                    dp[i][j] = (s[i] == e[j] || e[j] == '.') && dp[i + 1][j + 1];
                } else {
                    int si = i;
                    while (si != s.length && (s[si] == e[j] || e[j] == '.')) {
                        if (dp[si][j + 2]) {
                            dp[i][j] = true;
                            break;
                        }
                        si++;
                    }
                    if (!dp[i][j]) {
                        dp[i][j] = dp[si][j+2];
                    }
                }
            }
        }
        return dp[0][0];
    }

    private boolean[][] initDPMap(char[] s,char[] e) {
        int slen = s.length;
        int elen = e.length;
        boolean[][] dp = new boolean[slen + 1][elen + 1];
        dp[slen][elen] = true;
        for (int j = elen - 2; j > -1; j = j - 2) {
            if (e[j] != '*' && e[j + 1] == '*')
                dp[slen][j] = true;
            else
                break;
        }
        if (slen > 0 && elen > 0) {
            if ((e[elen - 1] == '.' || s[slen - 1] == e[elen - 1])) {
                dp[slen - 1][elen - 1] = true;
            }
        }
        return dp;
    }

}
