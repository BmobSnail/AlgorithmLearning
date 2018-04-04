package practice;

import java.util.ArrayList;

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

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> mData = new ArrayList<>();
        listNode = reverseNode(listNode);
        while (listNode != null) {
            int value = listNode.value;
            System.out.println(value);
            mData.add(value);
            listNode = listNode.next;
        }
        return mData;
    }

    public static ListNode reverseNode(ListNode node){
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
