package part_7;

import java.util.HashMap;

/**
 * 数组和矩阵问题
 * 未排序数组中累加和为给定值的最长子数组系列问题
 *
 * 题目：
 * 给定一个无序数组arr，其中元素可正、可负、可0，给定一个整数k，求arr所有的
 * 子数组中累加和为k的最长子数组长度。
 *
 * */
public class Demo111 {

    public int maxLength(int[] arr, int k) {
        if(arr==null || arr.length == 0)
            return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k))
                len = Math.max(i - map.get(sum - k),len);
            if (!map.containsKey(sum))
                map.put(sum,i);
        }
        return len;
    }
}
