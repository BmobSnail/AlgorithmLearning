package part_3;

/**
 * 二叉树问题
 * 统计完全二叉树的节点数
 *
 * 题目：
 * 给定一棵完全二叉树的头节点head，返回这棵树的节点个数
 * */
public class Demo54 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int nodeNum(Node head) {
        if (head == null)
            return 0;
        return bs(head,1,mostLeftLevel(head,1));
    }

    private int bs(Node node, int l, int h) {
        if ( l == h)
            return 1;
        if (mostLeftLevel(node.right,l+1) == h)
            return (1<<(h-l)) + bs(node.right,l+1,h);
        else
            return (1<<(h-l-1)) + bs(node.left,+1,h);
    }

    private int mostLeftLevel(Node node, int level) {
        while (node != null){
            level++;
            node = node.left;
        }
        return level-1;
    }

}
