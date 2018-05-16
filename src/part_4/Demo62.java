package part_4;

/**
 * 递归和动态规划
 * 最长公共字串问题
 *
 * 题目：
 * 给定两个字符串str1和str2，返回两个字符串的最长公共子串
 *
 * 举例：
 * str1=“1AV2345CD”
 * str2="123456EF"
 * 返回“2345”
 *
 * */
public class Demo62 {

    private int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] == str2[0])
                dp[i][0] = 1;
        }
        for (int i = 1; i < str2.length; i++) {
            if (str1[0] == str2[i])
                dp[0][i]= 1;
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp;
    }

    //空间复杂度O(M*N)
    public String lcst1(String str1,String str2){
        if (str1 == null || str2 == null ||
                str1.equals("") || str2.equals(""))
            return "";
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1,chs2);
        int end = 0;
        int max = 0;
        for (int i = 0; i < chs1.length; i++) {
            for (int j = 0; j < chs2.length; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        return str1.substring(end - max + 1,end + 1);
    }

    //空间复杂度O(1)
    public String lcst2(String str1, String str2) {
        if (str1 == null || str2 == null ||
                str1.equals("") || str2.equals(""))
            return "";
        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int row = 0;//斜线开始位置的行
        int col = chs2.length - 1;//斜线开始位置的列
        int max = 0;//记录最大长度
        int end = 0;//最大长度更新时，几率字串的结尾位置
        while (row < chs1.length) {
            int i = row;
            int j = col;
            int len = 0;
            //从(i，j)开始向右下方遍历
            while (i < chs1.length && j < chs2.length) {
                if (chs1[i] != chs2[j]) {
                    len = 0;
                } else {
                    len++;
                }
                //记录 最大值，以及结束字符的位置
                if (len > max) {
                    end = i;
                    max = len;
                }
                i++;
                j++;
            }
            if (col > 0) {//斜线开始位置的列先向左移动
                col--;
            } else {//列移动到最左之后，行向下移动
                row++;
            }
        }
        return str1.substring(end-max+1,end+1);
    }

}
