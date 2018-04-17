package practice;

/**
 * 剑指offer
 * 旋转数组的最小数字
 *
 * 题目:
 * 把一个数组最开始的若干个元素搬到数的末尾,我们称之为数组的旋转.输入一个非递减排序的数组的
 * 一个旋转,输出旋转数组的最小元素.例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转,该数组的最小值为1.
 * NOTE:给出的所有元素都大于0,若数组大小为0,请返回0
 * */
public class RotateMinNum {

    public static void main(String[] args) {
        int num = minNumberInRotateArray(new int[]{3,4,5,1,2});
        System.out.println(num);
    }

    private static int minNumberInRotateArray(int[] array) {
        if (array.length == 0)
            return 0;
        int left = 0, mid = 0, right = array.length - 1;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left)/2;
            if (array[left] == array[right]
                    && array[left] == array[mid]) {
                return minOrder(array,left,right);
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }

    private static int minOrder(int[] array, int left, int right) {
        int result = array[left];
        for (int i = left + 1; i < right; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }
}
