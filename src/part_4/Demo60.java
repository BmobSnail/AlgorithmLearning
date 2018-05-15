package part_4;

/**
 * 递归喝动态规划
 * 汉诺塔问题
 *
 * 题目：
 * 给定一个整数n，代表汉诺塔游戏中从小到大放置的n个圆盘，假设开始时所有的圆盘
 * 都放在左边的柱子上，想按照汉诺塔游戏的要求把所有的圆盘都移动到右边的柱子上。实现函数
 * 打印最优移动轨迹
 *
 * 进阶题目：
 * 给定一个整形数组arr，其中只含有1、2、3，代表所有圆盘目前的状态
 * 1代表圆盘在左柱上
 * 2代表圆盘在中柱
 * 3代表圆盘在右柱
 * 如果arr代表的状态是最优移动轨迹过程中出现的状态，返回arr这个状态是最优轨迹中的第几个状态。
 * 如果arr代表的状态不是最优移动轨迹过程中出现的状态，返回-1
 *
 * 分析：
 * 步骤一：圆盘 1~i-1 从from移动到mid
 * 步骤二：单独把圆盘i从from移动到to
 * 步骤三：把1~i-1从mid移动到to，如果圆盘只有一个，直接从from移动到to即可
 * */
public class Demo60 {

    //打印最优移动轨迹
    public void hanoi(int n) {
        if ( n > 0)
            func(n,"left","mid","right");
    }

    private void func(int n, String from, String mid, String to) {
        if (n == 1) {
            System.out.println("move from " + from + " to " + to);
        } else {
            func(n-1,from,to,mid);
            func(1,from,mid,to);
            func(n-1,mid,from,to);
        }
    }

    //找arr是最优移动轨迹中的第几步
    public int step1(int[] arr) {
        if (arr == null || arr.length == 0)
            return -1;
        return process(arr,arr.length-1,1,2,3);
    }

    public int process(int[] arr, int i, int from, int mid, int to) {
        if (i == -1)
            return 0;
        if (arr[i] != from && arr[i] != to)
            return -1;
        if (arr[i] == from) {
            return process(arr, i - 1, from, to, mid);
        } else {
            int rest = process(arr,i-1,mid,from,to);
            if (rest == -1)
                return -1;
            return (1<<i) + rest;
        }
    }

    public int step2(int[] arr) {
        if (arr == null || arr.length == 0 )
            return -1;
        int from = 1;
        int mid = 2;
        int to = 3;
        int i = arr.length - 1;
        int res = 0;
        int tmp = 0;
        while (i >= 0){
            if (arr[i] != from && arr[i] != to) {
                return -1;
            }
            if (arr[i] == to) {
                res += 1 << i;
                tmp = from;
                from = mid;
            } else {
                tmp = to;
                to = mid;
            }
            mid = tmp;
            i--;
        }
        return res;
    }
}
