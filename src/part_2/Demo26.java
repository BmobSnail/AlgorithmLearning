package part_2;

/**
 * 链表问题
 * 单链表的选择排序
 *
 * 题目:
 * 给定一个无序单链表的头节点head,实现单链表的选择排序
 * 要求:额外的空间复杂度为O(1)
 * */
public class Demo26 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node selectionSort(Node head) {
        Node tail = null;//排序部分尾部
        Node cur = head;//未排序部分头部
        Node smallPre = null;//最小节点的前一个节点
        Node small = null;//最小的节点
        while (cur != null) {
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur == small ? cur.next : cur;
            if (tail == null)
                head = small;
            else
                tail.next = small;
            tail = small;
        }
        return head;
    }

    private Node getSmallestPreNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
