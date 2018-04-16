package part_3;

import java.util.Stack;

/**
 * 二叉树问题
 * 分别用递归和非递归方式实现二叉树先序,中序和后序遍历
 *
 * 题目:
 * 用递归和非递归方式i,分别按照二叉树先序,中序,后序打印所有的节点.
 * 我们约定
 * 先序遍历顺序为 根'左'右
 * 中序遍历顺序为 左'根'右
 * 后序遍历顺序为 左'右'根
 * */
public class Demo31 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 先序递归遍历
     */
    public void preOrderRecur(Node head) {
        if (head == null)
            return;
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public void preOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 中序递归遍历
     */
    public void inOrderRecur(Node head) {
        if (head == null)
            return;
        inOrderRecur(head.left );
        System.out.println(head.value + " ");
        inOrderRecur(head.right);
    }

    public void inOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.value + " ");
                    head = head.right;
                }
            }
        }
    }


    /**后序递归遍历*/
    public void posOrderRecur(Node head) {
        if (head == null)
            return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + " ");
    }

    public void posOrderUnRecur(Node head) {
        if (head != null) {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().value + " ");
            }
        }
    }
}

