package part_3;

/**
 * 二叉树问题
 * 如何较为直观地打印二叉树
 *
 * 题目:
 * 二叉树可以用常规的三种遍历结果来描述其结构,但是不够直观,尤其是二叉树中有重复值的时候,
 * 仅通过三种遍历大的结构来构造二叉树的真是结构更是难上加难,有时则根本不可能.给定一棵二叉树
 * 的头节点head,已知二叉树节点值得类型为32位整形,请实现一个打印二叉树得函数,可以直观地展示树
 * 得形状,也便于画出真是得结构
 * */
public class Demo33 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head,0,"H",17);
        System.out.println();
    }

    private void printInOrder(Node head, int height, String to, int len) {
        if (head == null)
            return;
        printInOrder(head.right,height+1,"v",len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left,height+1,"^",len);
    }

    private String getSpace(int num) {
        String space = " ";
        StringBuilder buf = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
