package part_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树问题
 * 二叉树得序列化和反序列化
 *
 * 题目:
 * 二叉树被记录成文件得过程叫做二叉树得序列化,通过文件内容重建原来二叉树得过程
 * 叫做二叉树得反序列化.给定一颗二叉树得头节点head,并已知二叉树节点值得类型为
 * 32位整形.请设计一种二叉树序列化和反序列化得方案,并用代码实现
 * */
public class Demo34 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //先序遍历序列化
    public String serialByPre(Node head) {
        if (head == null)
            return "#!";
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    //先序遍历得反序列化
    public Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#"))
            return null;
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    //层遍历实现序列化和反序列化
    public String serialByLevel(Node head) {
        if (head == null)
            return "#!";
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }
            if (head.right != null) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    public Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    private Node generateNodeByString(String val) {
        if (val.equals("#"))
            return null;
        return new Node(Integer.valueOf(val));
    }
}
