package part_4;

import java.util.HashMap;

/**
 * 递归和动态规划
 * 数组中的最长连续序列
 *
 * 题目：
 * 给定无序树arr，返回其中最长的连续序列的长度
 *
 * 举例：
 * arr=[100,4,200,1,3,2]
 * 最长的连续序列为[1,2,3,4],所以返回4
 * */
public class Demo70 {

    public int longestConsecutive(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int max = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i],1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max,merge(map,arr[i]-1,arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max,merge(map,arr[i],arr[i]+1));
                }
            }
        }
        return max;
    }

    private int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left,len);
        map.put(right,len);
        return len;
    }

}
