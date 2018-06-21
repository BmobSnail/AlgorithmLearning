package part_5;

/**
 * 字符串问题
 * 找到被指的新类型字符
 *
 * 题目：
 * 新类型字符的定义如下：
 * 1.新类型字符是长度为1或2的字符串
 * 2.表示形式可以仅是小写字母，例如 "e";也可以是大写字母 + 小写字母,例如 "Ab";
 * 还可以是大写字母 + 大写字母，例如 "DC".
 *
 * 现在给定一个字符串 str,str 一定是若干新类型字符正确组合的结果。比如 "eaCCBi",
 * 由新类型字符 "e"、"a"、"CC" 和 "Bi" 拼成。再给定一个整数k,代表 str 中的位置。
 * 请返回被 k 位置指中的新类型字符。
 *
 * 举例：
 * str="aaABCDEcBCg"
 * 1.k=7,返回 "Ec"
 * 2.k=4,返回 "CD"
 * 3.k=10,返回 "g"
 * */
public class Demo90 {

    public String pointNewchar(String s, int k) {
        if (s == null || s.equals("") || k < 0 || k >= s.length())
            return "";
        char[] chas = s.toCharArray();
        int uNum = 0;
        for (int i = k -1; i >= 0; i--) {
            if (!isUpper(chas[i])) {
                break;
            }
            uNum++;
        }
        if ((uNum & 1) == 1)
            return s.substring(k-1,k+1);
        if (isUpper(chas[k]))
            return s.substring(k,k+2);
        return String.valueOf(chas[k]);
    }

    private boolean isUpper(char c) {
        return c > 64 && c < 91;
    }

}
