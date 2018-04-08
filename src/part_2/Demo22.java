package part_2;

import java.util.Stack;

/**
 * 链表问题
 * 将单链表的每k个节点之间逆序
 *
 * 题目:
 * 给定一个单链表的头节点head,实现一个调整单链表的函数,使得每k个节点之间逆序,如果最后不够k个节点
 * 一组,则不调整最后几个节点.
 * 例如:
 * 链表" 1->2->3->4->5->6->7->8->null K=3
 * 调整后" 3->2->1-6->5->4->7->8->null .其中7,8不调整,因为不够一组.
 * */
public class Demo22 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverseKNode1(Node head, int K) {
        if (K < 2)
            return head;
        Stack<Node> stack = new Stack<>();
        Node newHead = head;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            next = cur.next;
            stack.push(cur);
            if (stack.size() == K) {
                pre = resign1(stack,pre,next);
                newHead = newHead == head ? cur : newHead;
            }
            cur = next;
        }
        return newHead;
    }

    private Node resign1(Stack<Node> stack, Node left, Node right) {
        Node cur = stack.pop();
        if (left != null)
            left.next = cur;
        Node next = null;
        while (!stack.isEmpty()) {
            next = stack.pop();
            cur.next = next;
            cur = next;
        }
        cur.next = right;
        return cur;
    }

    public Node reverseKNode2(Node head, int K) {
        if (K < 2)
            return head;
        Node cur = head;
        Node start = null;
        Node pre = null;
        Node next = null;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == K) {
                start = pre == null ? head : pre.next;
                head = pre == null ? cur : head;
                resign2(pre,start,cur,next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }

    private void resign2(Node left, Node start, Node end, Node right) {
        Node pre = start;
        Node cur = start.next;
        Node next = null;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null)
            left.next = end;
        start.next = right;
    }
}
