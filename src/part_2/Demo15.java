package part_2;

/**
 * 链表问题
 * 反转部分单向链表
 *
 * 给定一个单向链表的头节点head,以及两个整数from和to,在单向链表上把第from到to个节点这部分反转
 *
 * eg:
 * 1 -> 2 -> 3 -> 4 -> 5 -> null ,from=2, to=4
 * 调整结果为:1 -> 4 -> 3 -> 2 -> 5 -> null
 *
 * 要求:
 * 1.如果链表长度为N,时间复杂度要求为O(N),额外空间复杂度要求为O(1)
 * 2.如果不满足 1<= from <= to <= N,则不用调整
 * */
public class Demo15 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while (node1 != null) {
            len++;
            fPre = len == from - 1 ? node1 : fPre;
            tPos = len == to + 1 ? node1 : tPos;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len) {
            return head;
        }
        node1 = fPre == null ? head : fPre.next;
        Node node2 = node1.next;
        node1.next = tPos;
        Node next = null;
        while (node2 != tPos) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
