package part_3;

/**
 * 二叉树问题
 * 通过有序数组生成平衡搜索二叉树
 *
 * 题目:
 * 给定一个有序数组sortArr,已知其中没有重复值,用这个有序数组生成一棵平衡搜索二叉树,
 * 并且该搜索二叉树中序遍历的结果和sortArr一致
 * */
public class Demo46 {

    public static class Node{
        public int value;
        public Node left;
        public Node rithg;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node generateTree(int[] sortArr) {
        if (sortArr == null) {
            return null;
        }
        return generate(sortArr,0,sortArr.length-1);
    }

    private Node generate(int[] sortArr, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node head = new Node(sortArr[mid]);
        head.left = generate(sortArr,start,mid-1);
        head.rithg = generate(sortArr,mid+1,end);
        return head;
    }
}
