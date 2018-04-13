package practice;

/**
 * 剑指offer
 * 删除链表中重复的节点
 *
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5
 * 处理后为 1->2->5
 *
 */
public class DeleteRepeatNode {

    private static class ListNode{
        public int value;
        public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next.next = new ListNode(5);
        node = deleteDuplication(node);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    private static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode cur = null;
        if (pHead.next.value == pHead.value) {
            cur = pHead.next.next;
            while (cur != null && cur.value == pHead.value) {
                cur = cur.next;
            }
            return deleteDuplication(cur);
        } else {
            cur = pHead.next;
            pHead.next = deleteDuplication(cur);
            return pHead;
        }
    }
}
