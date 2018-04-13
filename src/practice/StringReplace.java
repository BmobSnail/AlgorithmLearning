package practice;

/**
 * 剑指offer
 * 替换空格
 *
 * 题目描述
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * */
public class StringReplace {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("We are happy");
        System.out.println(sb.toString().replaceAll(" ","%20"));
    }
}
