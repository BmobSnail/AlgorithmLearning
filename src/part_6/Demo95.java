package part_6;

/**
 * 位运算
 * 不用额外变量交换两个整数的值
 *
 * 题目：如何不用任何额外变量交换两个整数的值？
 * */
public class Demo95 {

    public void swap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a="+a+",b="+b);
    }

}
