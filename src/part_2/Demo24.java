package part_2;

import java.util.Stack;

/**
 * 链表问题
 * 在单链表中删除指定值得节点
 *
 * 题目:
 * 给定一个链表得头节点head和一个整数num,请实现函数将值为num得节点全部删除.
 *
 * 例如:
 * 1->2->3->4->null,num=3
 * 调整后
 * 1->2->4->null
 * */
public class Demo24 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * TODO 利用栈,把非num得值压入栈,再遍历链接给head
     * */
    public Node removeValue1(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

    /**
     * TODO 直接调整,当节点值等于num就删除,链接下一个节点
     */
    public Node removeValue2(Node head, int num) {
        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
