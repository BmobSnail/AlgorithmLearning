package part_5;

/**
 * 字符串问题
 * 字符串中数字子串的求和
 *
 * 题目：
 * 给定一个字符串str，求其中全部数字串所代表的数字之和
 *
 * 要求：
 * 1.忽略小数点字符串，例如“A1.3”，其中包含两个数字1和3
 * 2.如果津贴数字字串的左侧出现字符“-”。当连续出现的数量为奇数时，则数字视为负数，
 * 连续出现的次数为偶数时，则数字视为整数。例如“A-1BC--12”，其中包含数字为-1和12
 *
 * 举例：
 * str="A1CD2E33 返回36"
 * str="A-1B--2C--D6E 返回7"
 * */
public class Demo73 {

    public int numSun(String str) {
        if (str == null)
            return 0;
        char[] charArr = str.toCharArray();
        int res = 0;
        int num = 0;
        boolean posi = true;
        int cur = 0;
        for (int i = 0; i < charArr.length; i++) {
            cur = charArr[i] - '0';
            if (cur < 0 || cur > 9) {
                res += num;
                num = 0;
                posi = charArr[i] != '-' || i - 1 > -1 && charArr[i - 1] == '-' && !posi;
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }
        res += num;
        return res;
    }


}
