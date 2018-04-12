package part_2;

/**
 * 链表问题
 * 合并两个有序的单链表
 *
 * 题目:
 * 给定两个有序单链表的头节点head1和head2,请合并两个有序链表,合并后的链表依然
 * 有序,并返回合并后链表的头节点
 *
 * 例如:
 * 0->2->3->7->null
 * 1->3->5->7->9->null
 * 合并:0->1->2->3->3->5->7->7->9->null
 *
 * */
public class Demo29 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node merge(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return head1 != null ? head1 : head2;
        Node head = head1.value < head2.value ? head1 : head2;
        Node cur1 = head == head1 ? head1 : head2;
        Node cur2 = head == head1 ? head2 : head1;
        Node pre = null;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.value <= cur2.value) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
