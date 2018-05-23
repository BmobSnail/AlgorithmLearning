package part_4;

/**
 * 递归和动态规划
 * 排成一条线的纸牌博弈问题
 * <p>
 * 题目：
 * 给定一个整形数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B一次拿走每张纸牌，
 * 规定玩家A先拿B后拿，但每个玩家每次只能拿走最左或最右的纸牌，玩家A和B都绝对聪明。请返回获胜者的分数
 * <p>
 * 举例：
 * arr=[1,2,100,4]
 * 玩家A先拿1，arr=[2,100,4]
 * 玩家B只能拿2或4，arr=[100,4],arr=[2,100]
 * 玩家A必定拿到100
 * 返回 101
 */
public class Demo68 {

    //暴力递归 时间复杂度O(2^N) 控件复杂度O(N)
    public int win1(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    private int f(int[] arr, int i, int j) {
        if (i == j)
            return arr[i];
        return Math.max(arr[i] + s(arr, i + 1, j), arr[j] + s(arr, i, j - 1));
    }

    private int s(int[] arr, int i, int j) {
        if (i == j)
            return 0;
        return Math.min(f(arr, i + 1, j), f(arr, i, j - 1));
    }

    //动态规划
    public int win2(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int[][] f = new int[arr.length][arr.length];
        int[][] s = new int[arr.length][arr.length];
        for (int j = 0; j < arr.length; j++) {
            f[j][j] = arr[j];
            for (int i = j - 1; i >= 0; i--) {
                f[i][j] = Math.max(arr[i]+s[i+1][j],arr[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return Math.max(f[0][arr.length-1],s[0][arr.length-1]);
    }
}
