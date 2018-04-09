import part_1.Demo04;
import part_2.*;

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
    }
}
