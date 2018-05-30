package part_5;

/**
 * 字符串问题
 * 去掉字符串中连续出现k个0的子串
 *
 * 题目：
 * 给定一个字符串str和一个整数k，如果str中正好有连续的k个'0'字符出现时，把
 * k个连续的'0'字符去除，返回处理后的字符串
 *
 * 举例：
 * str="A00B",k=2,返回"A00B"
 * str="A0000B000",k=3,返回"A0000B"
 * */
public class Demo74 {

    public String removeKZeros(String str, int k) {
        if (str == null || k < 1)
            return str;
        char[] chas = str.toCharArray();
        int count = 0,start = -1;
        for (int i = 0; i != chas.length; i++) {
            if (chas[i] == '0') {
                count++;
                start = start == -1 ? i : start;
            } else {
                if (count == k) {
                    while (count-- != 0) {
                        chas[start++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if (count == k) {
            while (count-- != 0) {
                chas[start++] = 0;
            }
        }
        return String.valueOf(chas);
    }

}
