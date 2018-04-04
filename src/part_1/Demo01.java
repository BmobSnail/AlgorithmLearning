package part_1;

import java.util.Stack;

/**栈和队列
 * 设计一个有getMin功能的栈
 *
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现法妞栈中最小元素的操作
 * 要求：1.pop、push、getMin操作时间复杂度都是O(1)
 *      2.设计的栈类型可以使用现场的栈结构*/

public class Demo01 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Demo01(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int num) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(num);
        } else if (num < this.getMin()) {
            this.stackMin.push(num);
        }
        this.stackData.push(num);
    }

    public int pop() {
        if (this.stackData.isEmpty())
            throw new RuntimeException("Your stack is Empty");
        int value = this.stackData.pop();
        if (value == this.getMin())
            this.stackMin.pop();
        return value;
    }

    public int getMin() {
        if (this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is Empty");
        return this.stackMin.peek();
    }
}
