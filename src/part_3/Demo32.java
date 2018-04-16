package part_3;

/**
 * 二叉树问题
 * 打印二叉树的边界节点
 *
 * 题目:
 * 给定一科二叉树的头节点head,按照如下两种标准分别实现二叉树边界节点和逆时针打印
 * 标准一:
 * 1.头节点为边界节点
 * 2.叶节点为边界节点
 * 3.如果节点再其所在的层中是最左或最右的,那么也是边界节点
 * 标准二:
 * 1.头节点为边界节点
 * 2.叶节点为边界节点
 * 3.树左边界延伸下去的路径为边界节点
 * 4.树右边界延伸下去的路径为边界节点
 *
 * 要求:
 * 1.如果节点数为N,两种标准实现的时间复杂度要求都为O(N).额外空间复杂度为O(h),h为二叉树高度
 * 2.两种标准都要求逆时针顺序且不重复打印所有的边界节点
 * */
public class Demo32 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printEdge1(Node head) {
        if (head == null)
            return;
        int height = getHeight(head,0);
        Node[][] edgeMap = new Node[height][2];
        setEdgeMap(head,0,edgeMap);
        //打印左边界
        for (int i=0;i!=edgeMap.length;i++) {
            System.out.println(edgeMap[i][0].value + " ");
        }
        //打印既不是左边界,也不是右边界的叶子节点
        printLeafNotInMap(head,0,edgeMap);
        //打印右边界,但不是左边界的节点
        for (int i=edgeMap.length-1;i!=-1;i--) {
            if (edgeMap[i][0] != edgeMap[i][1]) {
                System.out.println(edgeMap[i][1].value+" ");
            }
        }
        System.out.println();
    }

    private int getHeight(Node head, int num) {
        if (head == null)
            return num;
        return Math.max(getHeight(head.left,num+1),getHeight(head.right,num+1));
    }

    private void setEdgeMap(Node head, int num, Node[][] map) {
        if (head == null)
            return;
        map[num][0] = map[num][0] == null ? head : map[num][0];
        map[num][1] = head;
        setEdgeMap(head.left,num+1,map);
        setEdgeMap(head.right,num+1,map);
    }

    private void printLeafNotInMap(Node head, int num, Node[][] map) {
        if (head == null)
            return;
        if (head.left == null && head.right == null && head != map[num][0] && head != map[num][1]) {
            System.out.println(head.value + " ");
        }
        printLeafNotInMap(head.left,num+1,map);
        printLeafNotInMap(head.right,num+1,map);
    }

    public void printEdge2(Node head) {
        if (head == null)
            return;
        System.out.println(head.value + " ");
        if (head.left != null && head.right != null) {
            printLeftEdge(head.left, true);
            printRightEdge(head.right, true);
        } else {
            printEdge2(head.left != null ? head.left : head.right);
        }
        System.out.println();
    }

    private void printLeftEdge(Node head, boolean print) {
        if (head == null)
            return;
        if (print || (head.left == null && head.right == null)) {
            System.out.println(head.value + " ");
        }
        printLeftEdge(head.left,print);
        printLeftEdge(head.right,print&&head.left==null);
    }

    private void printRightEdge(Node head, boolean print) {
        if (head == null)
            return;
        printRightEdge(head.left,print&&head.right==null);
        printRightEdge(head.right,print);
        if (print || (head.left == null && head.right == null))
            System.out.println(head.value + " ");
    }
}
