package part_2;

/**
 * 链表问题
 * 一种怪异的节点删除方式
 *
 * 题目:
 * 链表节点值类型为int类型,给定一个链表中的节点node,但不给定整个链表的头节点.
 * 如何在链表中删除node?请实现整个函数,并分析这么会出现哪些问题*/
public class Demo27 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void removeNodeWired(Node node) {
        if (node == null)
            return;
        Node next = node.next;
        if (next == null)
            throw new RuntimeException("Can't remove last node");
        node.value = next.value;
        node.next = next.next;
    }
}
