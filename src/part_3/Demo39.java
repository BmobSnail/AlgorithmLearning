package part_3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树问题
 * 二叉树的按层打印与ZigZag打印
 *
 * 题目:
 * 给定一颗二叉树头节点head,分别实现按层打印和ZigZag打印二叉树的函数
 * */
public class Demo39 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printByLevel(Node head) {
        if (head == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        Node last = head;
        Node nLast = null;
        queue.offer(head);
        System.out.print("Level " + (level++) + "-->:");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value+" ");
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel "+(level++)+"-->:");
                last = nLast;
            }
        }
        System.out.println();
    }

    public void printByZigZag(Node head) {
        if (head == null)
            return;
        Deque<Node> dq = new LinkedList<>();
        int level = 1;
        boolean lr = true;
        Node last = head;
        Node nLast = null;
        dq.offerFirst(head);
        printLevelAndOrientation(level++,lr);
        while (!dq.isEmpty()) {
            if (lr) {
                head = dq.pollFirst();
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dq.offerLast(head.left);
                }
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dq.offerLast(head.right);
                }
            } else {
                head = dq.pollLast();
                if (head.right != null) {
                    nLast = nLast == null ? head.right : nLast;
                    dq.offerFirst(head.right);
                }
                if (head.left != null) {
                    nLast = nLast == null ? head.left : nLast;
                    dq.offerFirst(head.left);
                }
            }
            System.out.print(head.value + " ");
            if (head == last && !dq.isEmpty()) {
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelAndOrientation(level++,lr);
            }
        }
    }

    private void printLevelAndOrientation(int level, boolean lr) {
        System.out.print("Level "+level+" from ");
        System.out.print(lr ? "left to right: ":"right to left: ");
    }
}
