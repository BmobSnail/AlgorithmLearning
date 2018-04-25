package part_3;

/**
 * 二叉树问题
 * 判断t1树是否包含t2树全部的拓扑结构
 *
 * 题目:
 * 给定彼此独立的两棵树头节点分别为t1和t2,判断t1树是否包含t2树全部的拓扑接哦古.*/
public class Demo41 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean contains(Node t1, Node t2) {
        return check(t1,t2) || contains(t1.left,t2) || contains(t1.right,t2);
    }

    private boolean check(Node h, Node t2) {
        if (t2 == null)
            return true;
        if (h == null || h.value != t2.value)
            return false;
        return check(h.left,t2.left) && check(h.right,t2.right);
    }

}
