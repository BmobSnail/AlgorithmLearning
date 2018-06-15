package part_5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串问题
 * 公式字符串求值
 *
 * 题目：
 * 给定一个字符串str，str表示一个公式，公式里可能又整数、加减乘除符号和左右括号，
 * 返回公式的计算结果。
 *
 * 举例：
 * str="48*((70-65)-43)+8*1",返回 -1816
 * str="3+1*4",返回 7
 * str="3+(1*4)",返回 7
 * "
 * */
public class Demo86 {

    public int getValue(String exp) {
        return value(exp.toCharArray(),0)[0];
    }

    private int[] value(char[] chars, int i) {
        Deque<String> deq = new LinkedList<>();
        int pre = 0;
        int[] bra = null;
        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                pre = pre * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                addNum(deq, pre);
                deq.addLast(String.valueOf(chars[i++]));
                pre = 0;
            } else {
                bra = value(chars,i+1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(deq,pre);
        return new int[] {getNum(deq),i};
    }

    private void addNum(Deque<String> deq, int num) {
        if (!deq.isEmpty()) {
            int cur = 0;
            String top = deq.pollLast();
            if (top.equals("+") || top.equals("-")) {
                deq.addLast(top);
            } else {
                cur = Integer.valueOf(deq.pollLast());
                num = top.equals("*")?(cur*num):(cur/num);
            }
        }
        deq.addLast(String.valueOf(num));
    }

    private int getNum(Deque<String> deq) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!deq.isEmpty()) {
            cur = deq.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }


}
