package part_3;

import java.util.HashMap;

/**
 * 二叉树问题
 * 先序、中序、后序数组两两结合重构二叉树
 *
 * 题目：已知一棵二叉树的所有节点值都不同，给定这棵二叉树正确的先序、中序、后序数组。
 * 请分别用三个函数实现任意两种数组结构重构原来的二叉树，并返回重构二叉树的头节点
 * */
public class Demo51 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    //先序和中序结合重构二叉树
    public Node preInToTree(int[] pre, int[] in) {
        if (pre == null || in == null)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    private Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
        if (pi > pj)
            return null;
        Node head = new Node(p[pi]);
        int index = map.get(p[pi]);
        head.left = preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right = preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }

    //中序和后序重构
    public Node inPosToTree(int[] in, int[] pos) {
        if (in == null || pos == null)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i],i);
        }
        return inPos(in,0,in.length-1,pos,0,pos.length-1,map);
    }

    private Node inPos(int[] n, int ni, int nj, int[] s, int si, int sj, HashMap<Integer, Integer> map) {
        if (si > sj)
            return null;
        Node head = new Node(s[sj]);
        int index = map.get(s[sj]);
        head.left = inPos(n,ni,index-1,s,si,si+index-ni-1,map);
        head.right = inPos(n,index+1,nj,s,si+index-ni,sj-1,map);
        return head;
    }

    //先序和后序重构
    public Node prePosToTree(int[] pre, int[] pos) {
        if (pre == null || pos == null)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < pos.length; i++) {
            map.put(pos[i],i);
        }
        return prePos(pre,0,pre.length-1,pos,0,pos.length-1,map);
    }

    private Node prePos(int[] p, int pi, int pj, int[] s, int si, int sj, HashMap<Integer, Integer> map) {
        Node head = new Node(s[sj--]);
        if (pi == pj)
            return head;
        int index = map.get(p[++pi]);
        head.left = prePos(p,pi,pi+index-si,s,si,index,map);
        head.right = prePos(p,pi+index-si+1,pj,s,index+1,sj,map);
        return head;
    }
}
