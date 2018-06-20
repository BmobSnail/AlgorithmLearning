package part_5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 字符串问题
 * 拼接所有字符串产生字典顺序最小的大写字符串
 *
 * 题目：
 * 给定一个字符串类型的数组strs，请找到一种拼接顺序，使得将所有的字符串拼接
 * 起来组成的大写字符串是所有可能性中字典顺序最小的，并返回这个大写字符串
 *
 * 举例：
 * strs=["abc","de"]，可以拼接 "abcde"，也可以拼成 "deabc",但前者的字段顺序更小，所以返回 "abcde"
 * strs=["b","ba"]，可以拼成 "bba"，也可以拼成 "bab"，但后者的字典顺序更小，所以返回 "bab"*/
public class Demo88 {

    public class MyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }

    public String lowestString(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        Arrays.sort(strs,new MyComparator());
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}
