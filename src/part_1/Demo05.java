package part_1;

import java.util.Stack;

/**
 * 栈和队列
 * 用一个栈实现另一个栈的排序
 *
 * 题目:一个栈中元素的类型为整形,线则想将该栈从顶到底按从大到校的顺序排序,
 *      只许申请一个栈.除此之外,可以申请新的变量,但不能申请额外的数据结构.如何完成排序
 *
 * 解题思路:将要排序的栈元素pop出记为cur,如果cur小于或等于help栈顶元素,则压入
 *          否则cur大于help栈顶元素,先将help逐一弹出压到原栈,直到cur小于或等于help栈顶元素,
 *          再压入help
 *
 * */

public class Demo05 {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
