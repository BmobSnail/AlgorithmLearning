package part_5;

/**
 * 字符串问题
 * 字符串的调整与替换
 *
 * 题目：
 * 给定一个字符串类型的数组chas[],chas右半区全是空字符，左半区不含有空字符，现在
 * 想将左半区中所有的空格字符替换成"%20",假设chas右半区足够大，可以满足替换所需要的
 * 空间，请完成替换函数。
 *
 * 补充题目：
 * 给定一个字符类型的数组chas[],其中只含有数字字符和 "*" 字符，现在想把所有的 "*" 字符
 * 挪到chas的左边，数字字符挪到 chas 的右边。请完成调整函数
 *
 * 举例：
 * 如果把 chas 的左半区看作字符串，为 "a b  c",假设 chas 的右半区足够大。替换后，
 * chas 的左半区为 "a%20b%20%20c".
 *
 * 举例：
 * 如果把 chas 看作字符串,为 "12**345".调整后 "**12345".
 * */
public class Demo81 {

    /**
     * 作者原著没有temp字符数组，会报空指针
     * */
    public char[] replace(char[] chas) {
        if (chas == null || chas.length == 0)
            return null;
        int num = 0;
        int len = 0;
        for (len = 0; len < chas.length && chas[len] != 0; len++) {
            if (chas[len] == ' ')
                num++;
        }
        int j = len + num * 2 - 1;
        char[] temp = new char[j+1];
        for (int i = len - 1; i > -1 ; i--) {
            if (chas[i] != ' ') {
                temp[j--] = chas[i];
            } else {
                temp[j--] = '0';
                temp[j--] = '2';
                temp[j--] = '%';
            }
        }
        return temp;
    }

    public void modify(char[] chas) {
        if (chas == null || chas.length == 0)
            return;
        int j = chas.length - 1;
        for (int i = chas.length - 1; i > -1 ; i--) {
            if (chas[i] != '*') {
                chas[j--] = chas[i];
            }
        }
        for (;j > -1;)
            chas[j--] = '*';
    }


}
