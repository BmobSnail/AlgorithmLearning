package part_4;

/**
 * 递归和动态规划
 * 数字字符串转换为字母组合的种数
 *
 * 题目：
 * 给定一个字符串str，str全部由数字字符组成，如果str中某一个或某相邻两个字符组成的子串
 * 值在1~26之间，则这个子串可以转换为一个字母，规定“1”转换为“A”，“2”转换为“B”以此类推
 * 写一个函数，求str由多少钟不同的转换结果，并返回种数
 *
 * 举例：
 * str="1111"
 * 能转换出的结果有“AAAA”,"LAA","ALA","AAL"和“LL”,返回5
 * str="01"
 * "0"没有对应的字母，而"01"根据规定不能转换，返回0
 * str="10"
 * 能转换出“J”,返回1
 * */
public class Demo66 {

    public int num1(String str) {
        if(str == null || str.equals(""))
            return 0;
        char[] chs = str.toCharArray();
        return process(chs,0);
    }

    private int process(char[] chs, int i) {
        if (i == chs.length)
            return 1;
        if (chs[i] == '0')
            return 0;
        int res = process(chs,i+1);
        if (i+1<chs.length&&(chs[i] - '0')*10+chs[i+1]-'0' < 27)
            res += process(chs,i+2);
        return res;
    }

    public int num2(String str) {
        if (str == null || str.equals(""))
            return 0;
        char[] chs = str.toCharArray();
        int cur = chs[chs.length - 1] == '0' ? 0 : 1;
        int next = 1;
        int tmp = 0;
        for (int i = chs.length - 2; i >= 0 ; i--) {
            if (chs[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                tmp = cur;
                if ((chs[i] - '0') * 10 + chs[i+1] -'0' < 27)
                    cur += next;
                next = tmp;
            }
        }
        return cur;
    }

}
