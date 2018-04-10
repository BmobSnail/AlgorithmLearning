package part_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 链表问题
 * 将搜索二叉树转换成双向链表
 *
 * 题目:
 * 对二叉树的节点来说,有本事的值域,有指向左孩子和右孩子的两个指针;对双向链表的节点来说,
 * 有本身的值域,有指向上一个节点和下一个节点的指针.在结构上,两种结构有相似性,现在有一颗
 * 搜索二叉树,请将其转换为一个有序的双向链表.*/
public class Demo25 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**用队列收集二叉树中序遍历结果*/
    public Node convert1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        inOrderToQueue(head,queue);
        if (queue.isEmpty())
            return head;
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    private void inOrderToQueue(Node head, Queue<Node> queue) {
        if (head == null)
            return;
        inOrderToQueue(head.left,queue);
        queue.offer(head);
        inOrderToQueue(head.right,queue);
    }

    /**用递归函数*/
    public Node convert2(Node head) {
        if (head == null)
            return null;
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }

    private Node process(Node head) {
        if (head == null)
            return null;
        Node leftE = process(head.left);//左边结束
        Node rightE = process(head.right);//右边结束
        Node leftS = leftE != null ?leftE.right:null;//左边开始
        Node rightS = rightE != null ? rightE.right : null;//右边开始
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        } else if (rightE != null) {
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }
}
