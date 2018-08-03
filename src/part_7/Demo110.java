package part_7;

/**
 * 数组和矩阵问题
 * 未排序正数数组中累加和为给定值的最长子数组长度
 *
 * 题目：
 * 给定一个数组arr，该数组无序，但每个值均为整数，再给定一个整数k，求arr的所有
 * 子数组中所有元素相加和为k的最长子数组长度。
 * 例如：arr=[1,2,1,1,1],k=3
 * 累加和为3的最长子数组为[1,1,1],所有结果返回3
 * */
public class Demo110 {

    public int getMaxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len,right-left+1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length)
                    break;
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }

}
