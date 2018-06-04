package part_5;

/**
 * 字符串问题
 * 替换字符串中连续出现的指定字符串
 *
 * 题目：
 * 给定三个字符串str，from和to，把str中所有from的字串全部替换成to字符串，
 * 对连续出现 有连续出现from的部分要求只替换成一个to字符串，返回最终得结果字符串
 *
 * 举例：
 * str="123abc",from="abc",to="4567",返回 "1234567"
 * str="123",from="abc",to="456",返回 "123"
 * str="123abcabc",from="abc",to="X",返回"123x"
 * */
public class Demo77 {

    public String replace(String str,String from,String to) {
        if (str == null || from == null || to == null ||
                str.equals("") || from.equals("") || to.equals(""))
            return str;
        char[] chas = str.toCharArray();
        char[] chaf = from.toCharArray();
        int match = 0;
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] == chaf[match++]) {
                if (match == chaf.length) {
                    clear(chas, i, chaf.length);
                    match = 0;
                }
            } else {
                match = 0;
            }
        }
        String res = "";
        String cur = "";
        for (int i = 0; i < chas.length; i++) {
            if (chas[i] != 0) {
                cur = cur + String.valueOf(chas[i]);
            }
            if (chas[i] == 0 && (i == 0 || chas[i - 1] != 0)) {
                res = res + cur + to;
                cur = "";
            }
        }
        if (!cur.equals("")) {
            res = res + cur;
        }
        return res;
    }

    private void clear(char[] chas, int end, int len) {
        while (len-- != 0) {
            chas[end--] = 0;
        }
    }

}
