package part_5;

/**
 * 字符串问题
 * 判断两个字符串是否护卫变形词
 *
 * 题目：
 * 给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符出现的次数也一样，
 * 那么str1与str2护卫变形词，请实现函数判断两个字符串是否护卫变形词
 *
 * 举例：
 * str1="123",str2="231",返回true
 * str1="123",str2="2331",返回false
 * */
public class Demo72 {

    public boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null
                || str1.length() != str2.length())
            return false;
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (char c : chas1) {
            map[c]++;
        }
        for (char c : chas2) {
            if (map[c]-- == 0)
                return false;
        }
        return true;
    }

}
