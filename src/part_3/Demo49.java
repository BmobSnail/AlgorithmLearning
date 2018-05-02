package part_3;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 二叉树问题
 * Tarjan算法与并查集解决二叉树节点间最近公共祖先得批量查询问题
 *
 * 题目:
 * 如下Node类是标准的二叉树节点结构
 * public class Node{
 *     public int value;
 *     public Node left;
 *     public Node right;
 *
 *     public Node(int value){
 *         this.value = value;
 *     }
 * }
 *
 * 再定义Query类如下
 * public class Query{
 *     public Node o1;
 *     public Node o2;
 *
 *     public Query(Node o1,Node o2){
 *         this.o1 = o1;
 *         this.o2 = o2;
 *     }
 * }
 *
 * 一个Query类的实例表示一条查询语句,表示想要查询o1节点和o2节点的最近公共祖先节点.
 * 给定一棵二叉树的头节点head,并给定所有的查询语句,即一个Query类型的数组Query[] ques,
 * 请返回Node类型的数组Node[] ans,ans[i]代表ques[i]这条查询的答案,即ques[i].o1和ques[i].o2的最近公共祖先
 * */
public class Demo49 {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class Query{
        public Node o1;
        public Node o2;

        public Query(Node o1, Node o2) {
            this.o1 = o1;
            this.o2 = o2;
        }
    }

    private class DisJointSets{
        public HashMap<Node,Node> fatherMap;
        public HashMap<Node,Integer> rankMap;

        public DisJointSets(){
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
        }

        public void makeSets(Node head) {
            fatherMap.clear();
            rankMap.clear();
            preOrderMake(head);
        }

        private void preOrderMake(Node head) {
            if (head == null)
                return;
            fatherMap.put(head,head);
            rankMap.put(head,0);
            preOrderMake(head.left);
            preOrderMake(head.right);
        }

        public Node findFather(Node node) {
            Node father = fatherMap.get(node);
            if (father != node)
                father = findFather(father);
            fatherMap.put(node,father);
            return father;
        }

        public void union(Node a, Node b) {
            if (a == null || b == null)
                return;
            Node aFather = findFather(a);
            Node bFather = findFather(b);
            if (aFather != bFather) {
                int aFrank = rankMap.get(aFather);
                int bFrank = rankMap.get(bFather);
                if (aFrank < bFrank) {
                    fatherMap.put(aFather,bFather);
                } else if (aFrank > bFrank) {
                    fatherMap.put(bFather, aFather);
                } else {
                    fatherMap.put(bFather,aFather);
                    rankMap.put(aFather,aFrank+1);
                }
            }
        }
    }

    private class Tarjan{
        private HashMap<Node ,LinkedList<Node>> queryMap;
        private HashMap<Node,LinkedList<Integer>> indexMap;
        private HashMap<Node,Node> ancestorMap;
        private DisJointSets sets;

        public Tarjan(){
            queryMap = new HashMap<>();
            indexMap = new HashMap<>();
            ancestorMap = new HashMap<>();
            sets = new DisJointSets();
        }

        public Node[] query(Node head, Query[] ques) {
            Node[] ans = new Node[ques.length];
            setQueries(ques,ans);
            sets.makeSets(head);
            setAnswers(head,ans);
            return ans;
        }

        private void setQueries(Query[] ques, Node[] ans) {
            Node o1 = null;
            Node o2= null;
            for (int i = 0; i != ans.length; i++) {
                o1 = ques[i].o1;
                o2 = ques[i].o2;
                if (o1 == o2 || o1 == null || o2 == null) {
                    ans[i] = o1 != null ? o1 : o2;
                } else {
                    if (!queryMap.containsKey(o1)) {
                        queryMap.put(o1,new LinkedList<>());
                        indexMap.put(o1,new LinkedList<>());
                    }
                    if (!queryMap.containsKey(o2)) {
                        queryMap.put(o2,new LinkedList<>());
                        indexMap.put(o2,new LinkedList<>());
                    }
                    queryMap.get(o1).add(o2);
                    indexMap.get(o1).add(i);
                    queryMap.get(o2).add(o1);
                    indexMap.get(o2).add(i);
                }
            }
        }

        private void setAnswers(Node head, Node[] ans) {
            if (head == null)
                return;
            setAnswers(head.left,ans);
            sets.union(head.left,head);
            ancestorMap.put(sets.findFather(head),head);
            setAnswers(head.right,ans);
            sets.union(head.right,head);
            ancestorMap.put(sets.findFather(head),head);
            LinkedList<Node> nList = queryMap.get(head);
            LinkedList<Integer> iList = indexMap.get(head);
            Node node = null;
            Node father = null;
            int index = 0;
            while (nList != null && !nList.isEmpty()) {
                node = nList.poll();
                index = iList.poll();
                father = sets.findFather(node);
                if (ancestorMap.containsKey(father)) {
                    ans[index] = ancestorMap.get(father);
                }
            }
        }
    }

    public Node[] tarJanQuery(Node head, Query[] queries) {
        return new Tarjan().query(head,queries);
    }

}
