package part_6;

/**
 * 位运算
 * 在其它数都出现偶数次的数组中找到出现奇数次的数
 *
 * 题目：
 * 给定一个整形数组arr，其中只有一个数出现了奇数次，其他的数都出现了偶数次，打印这个数.
 *
 * */
public class Demo99 {

    public void printOddTimesNum1(int[] arr) {
        int eO = 0;
        for (int cur : arr) {
            eO ^= cur;
        }
        System.out.println(eO);
    }

    public void printOddTimesNum2(int[] arr) {
        int eO = 0,eOhasOne = 0;
        for (int curNum: arr
             ) {
            eO ^= curNum;
        }
        int rightOne = eO & (~eO + 1);
        for (int cur: arr
             ) {
            if ((cur&rightOne) != 0)
                eOhasOne ^= cur;
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }
}
