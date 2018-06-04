import part_1.Demo04;
import part_2.*;
import part_3.*;
import part_4.*;
import part_5.*;

public class Main {

    public static void main(String[] args) {


        //getMin的栈
        /*part_1.Demo01 demo01 = new part_1.Demo01();
        demo01.push(1);
        demo01.push(2);
        demo01.push(3);
        System.out.println("The min:"+demo01.getMin());*/


        //两个栈实现队列
        /*part_1.Demo02 demo02 = new part_1.Demo02();
        demo02.add(1);
        demo02.add(2);
        demo02.add(3);
        demo02.add(4);
        demo02.add(5);
        System.out.println("The last:"+demo02.poll());
        demo02.add(6);
        demo02.add(7);
        demo02.add(8);
        demo02.add(9);
        demo02.add(10);
        System.out.println("The last:"+demo02.poll());*/


        //递归函数逆序一个栈
        /*part_1.Demo03 demo03 = new part_1.Demo03();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        for (int i:stack)
            System.out.println("-->"+i);
        demo03.reverse(stack);
        for (int i:stack)
            System.out.println("-->"+i);*/


        //猫狗队列
       /* Demo04 demo04 = new Demo04();
        demo04.add(new Demo04.Cat());
        demo04.add(new Demo04.Cat());
        demo04.add(new Demo04.Cat());
        demo04.add(new Demo04.Cat());
        demo04.add(new Demo04.Dog());
        System.out.println("The queue is Empty:"+demo04.isEmpty());
        while (!demo04.isEmpty())
            System.out.println("part_1.Pet:"+demo04.pollAll().getPetType());

        System.out.println();
        while (!demo04.isDogEmpty())
            System.out.println("part_1.Dog:"+demo04.pollDog().getPetType());

        System.out.println();
        while (!demo04.isCatEmpty())
            System.out.println("part_1.Cat:"+demo04.pollCat().getPetType());*/


        //用一个栈辅助另外的栈排序
        /*Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        part_1.Demo05.sortStackByStack(stack);
        while (!stack.isEmpty())
            System.out.println("-->"+stack.pop());*/


        //用栈求解Hanoi问题
        /*part_1.Demo06 demo06 = new part_1.Demo06();
        int count = demo06.hanoiProblem(5,"left","mid","right");
//        int count = demo06.hanoiProblemByRecursion(5,"left","mid","right");
        System.out.println("\nIt will move "+count+" steps");*/


        //求窗口最大值
        /*part_1.Demo07 demo07 = new part_1.Demo07();
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        int[] res = demo07.getMaxOfWindow(arr,3);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i: res) {
            sb.append(i).append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        System.out.println("res="+sb.toString());*/


        //构造数组的MaxTree
       /* int[] arr = {3,4,5,1,2};
        part_1.Demo08 demo08 = new part_1.Demo08();
        part_1.Demo08.Node node = demo08.getMaxTree(arr);
        System.out.println("MaxTree:"+node.value);*/


       //最大子矩阵
        /*part_1.Demo09 demo09 = new part_1.Demo09();
        int[][] map = new int[][]{{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        System.out.println("maxRecF:"+demo09.maxRecSize(map));*/


        //最大值与最少值的差大于或等于num的子数组
        /*part_1.Demo10 demo10 = new part_1.Demo10();
        int[] arr = new int[]{1,2,5};
        System.out.println("arr count:"+demo10.getNum(arr,2));*/


        //打印两个有序链表的公共部分
        /*Demo11 demo11 = new Demo11();
        Demo11.Node node1 = new Demo11.Node(1);
        node1.next = new Demo11.Node(2);
        node1.next.next = new Demo11.Node(3);
        node1.next.next.next = new Demo11.Node(4);
        node1.next.next.next.next = new Demo11.Node(5);
        Demo11.Node node2 = new Demo11.Node(2);
        node2.next = new Demo11.Node(3);
        node2.next.next = new Demo11.Node(4);
        node2.next.next.next = new Demo11.Node(5);
        node2.next.next.next.next = new Demo11.Node(6);
        demo11.printCommonPart(node1,node2);*/


        //删除链表倒数第k个节点
        /*Demo12 demo12 = new Demo12();
        Demo12.Node node = new Demo12.Node(1);
        node.next = new Demo12.Node(2);
        node.next.next = new Demo12.Node(3);
        node.next.next.next = new Demo12.Node(4);
        node = demo12.removeLastNode(node,2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //删除链表中第 a/b 个节点
        /*Demo13 demo13 = new Demo13();
        Demo13.Node node = new Demo13.Node(1);
        node.next = new Demo13.Node(2);
        node.next.next = new Demo13.Node(3);
        node.next.next.next = new Demo13.Node(4);
//        demo13.removeMidNode(node);
        demo13.removeByRatio(node,1,3);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //反转单向链表
        /*Demo14 demo14 = new Demo14();
        Demo14.Node node = new Demo14.Node(1);
        node.next = new Demo14.Node(2);
        node.next.next = new Demo14.Node(3);
        node.next.next.next = new Demo14.Node(4);
        node.next.next.next.next = new Demo14.Node(5);
        node = demo14.reverseList(node);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //反转部分单向链表
        /*Demo15 demo15 = new Demo15();
        Demo15.Node node = new Demo15.Node(1);
        node.next = new Demo15.Node(2);
        node.next.next = new Demo15.Node(3);
        node.next.next.next = new Demo15.Node(4);
        node.next.next.next.next = new Demo15.Node(5);
        node = demo15.reversePart(node,2,4);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //亚瑟夫问题
        /*Demo16 demo16 = new Demo16();
        Demo16.Node node = new Demo16.Node(1);
        node.next = new Demo16.Node(2);
        node.next.next = new Demo16.Node(3);
        node.next.next.next = new Demo16.Node(4);
        node.next.next.next.next = new Demo16.Node(5);
        node.next.next.next.next.next = new Demo16.Node(6);
        node.next.next.next.next.next.next = new Demo16.Node(7);
        node.next.next.next.next.next.next.next = node;
        //亚瑟夫进阶
        node = demo16.josephusKillFastest(node,3);
        System.out.println("live="+ node.value);*/


        //判断一个链表是否为回文
        /*Demo17 demo17 = new Demo17();
        Demo17.Node node = new Demo17.Node(1);
        node.next = new Demo17.Node(2);
        node.next.next = new Demo17.Node(3);
        node.next.next.next = new Demo17.Node(4);
        node.next.next.next.next = new Demo17.Node(4);
        node.next.next.next.next.next = new Demo17.Node(3);
        node.next.next.next.next.next.next = new Demo17.Node(2);
        node.next.next.next.next.next.next.next = new Demo17.Node(1);
        boolean palindrome = demo17.isPalindrome_3(node);
        System.out.println(palindrome);*/


        //链表按某值划分区间
        /*Demo18 demo18 = new Demo18();
        Demo18.Node node = new Demo18.Node(9);
        node.next = new Demo18.Node(0);
        node.next.next = new Demo18.Node(4);
        node.next.next.next = new Demo18.Node(5);
        node.next.next.next.next = new Demo18.Node(1);
        node = demo18.partitionHighest(node,3);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //复制随机指针节点得链表
        //看不懂,所以不会举例应用


        //两个单链相加生成新链表
        /*Demo20 demo20 = new Demo20();
        Demo20.Node node1 = new Demo20.Node(9);
        node1.next = new Demo20.Node(3);
        node1.next.next = new Demo20.Node(7);
        Demo20.Node node2 = new Demo20.Node(6);
        node2.next = new Demo20.Node(3);
//        Demo20.Node total = demo20.addList1(node1,node2);
        Demo20.Node total = demo20.addList2(node1,node2);
        while (total != null) {
            System.out.println(total.value);
            total = total.next;
        }*/


        //将单链表的每k个节点之间逆序
        /*Demo22 demo22 = new Demo22();
        Demo22.Node node = new Demo22.Node(1);
        node.next = new Demo22.Node(2);
        node.next.next = new Demo22.Node(3);
        node.next.next.next = new Demo22.Node(4);
        node.next.next.next.next = new Demo22.Node(5);
        node.next.next.next.next.next = new Demo22.Node(6);
        node.next.next.next.next.next.next = new Demo22.Node(7);
        node.next.next.next.next.next.next.next = new Demo22.Node(8);
        node = demo22.reverseKNode1(node,3);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //删除单链表重复值得节点
        /*Demo23 demo23 = new Demo23();
        Demo23.Node node = new Demo23.Node(1);
        node.next = new Demo23.Node(2);
        node.next.next = new Demo23.Node(3);
        node.next.next.next = new Demo23.Node(3);
        node.next.next.next.next = new Demo23.Node(4);
        node.next.next.next.next.next = new Demo23.Node(4);
        node.next.next.next.next.next.next = new Demo23.Node(2);
        node.next.next.next.next.next.next.next = new Demo23.Node(2);
        node.next.next.next.next.next.next.next.next = new Demo23.Node(1);
        demo23.removeRep2(node);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //在单链表中删除指定值得节点
        /*Demo24 demo24 = new Demo24();
        Demo24.Node node = new Demo24.Node(1);
        node.next = new Demo24.Node(2);
        node.next.next = new Demo24.Node(3);
        node.next.next.next = new Demo24.Node(4);
        node = demo24.removeValue2(node,3);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //将搜索二叉树转换成双向链表
        /*Demo25 demo25 = new Demo25();
        Demo25.Node node = new Demo25.Node(6);
        node.left = new Demo25.Node(4);
        node.left.left = new Demo25.Node(2);
        node.left.right = new Demo25.Node(5);
        node.left.left.left = new Demo25.Node(1);
        node.left.left.right = new Demo25.Node(3);
        node.right = new Demo25.Node(7);
        node.right.right = new Demo25.Node(9);
        node.right.right.left = new Demo25.Node(8);
        node = demo25.convert1(node);*/


        //单链表的选择排序
        /*Demo26 demo26 = new Demo26();
        Demo26.Node node = new Demo26.Node(2);
        node.next = new Demo26.Node(1);
        node.next.next = new Demo26.Node(3);
        node.next.next.next = new Demo26.Node(7);
        node.next.next.next.next = new Demo26.Node(5);
        node = demo26.selectionSort(node);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //一种怪异的删除节点方式
        /*Demo27 demo27 = new Demo27();
        Demo27.Node node = new Demo27.Node(1);
        node.next = new Demo27.Node(2);
        node.next.next = new Demo27.Node(3);
        node.next.next.next = new Demo27.Node(4);
        node.next.next.next.next = new Demo27.Node(5);
        demo27.removeNodeWired(node.next.next);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //向有序环形单链表中插入新节点
        /*Demo28 demo28 = new Demo28();
        Demo28.Node node = new Demo28.Node(1);
        node.next = new Demo28.Node(3);
        node.next.next = new Demo28.Node(5);
        node.next.next.next = new Demo28.Node(8);
        node.next.next.next.next = node;
        node = demo28.insertNode(node,4);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //合并两个有序单链表
        /*Demo29 demo29 = new Demo29();
        Demo29.Node head1 = new Demo29.Node(1);
        head1.next = new Demo29.Node(3);
        head1.next.next = new Demo29.Node(7);
        Demo29.Node head2 = new Demo29.Node(2);
        head2.next = new Demo29.Node(3);
        head2.next.next = new Demo29.Node(4);
        Demo29.Node node = demo29.merge(head1,head2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }*/


        //按照左右半区的方式重组单链表
        /*Demo30 demo30 = new Demo30();
        Demo30.Node head = new Demo30.Node(1);
        head.next = new Demo30.Node(2);
        head.next.next = new Demo30.Node(3);
        head.next.next.next = new Demo30.Node(4);
        head.next.next.next.next = new Demo30.Node(5);
        head.next.next.next.next.next = new Demo30.Node(6);
        demo30.retocate(head);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }*/


        //先序'中序'后序遍历二叉树
        /*Demo31 demo31 = new Demo31();
        Demo31.Node node = new Demo31.Node(1);
        node.left = new Demo31.Node(2);
        node.right = new Demo31.Node(3);
        node.left.left = new Demo31.Node(4);
        node.left.right = new Demo31.Node(5);
        node.right.left = new Demo31.Node(6);
        node.right.right = new Demo31.Node(7);
        demo31.preOrderUnRecur(node);
        System.out.println();
        demo31.inOrderUnRecur(node);
        System.out.println();
        demo31.posOrderUnRecur(node);*/


        //打印二叉树的边界节点
        /*Demo32 demo32 = new Demo32();
        Demo32.Node node = new Demo32.Node(1);
        node.left = new Demo32.Node(2);
        node.right = new Demo32.Node(3);
        node.left.right = new Demo32.Node(4);
        node.left.right.left = new Demo32.Node(7);
        node.left.right.right = new Demo32.Node(8);
        node.left.right.right.right = new Demo32.Node(11);
        node.left.right.right.right.left = new Demo32.Node(13);
        node.left.right.right.right.right = new Demo32.Node(14);
        node.right.left = new Demo32.Node(5);
        node.right.right = new Demo32.Node(6);
        node.right.left.left = new Demo32.Node(9);
        node.right.left.right = new Demo32.Node(10);
        node.right.left.left.left = new Demo32.Node(12);
        node.right.left.left.left.left = new Demo32.Node(15);
        node.right.left.left.left.right = new Demo32.Node(16);
        demo32.printEdge1(node);
        System.out.println();
        demo32.printEdge2(node);*/


        //如何较为直观地打印二叉树
        /*Demo33 demo33 = new Demo33();
        Demo33.Node node = new Demo33.Node(1);
        node.left = new Demo33.Node(2);
        node.right = new Demo33.Node(3);
        node.left.left = new Demo33.Node(4);
        node.left.left.right = new Demo33.Node(7);
        node.right.left = new Demo33.Node(5);
        node.right.right = new Demo33.Node(6);
        demo33.printTree(node);*/


        //二叉树得序列化和反序列化
        /*Demo34 demo34 = new Demo34();
        Demo34.Node node = new Demo34.Node(1);
        node.left = new Demo34.Node(2);
        node.left.left = new Demo34.Node(4);
        node.right = new Demo34.Node(3);
        node.right.right = new Demo34.Node(5);
        System.out.println(demo34.serialByPre(node));
        System.out.println();
        System.out.println(demo34.serialByLevel(node));*/


        //神级遍历二叉树
        /*Demo35 demo35 = new Demo35();
        Demo35.Node node = new Demo35.Node(4);
        node.left = new Demo35.Node(2);
        node.left.left = new Demo35.Node(1);
        node.left.right = new Demo35.Node(3);
        node.right = new Demo35.Node(6);
        node.right.left = new Demo35.Node(5);
        node.right.right = new Demo35.Node(7);
        demo35.morrisIn(node);
        demo35.morrisPre(node);
        demo35.morrisPos(node);*/


        //在二叉树中找到累加和为指定值的最长路径长度
        /*Demo36 demo36 = new Demo36();
        Demo36.Node node = new Demo36.Node(-3);
        node.left = new Demo36.Node(3);
        node.left.left = new Demo36.Node(1);
        node.left.right = new Demo36.Node(0);
        node.left.right.left = new Demo36.Node(1);
        node.left.right.right = new Demo36.Node(6);
        node.right = new Demo36.Node(-9);
        node.right.left = new Demo36.Node(2);
        node.right.right = new Demo36.Node(1);
        int step = demo36.getMaxLength(node,-9);
        System.out.println("need step:"+step);*/


        //在二叉树中找到最大搜索二叉子树
        /*Demo37 demo37 = new Demo37();
        Demo37.Node node = new Demo37.Node(6);
        node.left = new Demo37.Node(1);
        node.left.left = new Demo37.Node(0);
        node.left.right = new Demo37.Node(3);
        node.right = new Demo37.Node(12);
        node.right.left = new Demo37.Node(10);
        node.right.right = new Demo37.Node(13);
        node.right.left.left = new Demo37.Node(4);
        node.right.left.right = new Demo37.Node(14);
        node.right.left.left.left = new Demo37.Node(2);
        node.right.left.left.right = new Demo37.Node(5);
        node.right.left.right.left = new Demo37.Node(11);
        node.right.left.right.right = new Demo37.Node(15);
        node.right.right.left = new Demo37.Node(20);
        node.right.right.right = new Demo37.Node(16);
        node = demo37.biggestSubBST(node);
        System.out.println(node.value);*/


        //找到二叉树中符合搜索二叉树条件的最大拓扑结构
      /*  Demo38 demo38 = new Demo38();
        Demo38.Node node = new Demo38.Node(6);
        node.left = new Demo38.Node(1);
        node.left.left = new Demo38.Node(0);
        node.left.right = new Demo38.Node(3);
        node.right = new Demo38.Node(12);
        node.right.left = new Demo38.Node(10);
        node.right.left.left = new Demo38.Node(4);
        node.right.left.left.left = new Demo38.Node(2);
        node.right.left.left.right = new Demo38.Node(5);
        node.right.left.right = new Demo38.Node(14);
        node.right.left.right.left = new Demo38.Node(11);
        node.right.left.right.right = new Demo38.Node(15);
        node.right.right = new Demo38.Node(13);
        node.right.right.left = new Demo38.Node(20);
        node.right.right.right = new Demo38.Node(16);
        int count = demo38.bstTopoSize1(node);
        System.out.println("step:"+count);*/


        //按层和ZipZag打印二叉树
        /*Demo39 demo39 = new Demo39();
        Demo39.Node node = new Demo39.Node(1);
        node.left = new Demo39.Node(2);
        node.right = new Demo39.Node(3);
        node.left.left = new Demo39.Node(4);
        node.right.left = new Demo39.Node(5);
        node.right.right = new Demo39.Node(6);
        node.right.left.left = new Demo39.Node(7);
        node.right.left.right = new Demo39.Node(8);
        demo39.printByLevel(node);
        System.out.println();
        demo39.printByZigZag(node);*/


        //调整搜索二叉树中两个错误的节点
        /*Demo40 demo40 = new Demo40();
        Demo40.Node node =  new Demo40.Node(3);
        node.left = new Demo40.Node(2);
        node.right = new Demo40.Node(4);
        node.left.left = new Demo40.Node(1);
        node.right.left = new Demo40.Node(5);
        node.right.right = new Demo40.Node(6);
        Demo40.Node[] errs = demo40.getTwoErrorNodes(node);
        for (Demo40.Node err : errs) {
            System.out.println(err.value);
        }*/


        //判断t1树是否包含t2树全部的拓扑结构
        /*Demo41 demo41 = new Demo41();
        Demo41.Node t1 = new Demo41.Node(1);
        t1.left = new Demo41.Node(2);
        t1.left.left = new Demo41.Node(4);
        t1.left.left.left = new Demo41.Node(8);
        t1.left.left.right = new Demo41.Node(9);
        t1.left.right = new Demo41.Node(5);
        t1.left.right.left = new Demo41.Node(10);
        t1.right = new Demo41.Node(3);
        t1.right.left = new Demo41.Node(6);
        t1.right.right = new Demo41.Node(7);
        Demo41.Node t2 = new Demo41.Node(2);
        t2.left = new Demo41.Node(4);
        t2.left.left = new Demo41.Node(8);
        t2.right = new Demo41.Node(5);
        System.out.println(demo41.contains(t1,t2));*/


        //判断t1树中是否有与t2树拓扑结构完全相同的子树
        /*Demo42 demo42 = new Demo42();
        Demo42.Node t1 = new Demo42.Node(1);
        t1.left = new Demo42.Node(2);
        t1.left.left = new Demo42.Node(4);
        t1.left.left.right = new Demo42.Node(8);
        t1.left.right = new Demo42.Node(5);
        t1.left.right.left = new Demo42.Node(9);
        t1.right = new Demo42.Node(3);
        t1.right.left = new Demo42.Node(6);
        t1.right.right = new Demo42.Node(7);
        Demo42.Node t2 = new Demo42.Node(2);
        t2.left = new Demo42.Node(4);
        t2.left.right = new Demo42.Node(8);
        t2.right = new Demo42.Node(5);
//        t2.right.left = new Demo42.Node(9);
        System.out.println(demo42.isSubTree(t1,t2));*/


        //判断二叉树是否为平衡二叉树
        /*Demo43 demo43 = new Demo43();
        Demo43.Node node = new Demo43.Node(1);
        node.left =  new Demo43.Node(2);
        node.left.left = new Demo43.Node(3);
        node.left.right = new Demo43.Node(4);
        node.right = new Demo43.Node(7);
        node.right.left = new Demo43.Node(8);
        node.right.right = new Demo43.Node(9);
        System.out.println(demo43.isBalance(node));*/


        //判断一棵二叉树是否为搜索二叉树和完全二叉树
        /*Demo45 demo45 = new Demo45();
        Demo45.Node node = new Demo45.Node(1);
        node.left =  new Demo45.Node(2);
        node.left.left = new Demo45.Node(3);
        node.left.right = new Demo45.Node(4);
        node.right = new Demo45.Node(7);
        node.right.left = new Demo45.Node(8);
        node.right.right = new Demo45.Node(9);
        System.out.println("是否为搜索二叉树:"+demo45.isBST(node));
        System.out.println("是否为完全二叉树:"+demo45.isCBT(node));*/


        //在二叉树中找到一个节点的后继节点
        /*Demo47 demo47 = new Demo47();
        Demo47.Node node = new Demo47.Node(6);
        node.left = new Demo47.Node(3);
        node.left.parent = node;
        node.left.left = new Demo47.Node(1);
        node.left.left.parent = node.left;
        node.left.right = new Demo47.Node(4);
        node.left.right.parent = node.left;
        node.left.left.right = new Demo47.Node(2);
        node.left.left.right.parent = node.left.left;
        node.left.right.right = new Demo47.Node(5);
        node.left.right.right.parent = node.left.right;
        node.right = new Demo47.Node(9);
        node.right.parent = node;
        node.right.left = new Demo47.Node(8);
        node.right.left.parent = node.right;
        node.right.right = new Demo47.Node(10);
        node.right.right.parent = node.right;
        node.right.left.left = new Demo47.Node(7);
        node.right.left.left.parent = node.right.left;
        System.out.println(demo47.getNextNode(node.left.right).value);*/


        //Tarjan算法与并查集解决二叉树节点间最近公共祖先得批量查询问题
        /*Demo49 demo49 = new Demo49();
        Demo49.Node node = new Demo49.Node(1);
        node.left = new Demo49.Node(2);
        node.left.left = new Demo49.Node(4);
        node.left.right = new Demo49.Node(5);
        node.left.right.left = new Demo49.Node(7);
        node.left.right.right = new Demo49.Node(8);
        node.right = new Demo49.Node(3);
        node.right.right = new Demo49.Node(6);
        node.right.right.left = new Demo49.Node(9);
        Demo49.Query[] queries = new Demo49.Query[7];
        queries[0] = new Demo49.Query(node.left.left,node.left.right.left);
        queries[1] = new Demo49.Query(node.left.right.left,node.right.right.left);
        queries[2] = new Demo49.Query(node.left.right.right,node.right.right.left);
        queries[3] = new Demo49.Query(node.right.right.left,node.right);
        queries[4] = new Demo49.Query(node.right.right,node.right.right);
        queries[5] = new Demo49.Query(null,node.left.right);
        queries[6] = new Demo49.Query(null,null);
        Demo49.Node[] fathers = demo49.tarJanQuery(node,queries);
        for (Demo49.Node father : fathers) {
            if (father == null)
                System.out.println("null");
            else
                System.out.println(father.value);
        }*/


        //二叉树节点间最大距离
        /*Demo50 demo50 = new Demo50();
        Demo50.Node node = new Demo50.Node(1);
        node.left = new Demo50.Node(2);
        node.left.left = new Demo50.Node(4);
        node.left.right = new Demo50.Node(5);
        node.right = new Demo50.Node(3);
        node.right.left = new Demo50.Node(6);
        node.right.right = new Demo50.Node(7);
        System.out.println("step:"+demo50.maxDistance(node));*/


        //通过先序和中序数组生成后序数组
        /*Demo52 demo52 = new Demo52();
        int[] pos = demo52.getPosArray(new int[]{1,2,4,5,3,6,7},new int[]{4,2,5,1,6,3,7});
        for (int po : pos) {
            System.out.print(po + ",");
        }*/


        //统计二叉树的节点数
        /*Demo54 demo50 = new Demo54();
        Demo54.Node node = new Demo54.Node(1);
        node.left = new Demo54.Node(2);
        node.left.left = new Demo54.Node(4);
        node.left.right = new Demo54.Node(5);
        node.right = new Demo54.Node(3);
        node.right.left = new Demo54.Node(6);
        node.right.right = new Demo54.Node(7);
        System.out.println("All node:"+demo50.nodeNum(node));*/


        //斐波那契系列问题
        /*Demo55 demo55 = new Demo55();
        System.out.println("斐波那契 第4项："+demo55.f3(4));
        System.out.println("牛生小母牛 第3代："+demo55.s3(3));
        System.out.println("跨台阶 第8级："+demo55.c3(8));*/


        //矩阵最小路径和
        /*Demo56 demo56 = new Demo56();
        int[][] m = {{1,3,5,9},
                    {8,1,3,4},
                    {5,0,6,1},
                    {8,8,4,0}};
        System.out.println("sum:"+demo56.minPathSum2(m));*/


        //最少货币数
        /*Demo57 demo57 = new Demo57();
        System.out.println("less:"+demo57.minCoins2(new int[] {5,2,3},20));*/


        //最大递增子序列
        /*Demo59 demo59 = new Demo59();
        int[] arr = demo59.list1(new int[]{2,1,5,3,6,4,8,9,7});
        for (int anArr : arr) {
            System.out.print(anArr + ", ");
        }*/


        //汉诺塔问题
        /*Demo60 demo60 = new Demo60();
        demo60.hanoi(4);
        System.out.println(demo60.step1(new int[]{3,3,2,1}));*/


        //最长公共子序列问题
        /*Demo61 demo61 = new Demo61();
        String str1="1A2C3D4B56";
        String str2="B1D23CA45B6A";
        System.out.println(demo61.lcse(str1,str2));*/


        //最长公共子串
        /*Demo62 demo62 = new Demo62();
        String str1="1AV2345CD";
        String str2="123456EF";
        System.out.println(demo62.lcst2(str1,str2));*/


        //最小编辑代价
        /*Demo63 demo63 = new Demo63();
        String str1 = "abc";
        String str2 = "adb";
        System.out.println(demo63.minCost1(str1,str2,5,3,2));*/


        //字符串交错组成
        /*Demo64 demo64 = new Demo64();
        String str1 = "AB";
        String str2 = "12";
        System.out.println(demo64.isCross2(str1,str2,"A1B2"));*/


        //龙与地下城游戏问题
        /*Demo65 demo65 = new Demo65();
        int[][] m = {{-2,-3,3},{-5,-10,1},{0,30,-5}};
        System.out.println("less HP:"+demo65.minHP2(m));*/


        //数字字符串转换为字母组合的种数
        /*Demo66 demo66 = new Demo66();
        System.out.println("count:"+demo66.num2("1111"));*/


        //表达式得到期望结果的组成种数
        /*Demo67 demo67 = new Demo67();
        System.out.println("count:"+demo67.num1("1^0|0|1",false));*/


        //抽纸牌问题
        /*Demo68 demo68 = new Demo68();
        System.out.println(demo68.win2(new int[]{1,2,10,4}));*/


        //跳跃游戏
        /*Demo69 demo69 = new Demo69();
        System.out.println(demo69.jump(new int[]{3,2,3,1,1,4}));*/


        //数组中最长连续序列
        /*Demo70 demo70 = new Demo70();
        System.out.println(demo70.longestConsecutive(new int[]{100,4,200,1,3,2}));*/


        //n皇后问题
        /*Demo71 demo71 = new Demo71();
        System.out.println("count:"+demo71.num2(8));*/


        //判断两个字符串是否互为变形词
        /*Demo72 demo72 = new Demo72();
        System.out.println(demo72.isDeformation("123","2331"));*/


        //字符串子串数字的求和
       /* Demo73 demo73 = new Demo73();
        System.out.println("Sum="+demo73.numSun("A1CD2E33"));*/


        //去掉字符串中连续出现的k个0字符
        /*Demo74 demo74 = new Demo74();
        System.out.println(demo74.removeKZeros("A00B",2));
        System.out.println(demo74.removeKZeros("A0000B000",3));*/


        //判断两个字符串是否互为旋转词
        /*Demo75 demo75 = new Demo75();
        System.out.println(demo75.isRotation("cdab","abcd"));*/


        //将整数字符串转成整数值
        /*Demo76 demo76 = new Demo76();
        String[] arr = {"123","023","A13","0","2147483647","2147483648","-123"};
        for (String anArr : arr) {
            System.out.println(demo76.convert(anArr));
        }*/


        //替换字符串中连续出现的指定字符串
        Demo77 demo77 = new Demo77();
        System.out.println(demo77.replace("123abc","abc","4567"));
        System.out.println(demo77.replace("123","abc","456"));
        System.out.println(demo77.replace("123abcabc","abc","X"));
    }
}
