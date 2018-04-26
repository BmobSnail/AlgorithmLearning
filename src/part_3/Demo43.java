package part_3;

/**
 * 二叉树问题
 * 判断二叉树是否为平衡二叉树
 *
 * 题目:
 * 平衡二叉树的性质为:要么是一棵空树,要么任何一个节点的左右子树高度差的绝对值
 * 不超过1.给定一棵二叉树的头节点head,判断这棵二叉树是否为平衡二叉树
 * */
public class Demo43 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isBalance(Node head) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHeight(head,1,res);
        return res[0];
    }

    private int getHeight(Node head, int level, boolean[] res) {
        if (head == null)
            return level;
        int lH = getHeight(head.left,level+1,res);
        if (!res[0])
            return level;
        int rH = getHeight(head.right,level+1,res);
        if (!res[0])
            return level;
        if (Math.abs(lH - rH) > 1)
            res[0] = false;
        return Math.max(lH,rH);
    }

}
