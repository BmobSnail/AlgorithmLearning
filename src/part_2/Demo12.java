package part_2;

/**
 * 链表问题
 * 在单链表和双链表中删除倒数第k个节点
 *
 * 题目:分别实现两个函数,一个可以删除单链表中倒数第k个节点,另一个可以删除双链表中倒数第K个节点
 * 要求:如果长度为N,时间复杂度达到O(N),额外空间复杂度达到O(1)
 * */

public class Demo12 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node removeLastNode(Node head, int last) {
        if (head == null || last < 1)
            return head;
        Node cur = head;
        while (cur != null) {
            last--;
            cur = cur.next;
        }
        if (last == 0)
            head = head.next;
        if (last < 0) {
            cur = head;
            while (++last != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
