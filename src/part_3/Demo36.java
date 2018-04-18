package part_3;

import java.util.HashMap;

/**
 * 二叉树问题
 * 在二叉树中找到累加和为指定值的最长路径长度
 *
 * 题目:
 * 给定一颗二叉树的头节点head和一共32位整数sum,二叉树节点值类型位整形,
 * 求累加和为sum的最长路径长度.路径是指从某个节点往下,每次最多选择一个孩子节点
 * 或者不选所形成的节点链.
 * */
public class Demo36 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public int getMaxLength(Node head, int sum) {
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        sumMap.put(0,0);
        return preOrder(head,sum,0,1,0,sumMap);
    }

    private int preOrder(Node head, int sum, int preSum, int level, int maxLen, HashMap<Integer, Integer> sumMap) {
        if (head == null)
            return maxLen;
        int curSum = preSum + head.value;
        if (!sumMap.containsKey(curSum)) {
            sumMap.put(curSum,level);
        }
        if (sumMap.containsKey(curSum - sum)) {
            maxLen = Math.max(level-sumMap.get(curSum - sum),maxLen);
        }
        maxLen = preOrder(head.left,sum,curSum,level+1,maxLen,sumMap);
        maxLen = preOrder(head.right,sum,curSum,level+1,maxLen,sumMap);
        if (level == sumMap.get(curSum)) {
            sumMap.remove(curSum);
        }
        return maxLen;
    }
}
