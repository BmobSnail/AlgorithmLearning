package part_7;

/**
 * 数组和矩阵问题
 * 不重复打印排序数组种相加和为给定值的所有二元组和三元组
 *
 * 题目：
 * 给定排序数组arr和整数k，不重复打印arr中所有相加和为k的不降序二元组。
 * 例如，arr=[-8,-4,-3,0,1,2,3,4,5,8,9],k=10,打印结果为
 * 1,9
 * 2,8
 *
 * 补充题目：
 * 给定排序狐族arr和整数k，不重复打印arr中所有相加和为k的不降序三元组。
 * 例如，arr=[-8,-4,-3,0,1,2,3,4,5,8,9],k=10,打印结果为
 * -,4,5,9
 * -3,4,9
 * -3,5,8
 * 0,1,9
 * 0,2,8
 * 1,4,5
 * */
public class Demo109 {

    public void printUniquePair(int[] arr, int k) {
        if (arr == null || arr.length < 2)
            return;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                if (left == 0 || arr[left - 1] != arr[left]) {
                    System.out.println(arr[left] + "," + arr[right]);
                }
                left++;
                right--;
            }
        }
    }

    public void printUniqueTriad(int[] arr, int k) {
        if (arr == null || arr.length < 3)
            return;
        for (int i=0; i < arr.length-2;i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                printRest(arr,i,i+1,arr.length-1,k-arr[i]);
            }
        }
    }

    private void printRest(int[] arr, int f, int l, int r, int k) {
        while (l < r) {
            if (arr[l] + arr[r] < k) {
                l++;
            } else if (arr[l] + arr[r] > k) {
                r--;
            } else {
                if (l == f + 1 || arr[l - 1] != arr[l]) {
                    System.out.println(arr[f] + "," + arr[l] + ","+arr[r]);
                }
                l++;
                r--;
            }
        }
    }
}
