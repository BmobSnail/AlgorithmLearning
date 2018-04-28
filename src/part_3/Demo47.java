package part_3;

/**
 * 二叉树问题
 * 在二叉树中找到一个节点的后继节点
 *
 * 题目:
 * 现有一种新的二叉树节点类型如下:
 * public class Node{
 *     int value;
 *     Node left;
 *     Node right;
 *     Node parent;
 * }
 *
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针.假设有一颗Node类型的节点组成的二叉树,
 * 树中每个节点的parent指针都正确地指向自己的父节点,头节点的parent指向null.只给一个在二叉树中的某
 * 个节点node,请实现返回node的后继节点的函数.在二叉树的中序遍历的序列中,node的下一个节点叫做node的后继节点
 * */
public class Demo47 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getNextNode(Node node) {
        if (node == null)
            return node;
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private Node getLeftMost(Node node) {
        if (node == null)
            return node;
        while (node.left != null) {
            node = node.left;
        }
        return node;

    }

}
