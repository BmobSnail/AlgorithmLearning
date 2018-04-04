package part_1;

import java.util.Stack;

/**
 * 栈和队列
 * 如何引用递归函数和栈操作逆序一个栈
 *
 * 题目:一个栈一次压入1,2,3,4,5,那么从栈顶到栈底分别为5,4,3,2,1.
 *      将这个栈转置后,从栈顶到栈底位1,2,3,4,5,也就是实现栈中元素的逆序,
 *      但是只能用递归函数来实现,不能用其它数据结构
 *
 * 解题思路:先将栈stack的栈底元素返回并移除,然后依次再压入
 * */

public class Demo03 {

    private int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
