package part_4;

/**
 * 递归喝动态规划
 * 最大递增子序列
 *
 * 题目：
 * 给定数组arr，返回arr的最长递增子序列
 *
 * 举例：
 * arr=[2,1,5,3,6,4,8,9,7]  返回的最长递增子序列为]1,3,4,8,9]
 *
 * 要求：
 * 如果arr长度为N，请实现时间复杂度为O(NlogN)的方法
 * */

public class Demo59 {

    //从数组中标记每个数组能组成最长的子序列
    private int[] getdp1(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    //从dp数组中还原决策路径的过程
    private int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] &&
                    dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    //O(N^2)的方法
    public int[] list1(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        int[] dp = getdp1(arr);
        return generateLIS(arr, dp);
    }


    private int[] getdp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[i]) {
                    l = m + 1;

                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, -1);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    public int[] list2 (int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        int[] dp = getdp2(arr);
        return generateLIS(arr,dp);
    }
}