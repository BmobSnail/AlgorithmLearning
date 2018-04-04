package part_1;

import java.util.Stack;

/**栈和队列
 * 由两个栈堆成的队列
 *
 * 题目：编写一个类，用两个栈实现队列，支持队列的基本操作(add、poll、peek)
 *
 * 解题思路：栈的特点是先进后出，队列是先进先出*/

public class Demo02 {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public Demo02() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int num) {
        stackPush.push(num);
    }

    public int poll() {
        swapData();
        return stackPop.pop();
    }

    public int peek() {
        swapData();
        return stackPop.peek();
    }

    private void swapData() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }


}
