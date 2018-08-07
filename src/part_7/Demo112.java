package part_7;

/**
 * 数组和矩阵问题
 * 未排序数组中累加和小于或等于给定值的最长子数组长度
 *
 * 题目：
 * 给定一个无序数组arr，其中元素可正、可负、可0.给定一个整数k，求arr所有的子数组
 * 中累加和小于或等于k的最长子数组长度
 * 例如：arr=[3,-2,4,0,6],k=2 相机和小于或等于-2的最长子数组为{3,-2,-4,0},所以返回4
 * */
public class Demo112 {

    public int maxLength(int[] arr, int k) {
        int[] h = new int[arr.length + 1];
        int sum = 0;
        h[0] = sum;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            h[i + 1] = Math.max(sum,h[i]);
        }
        sum = 0;
        int res = 0;
        int pre = 0;
        int len = 0;
        for (int i = 0; i != arr.length; i++) {
            sum += arr[i];
            pre = getLessIndex(h,sum - k);
            len = pre == -1 ? 0 : i - pre + 1;
            res = Math.max(res,len);
        }
        return res;
    }

    private int getLessIndex(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        int res = -1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] >= num) {
                res = mid;
                high = mid - 1;
            }else
                low = mid + 1;
        }
        return res;
    }
}
