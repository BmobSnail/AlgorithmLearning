package practice;

/**
 * 剑指offer
 * 数组中重复的数字
 *
 * 题目描述:
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复
 * 的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重
 * 复的数字2
 * */
public class RepeatNumber {

    public static void main(String[] args) {
        int[] duplication = new int[7];
        boolean flag = duplicate(new int[]{2,3,1,0,2,5,3},7,duplication);
        System.out.println("result="+duplication[0]+","+flag);
    }

    private static boolean duplicate(int number[], int length, int[] duplication) {
        if (length == 0 || length == 1)
            return false;
        boolean[] tmp = new boolean[length];
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[number[i]]) {
                duplication[0] = number[i];
                return true;
            }
            tmp[number[i]] = true;
        }
        return false;
    }

}
