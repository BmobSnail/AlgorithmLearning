package part_2;

/**
 * 链表问题
 *
 * 删除链表中间节点和 a/b 处的节点
 *
 * 题目:给定链表的头节点head,实现删除链表的中间节点的函数*/
public class Demo13 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }


    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b)
            return head;
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a*n)) / (double)b);
        if (n == 1)
            head = head.next;
        if (n > 1) {
            cur = head;
            while (--n != 1)
                cur = cur.next;
            cur.next = cur.next.next;
        }
        return head;
    }

}
