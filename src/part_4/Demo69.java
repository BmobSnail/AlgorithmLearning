package part_4;

/**
 * 递归和动态规划
 * 跳跃游戏
 *
 * 题目：
 * 给定数组arr，arr[i]==k代表可以从位置i向右跳1~k个举例。比如，
 * arr[2]==3，代表从位置2可以跳到位置3、位置4或位置5.如果从位置0出发，
 * 返回最少跳几次能跳到arr最后的位置上
 *
 * 举例：
 * arr=[3,2,3,1,1,4]
 * arr[0]==3,选择跳到位置2；
 * arr[2]==3,可以跳到最后的位置，所以返回2
 *
 * */
public class Demo69 {

    public int jump(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int jump = 0;
        int cur = 0;
        int next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {
                jump++;
                cur = next;
            }
            next = Math.max(next,i+arr[i]);
        }
        return jump;
    }

}
