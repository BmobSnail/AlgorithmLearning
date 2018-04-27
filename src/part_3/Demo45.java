package part_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树问题
 * 判断一棵二叉树是否为搜索二叉树和完全二叉树
 *
 * 题目:
 * 给定一个二叉树的头节点head,已知其中没有重复值的节点,实现两个函数分别判断
 * 这棵二叉树是否为搜索二叉树和完全二叉树
 * */
public class Demo45 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isBST(Node head) {
        if (head == null)
            return true;
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    public boolean isCBT(Node head) {
        if (head == null)
            return true;
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
                return false;
            }
            if (l != null)
                queue.offer(l);
            if (r != null)
                queue.offer(r);
            else
                leaf = true;
        }
        return true;
    }
}
