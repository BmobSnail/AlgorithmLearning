package part_2;

/**
 * 反转单向和双向链表
 *
 * 分别实现反转单向链表和反转双向链表的函数
 *
 * 要求:如果链表长度为N,时间复杂度要求为O(N),额外控件复杂度要求为O(1)
 * */
public class Demo14 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
