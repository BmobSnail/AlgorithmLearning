package part_3;

/**
 * 二叉树问题
 * 遍历二叉树的神级方法
 *
 * 题目:
 * 给定一颗二叉树的 头节点 head,完成二叉树的先序'中序和后序遍历.如果二叉树的节点为N,
 * 要求时间复杂度为O(N),额外空间复杂度为O(1)
 * */
public class Demo35 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void morrisIn(Node head) {
        if (head == null)
            return;
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
            System.out.println(cur1.value+" ");
            cur1 = cur1.right;
        }
        System.out.println();
    }

    public void morrisPre(Node head) {
        if (head == null)
            return;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2  = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    System.out.println(cur1.value + " ");
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            } else {
                System.out.println(cur1.value + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }

    public void morrisPos(Node head) {
        if (head == null) {
            return;
        }
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
                    printEdge(cur1.left);
                }
            }
            cur1 = cur1.right;
        }
        printEdge(head);
        System.out.println();
    }

    private void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node cur = tail;
        while (cur != null) {
            System.out.println(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private Node reverseEdge(Node from) {
        Node pre = null;
        Node next  = null;
        while (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }
}
