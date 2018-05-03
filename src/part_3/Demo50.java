package part_3;

/**
 * 二叉树问题
 * 二叉树节点间最大距离问题
 *
 * 题目：
 * 从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，当到达节点B时，路径上的节点数叫做
 * 节点A到节点B的距离。
 * */
public class Demo50 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int maxDistance(Node head) {
        int[] record = new int[1];
        return posOrder(head,record);
    }

    private int posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            return 0;
        }
        int lMax = posOrder(head.left,record);
        int maxFromLeft = record[0];
        int rMax = posOrder(head.right,record);
        int maxFromRight = record[0];
        int curNodeMax = maxFromLeft + maxFromRight + 1;
        record[0] = Math.max(maxFromLeft,maxFromRight) + 1;
        return Math.max(Math.max(lMax,rMax),curNodeMax);
    }
}
