package part_5;

/**
 * 字符串问题
 * 字符串的统计字符串
 *
 * 题目：
 * 给定一个字符串str，返回str的统计字符串。例如，"aaabbadddffc"的统计
 * 字符串为"a_3_b_2_a_1_d_3_f_2_c_1"
 *
 * 补充题目：
 * 给定一个字符串的统计字符串cstr，再给定一个整数index，返回cstr所代表的原始字符串上
 * 的第index个字符。例如："a_1_b_100"所代表的原始字符串上第0个字符是"a",第50个字符是"b"
 * */
public class Demo78 {

    public String getCountString(String str) {
        if (str == null || str.equals(""))
            return "";
        char[] chs = str.toCharArray();
        String res = String.valueOf(chs[0]);
        int num = 1;
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] != chs[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(chs[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res,String.valueOf(num),"");
    }

    private String concat(String s1, String s2, String s3) {
        return s1+"_"+s2+(s3.equals("") ? s3 : "_"+s3);
    }

    public char getCharAt(String cstr, int index) {
        if (cstr == null || cstr.equals(""))
            return 0;
        char[] chs = cstr.toCharArray();
        boolean stage = true;
        char cur = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i != chs.length; i++) {
            if (chs[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum += num;
                if (sum > index)
                    return cur;
                num = 0;
                cur = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }
        }
        return sum + num > index ? cur : 0;
    }

}
