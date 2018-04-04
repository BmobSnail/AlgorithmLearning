package part_1;

import java.util.LinkedList;

/**
 * 栈和队列
 * 生成窗口最大值数组
 *
 *  [4 3 5] 4 3 3 6 7       窗口最大值5
 *  4 [3 5 4] 3 3 6 7       窗口最大值5
 *  4 3 [5 4 3] 3 6 7       窗口最大值5
 *  4 3 5 [4 3 3] 6 7       窗口最大值4
 *  4 3 5 4 [3 3 6] 7       窗口最大值6
 *  4 3 5 4 3 [3 6 7]       窗口最大值7
 *
 *  如果数组长度为n,窗口大小为w,则一共产生n-w+1个窗口的最大值
 *  请实现一个函数:
 *      输入整形数组arr,窗口大小为w
 *      输出一个长度为n-w+1的数组res,res[i]表示为每一种窗口状态下的最大值
 *
 *  以本题为例,结果应输出[5,5,5,4,6,7]
 * */

public class Demo07 {

    public int[] getMaxOfWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
