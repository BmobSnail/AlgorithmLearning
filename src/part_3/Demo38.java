package part_3;

/**
 * 二叉树问题
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 *
 * 题目:
 * 给定一颗二叉树的头节点head,已知所有节点的值都不一样,返回其中最大的且符合搜索二叉树条件的最大拓扑结构的大小
 * */
public class Demo38 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int bstTopoSize1(Node head) {
        if (head == null)
            return 0;
        int max = maxTopo(head,head);
        max = Math.max(bstTopoSize1(head.left),max);
        max = Math.max(bstTopoSize1(head.right),max);
        return max;
    }

    private int maxTopo(Node h, Node n) {
        if (h != null && n != null && isBSTNote(h, n.right,n.value)) {
            return maxTopo(h,n.left) + maxTopo(h,n.right) + 1;
        }
        return 0;
    }

    public boolean isBSTNote(Node h, Node n, int value) {
        if (h == null)
            return false;
        if (h == n)
            return true;
        return isBSTNote(h.value > value ? h.left : h.right,n,value);
    }
}
