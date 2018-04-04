package part_2;

/**
 * 链表问题
 * 环形单链表的亚瑟夫问题
 *
 * 据说著名犹太历史学家Josephus有过一下故事:在罗马人占领后,39个犹太人与朋友躲在一个洞中,39个犹太人决定宁愿死也不要
 * 呗敌人抓到,于是决定了一个自杀方式,41个人排成一个圆圈,由第1个人开始报数,报数到3的人就自杀,然后再由下一个人重新报1,
 * 报数到3的人再继续自杀,这样依次下去,直到剩下最后一个人时,那个人可以自由选择自己的命运.这就是著名的亚瑟夫问题.
 *
 * 题目:
 * 输入:一个环形单向链表的头节点head和报数的值m
 * 返回:最后生存下来的节点,且这个节点自己组成环形单向链表,其它节点都删掉
 *
 * 进阶:如果链表节点数为N,想在时间复杂度为O(N)时完成原问题的要求,该怎么实现?
 * */
public class Demo16 {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node josephusKill(Node head, int m) {
        if (head == null || head.next == head || m < 1)
            return head;
        Node last = head;
        while (last.next != head)
            last = last.next;
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }

    public Node josephusKillFastest(Node head, int m) {
        if (head == null || head.next == head || m < 1)
            return head;
        Node cur = head.next;
        int temp = 1;//tmp->list size
        while (cur != head) {
            temp++;
            cur = cur.next;
        }
        temp = getLive(temp,m);
        while (--temp != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    private int getLive(int i, int m) {
        if (i==1)
            return i;
        return (getLive(i - 1,m)+m-1)%i+1;
    }
}
