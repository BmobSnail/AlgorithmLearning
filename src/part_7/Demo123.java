package part_7;

/**
 * 数组和矩阵问题
 * 数组的partition调整
 *
 * 题目：
 * 给定一个有序数组arr，调整arr使得中国数组的左半部分没有重复元素
 * 且升序，而不用保证右半部分是否有序。
 *
 * 例如，arr=[1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9]
 * 调整后 arr=[1,2,3,4,5,6,7,8,9,...]
 *
 *
 * 补充题目：
 * 给定一个数组arr，其中只可能含有0、1、2三个值，请实现arr的排序。
 * 另一种问法为：有一个数组，其中只有红、蓝、黄球，请实现红球全放在
 * 数组的左边，篮球放在中间，黄球放在右边。
 * 另一种问法为：有一个数组，再给定一个值k，请实现比k小的数都在数组的左边，
 * 等于k的数都放在数组的中间，比k大的数都放在数组的右边。
 * */
public class Demo123 {

    public void leftUnique(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int u = 0;
        int i = 1;
        while (i != arr.length) {
            if (arr[i++] != arr[u]) {
                swap(arr,++u,i-1);
            }
        }
    }

    private void swap(int[] arr, int cur, int target) {
        int temp = arr[cur];
        arr[cur] = target;
        arr[target] = temp;
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int left = -1;
        int index = 0;
        int right = arr.length;
        while (index < right) {
            if (arr[index] == 0) {
                swap(arr,++left,index++);
            } else if (arr[index] == 2) {
                swap(arr, index, --right);
            } else {
                index++;
            }
        }
    }

}
