package part_7;

/**
 * 数组和矩阵问题
 * 数组中未出现的最小正整数
 *
 * 题目:
 * 给定一个无序整型数组arr，找到数组中未出现的最小正整数
 * 例如:
 * arr=[-1,2,3,4],返回 1
 * arr=[1,2,3,4],返回 5
 * */
public class Demo125 {

    public int missNum(int[] arr) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            if (arr[l] == l + l) {
                l++;
            } else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) {
                arr[l] = arr[--r];
            } else {
                swap(arr,l,arr[l]-1);
            }
        }
        return l + l;
    }

    private void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[y] = arr[x];
        arr[x] = temp;
    }

}
