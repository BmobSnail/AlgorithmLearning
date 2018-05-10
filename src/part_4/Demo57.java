package part_4;

/**
 * 递归和动态规划
 * 换钱的最少货币数
 *
 * 题目：
 * 给定数组arr，arr中所有的值都为整数且不重复。每个值代表一种面值的货币，
 * 每种面值的货币可以使用任意张，给定一个整数aim代表要找的钱数，求组成aim的最少货币数
 *
 * 例子：
 * arr=[5,2,3],aim=20
 * 4张5元可以组成20元，其他的找钱方案都要使用更多张货币，所以返回4
 * arr=[5,2,3],aim=0s
 * 不用任何货币就可以组成0元，返回0
 * arr=[3,5],aim=2
 * 根本无法组成2元，钱不能召开的情况下默认返回-1
 *
 * */
public class Demo57 {

    public int minCoins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim+1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - arr[0] >= 0 && dp[0][j - arr[0]] != max) {
                dp[0][j] = dp[0][j-arr[0]]+1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j-arr[i]] + 1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }

    public int minCoins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim+1];
        for (int j = 1; j <= aim; j++) {
            dp[j] = max;
            if (j - arr[0] >= 0 && dp[j - arr[0]] != max)
                dp[j] = dp[j-arr[0]] + 1;
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] > 0 && dp[j-arr[i]] != max)
                    left = dp[j - arr[i]] + 1;
                dp[j] = Math.min(left,dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }

    public int minCoins3(int[] arr,int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
        }
        if (arr[0] <= aim)
            dp[0][arr[0]] = 1;
        int leftup = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                leftup = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    leftup = dp[i-1][j-arr[i]] + 1;
                }
                dp[i][j] = Math.min(leftup,dp[i-1][j]);
            }
        }
        return dp[n-1][aim] != max ? dp[n-1][aim] : -1;
    }

    public int minCoins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[aim + 1];
        for (int i = 1; i <= aim; i++) {
            dp[i] = max;
        }
        if (arr[0] <= aim)
            dp[arr[0]] = 1;
        int leftup = 0;
        for (int i = 1; i < n; i++) {
            for (int j = aim; j > 0; j--) {
                leftup = max;
                if (j - arr[i] >= 0 && dp[j-arr[i]] != max)
                    leftup = dp[j-arr[i]] + 1;
                dp[j] = Math.min(leftup,dp[j]);
            }
        }
        return dp[aim] != max ? dp[aim] : -1;
    }

}
