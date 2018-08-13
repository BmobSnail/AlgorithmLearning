package part_7;

/**
 * 数组和矩阵问题
 * 奇数下标都是奇数或者偶数下标都是偶数
 *
 * 题目：
 * 给定一个长度不小于2的数组arr，实现一个函数偶数调整arr，要么让所有的偶数下标都是
 * 偶数，要么让所有的奇数下标都是奇数
 *
 * 要求：
 * 如果arr的长度为N，函数要求世家复杂度为O(N)，额外控件复杂度为O(1)
 * */
public class Demo115 {

    public void modify(int[] arr) {
        if (arr == null || arr.length == 0)
            return;
        int event = 0;
        int odd = 1;
        int end = arr.length - 1;
        while (event <= end && odd <= end) {
            if ((arr[end] & 1) == 0) {
                swap(arr,end,event);
                event+=2;
            } else {
                swap(arr,end,odd);
                odd += 2;
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

}
