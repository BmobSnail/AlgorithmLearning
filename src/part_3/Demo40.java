package part_3;

import java.util.Stack;

/**
 * 二叉树问题
 * 调整搜索二叉树中两个错误的节点
 *
 * 题目:
 * 一颗二叉树原本是搜索二叉树,但是其中有两个节点调换了位置,使得这颗二叉树不再是搜索二叉树,
 * 请找到这两个错误节点并返回已知二叉树中所有节点的值都不一样,给定二叉树的头节点head,返回一个长度为2
 * 的二叉树节点类型的数组errs,errs[0]表示一个错误节点,errs[1]表示另一个错误节点.
 *
 * 进阶:
 * 如果再原问题中得到了这两个错误节点,我们当然可以通过交换两个节点的节点值的方式让整棵二叉树
 * 重新成为搜索二叉树.但现在要求你不能这么做,而是在结构上完全交换两个节点的位置,清实现调整的函数
 * */
public class Demo40 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node[] getTwoErrorNodes(Node head) {
        Node[] errs = new Node[2];
        if (head == null)
            return errs;
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre != null && pre.value > head.value) {
                    errs[0] = errs[0] == null ? pre : errs[0];
                    errs[1] = head;
                }
                pre = head;
                head = head.right;
            }
        }
        return errs;
    }

}
