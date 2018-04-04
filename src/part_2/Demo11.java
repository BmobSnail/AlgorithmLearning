package part_2;

/**
 * 链表问题
 * 给定两个有序链表的头指针 head1 和 head2 打印两个链表的公共部分
 *
 * 解题思路:
 *  因为都是有序链表,从头开始进行如下判断:
 *  如果 head1 的值小于 head2,则 head1 往下移动
 *  如果 head2 的值小于 head1,则 head2 往下移动
 *  如果 head1 的值与 head2 的值相等,则打印这个值,然后 head1 与 head2 都往下移动
 *  head1 或 head2 有人格一个移动到 null,则整个过程结束
 * */

public class Demo11 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common part:");
        while (head1 != null && head2 != null)
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.println(head1.value + "");
                head1 = head1.next;
                head2 = head2.next;
            }
        System.out.println();
    }

}
