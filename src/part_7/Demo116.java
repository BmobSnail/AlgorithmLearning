package part_7;

/**
 * 数据和矩阵问题
 * 子数组得最大累加和问题
 *
 * 题目：
 * 给定一个数组arr，返回子数组得最大累加和。
 * 例如，arr=[1,-2,3,5,-2,6,-1],所有的子数组中，[3,5,-2,6]可以累加出最大
 * 的和12，所以返回12
 * */
public class Demo116 {

    public int maxSun(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i != arr.length; i++) {
            cur += arr[i];
            max = Math.max(max,cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }

}
