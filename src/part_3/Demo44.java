package part_3;

/**
 * 二叉树问题
 * 根据后序数组重建搜索二叉树
 *
 * 题目:
 * 给定一个整形数组arr.已知其中没有重复值,判断arr是否肯恩是节点值类型为整形的搜索二叉树
 * 后序遍历的结果.
 *
 * 进阶:
 * 如果整形数组arr中没有重复着,且已知是一棵搜索二叉树的后序遍历结果,通过数组arr重建二叉树*/
public class Demo44 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isPostArray(int[] arr) {
        if (arr == null || arr.length == 0)
            return false;
        return isPost(arr,0,arr.length-1);
    }

    private boolean isPost(int[] arr, int start, int end) {
        if (start == end)
            return true;
        int less = -1;
        int more = end;
        for (int i = start;i<end;i++) {
            if (arr[end] > arr[i])
                less = i;
            else
                more = more == end ? i : more;
        }
        if (less == -1 || more == end)
            return isPost(arr,start,end-1);
        if (less != more -1)
            return false;
        return isPost(arr,start,less) && isPost(arr,more,end-1);
    }

    //进阶重建搜索二叉树
    public Node posArrayToBST(int[] posArr) {
        if (posArr == null)
            return null;
        return posToBST(posArr,0,posArr.length-1);
    }

    private Node posToBST(int[] posArr, int start, int end) {
        if (start > end)
            return null;
        Node head = new Node(posArr[end]);
        int less = -1;
        int more = end;
        for (int i = start; i < end; i++) {
            if (posArr[end] > posArr[i])
                less = i;
            else
                more = more == end ? i: more;
        }
        head.left = posToBST(posArr,start,less);
        head.right = posToBST(posArr,more,end-1);
        return head;
    }
}
