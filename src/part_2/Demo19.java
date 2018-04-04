package part_2;

import java.util.HashMap;

/**
 * 链表问题
 * 复制含有随机指针节点的链表
 *
 * Node类中的value是节点值,next指针和正常单链表中next指针的意思一样,
 * 都指向下一个节点,rand指针是Node类中新增的指针,这个指针可能之下链表中
 * 的任意一个节点,也可能指向null.
 *
 * 给定一个Node节点类型组成的无环单链表的头节点head,请实现一个函数完成这个链表
 * 中所有结构的复制,并返回复制的新链表的头节点.
 *
 * 例如:1->2->3->null
 * 假设1的rand指针指向3,2的rand指针指向null,3的rand指针指向1.复制后的链表应用是这样
 * 1'->2'->3'->null
 * 1'的rand指针指向3',2'的rand指针指向null,3'的rand指针指向1',最后返回1'
 *
 * 进阶:不使用额外的数据结构,只用有限的几个变量,且在时间复杂度为O(N)内完成元问题要实现的函数
 *
 * */
public class Demo19 {

    public static class Node{
        public int value;
        public Node next;
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node copyListWithRand(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }

    public Node copyListWithRandHighest(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        Node next = null;

        //复制并链接每一个节点
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        //设置复制节点得rand指针
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        //拆分
        while (cur != null) {
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }
}
