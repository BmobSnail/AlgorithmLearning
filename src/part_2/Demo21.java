package part_2;

/**
 * 链表问题
 * 两个单链表相交的一系列问题
 *
 * 题目:
 * 在本题中,单链表可能有环,也可能无环.给定两个单链表的头节点head1和head2,这两个链表可能
 * 相交,也可能不相交.请实现一个函数,如果两链表相交,请返回相交的第一个节点,如果不相交,返回null
 *
 * 要求:
 * 如果链表1的长度为N,链表2的长度为M,时间复杂度请达到O(M+N),额外控件复杂度请达到O(1)
 *
 * 解题思路:
 * 比如难题可以拆分成三个子问题,每个问题都可以作为一个独立的算法题,具体如下:
 * 1.如何判断一个链表是否有环,如果有,则返回第一个进入环的节点,没有则返回null
 * 2.如何判断两个无环链表是否相交,相交则返回第一个相交节点,不相交则返回null
 * 3.如何判断两个有环链表是否相交,相交则返回第一个相交节点,不相交则返回null
 *
 * 注意:如果一个链表有环,另一个链表无环,它门时不可能相交,直接返回null*/
public class Demo21 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == null && loop2 == null)
            return nLoop(head1,head2);
        if (loop1 != null && loop2 != null)
            return bothLoop(head1,loop1,head2,loop2);
        return null;
    }

    private Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if(n2.next == null || n2.next.next == null)
                return null;
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    private Node nLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    private Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}
