package part_7;

/**
 * 数组和矩阵问题
 * 自然数数组的排序
 *
 * 题目：
 * 给定一个长度为N的整形数组arr，其中又n个互不相等1~N,请实现arr的排序，
 * 但是不要把下标0~N-1位置上的数通过直接赋值的方式替换成1~N-1.
 * */
public class Demo114 {

    public void sort1(int[] arr) {
        int temp;
        int next;
        for (int i = 0; i != arr.length; i++) {
            temp = arr[i];
            while (arr[i] != i + 1) {
                next = arr[temp - 1];
                arr[temp - 1] = temp;
                temp = next;
            }
        }
    }

    public void sort2(int[] arr) {
        int temp;
        for (int i = 0; i != arr.length; i++) {
            while (arr[i] != i + 1) {
                temp = arr[arr[i] - 1];
                arr[arr[i]- 1] = arr[i];
                arr[i] = temp;
            }
        }
    }

}
