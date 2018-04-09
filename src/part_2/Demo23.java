package part_2;

import java.util.HashSet;

/**
 * 链表问题
 * 删除无序单链表中值重复出现的节点
 *
 * 题目:
 * 给定一个无序单连的头节点head,删除其中值重复出现的节点
 *
 * 例如:
 * 1->2->3->3->4->4->2->1->1->1->null
 * 删除重复节点后1->2->3->4->null
 *
 * 要求:
 * 方法1,如果链表长度为N,时间复杂度达到O(N)
 * 方法2,额外空间复杂度为O(1)*/
public class Demo23 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value =value;
        }
    }

    /**
     * TODO 利用Hash存,检测到之前有同样的值就不存
     * */
    public void removeRep1(Node head) {
        if (head == null)
            return;
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while (cur != null) {
            if (set.contains(cur.value)) {
                pre.next = cur.next;
            } else {
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }

    /**
     * TODO 每个节点都全遍历一次,删除相同值得节点
     * */
    public void removeRep2(Node head) {
        Node cur = head;
        Node pre = null;
        Node next = null;
        while (cur != null) {
            pre = cur;
            next = cur.next;
            while (next != null) {
                if (cur.value == next.value) {
                    pre.next = next.next;
                } else {
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
