package part_5;

/**
 * 字符串问题
 * 找到字符串的最长无重复字符子串
 *
 * 题目：
 * 给定一个字符串str，返回str的最长无重复字符子串的长度。
 *
 * 举例：
 * str="abcd",返回 4
 * str="aabcb",最长无重复子串为 "abc",返回 3
 * */
public class Demo89 {

    public int maxUnique(String str) {
        if (str == null || str.equals(""))
            return 0;
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i != chas.length; i++) {
            pre = Math.max(pre,map[chas[i]]);
            cur = i - pre;
            len = Math.max(len,cur);
            map[chas[i]] = i;
        }
        return len;
    }

}
