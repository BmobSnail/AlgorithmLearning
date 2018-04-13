package practice;

/**
 * 剑指offer
 * 反转链表
 *
 * 题目描述
 * 输入一个链表，反转链表后，输出链表的所有元素
 * */
public class PrintReverseNode {

    public static class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(67);
        node.next = new ListNode(0);
        node.next.next = new ListNode(24);
        node.next.next.next = new ListNode(58);
        printListFromTailToHead(node);
    }

    private static void printListFromTailToHead(ListNode listNode) {
        listNode = reverseNode(listNode);
        while (listNode != null) {
            int value = listNode.value;
            System.out.println(value);
            listNode = listNode.next;
        }
    }

    private static ListNode reverseNode(ListNode node){
        ListNode pre = null;
        ListNode cur = null;
        while (node != null) {
            cur = node.next;
            node.next = pre;
            pre = node;
            node = cur;
        }
        return pre;
    }
}
