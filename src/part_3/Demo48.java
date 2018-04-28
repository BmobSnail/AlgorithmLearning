package part_3;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 二叉树问题
 * 在二叉树中找到两个节点的最近公共祖先
 *
 * 题目:
 * 给定一棵二叉树的头节点head,以及这棵树中的两个节点o1,o2 请返回它们的最近公共祖先节点
 * */
public class Demo48 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node lowestAncestor(Node head, Node o1, Node o2) {
        if (head == null || head == o1 || head == o2) {
            return head;
        }
        Node left = lowestAncestor(head.left,o1,o2);
        Node right = lowestAncestor(head.right,o1,o2);
        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;
    }

    public static class Recode1{
        private HashMap<Node,Node> map;

        public Recode1(Node head) {
            map = new HashMap<>();
            if (head != null)
                map.put(head,null);
            setMap(head);
        }

        private void setMap(Node head) {
            if (head == null)
                return;
            if (head.left != null)
                map.put(head.left,head);
            if (head.right != null)
                map.put(head.right,head);
            setMap(head.left);
            setMap(head.right);
        }

        public Node query(Node o1,Node o2) {
            HashSet<Node> path = new HashSet<>();
            while (map.containsKey(o1)) {
                path.add(o1);
                o1 = map.get(o1);
            }
            while (!path.contains(o2)) {
                o2 = map.get(o2);
            }
            return o2;
        }
    }

    public static class Record2{
        private HashMap<Node,HashMap<Node,Node>> map;

        public Record2(Node head) {
            map = new HashMap<>();
            initMap(head);
            setMap(head);
        }

        private void initMap(Node head) {
            if (head == null)
                return;
            map.put(head,new HashMap<>());
            initMap(head.left);
            initMap(head.right);
        }

        private void setMap(Node head) {
            if (head==null)
                return;
            headRecord(head.left,head);
            headRecord(head.right,head);
            subRecord(head);
            setMap(head.left);
            setMap(head.right);
        }

        private void headRecord(Node n, Node h) {
            if (n == null)
                return;
            map.get(n).put(h,h);
            headRecord(n.left,n);
            headRecord(n.right,h);
        }

        private void subRecord(Node head) {
            if (head == null)
                return;
            preLeft(head.left,head.right,head);
            subRecord(head.left);
            subRecord(head.right);
        }

        private void preLeft(Node l, Node r, Node h) {
            if (l == null)
                return;
            preRight(l,r,h);
            preLeft(l.left,r,h);
            preLeft(l.right,r,h);
        }

        private void preRight(Node l, Node r, Node h) {
            if (r == null)
                return;
            map.get(l).put(r,h);
            preRight(l,r.left,h);
            preRight(l,r.right,h);
        }

        public Node query(Node o1, Node o2) {
            if (o1 == o2)
                return o1;
            if (map.containsKey(o1))
                return map.get(o1).get(o2);
            if (map.containsKey(o2))
                return map.get(o2).get(o1);
            return null;
        }
    }

}
