package part_4;

/**
 * 递归和动态规划
 * 换钱的方法数
 * <p>
 * 题目：
 * 给定数组arr，arr中所有的值都为正整数且不重复，每个值代表一种面值的货币，每种面值的货币
 * 可以使用任意张，再给定一个正整数aim代表要找的钱数，求换钱有多少种方法
 * <p>
 * 例子：
 * arr=[5,10,25,1],aim=0
 * 组成0元的方法有1中，就是所有面值的货币都不用，所以返回1
 * arr=[5,10,25,1],aim=15
 * 组成15元的方法有6种
 * 3张5元
 * 1张10元、1张5元
 * 1张10元、5张1元
 * 10张1元、1张5元
 * 2张5元、5张1元
 * 15张1元
 * arr=[3,5],aim=2
 * 任何方法都无法组成2元，所有返回0
 */
public class Demo58 {

    //暴力递归
    public int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        return process1(arr, 0, aim);
    }

    private int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }


    //记忆搜索
    public int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1;arr[0] * j <= aim; j++) {
            dp[0][arr[0]*j]=  1;
        }
        int num = 0;
        for (int i =1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i-1][j-arr[i] * k];
                }
                dp [i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }


    //动态规划
    public int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim+1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        for (int i = 1;i < arr.length ; i++) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i-1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j-arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }


    //动态规划空间压缩
    public int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[] dp = new int[aim + 1];
        for (int i = 0; arr[0] * i <= aim; i++) {
            dp[arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j-arr[i]] : 0;
            }
        }
        return dp[aim];
    }
}
