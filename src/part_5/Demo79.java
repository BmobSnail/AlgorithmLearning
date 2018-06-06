package part_5;

/**
 * 字符串问题
 * 判断字符数组中是否所有的字符都只出现过一次
 *
 * 题目：
 * 给定一个字符类型数组chas[],判断chas中是否所有的字符都只出现过一次，请根据
 * 以下不同的两种要求实现两个函数。
 *
 * 举例：
 * chas=['a','b','c'],返回true
 * chas=['1','2','1'],返回false
 * */
public class Demo79 {

    public boolean isUnique1(char[] chas) {
        if (chas == null)
            return true;
        boolean[] map = new boolean[256];
        for (char cha : chas) {
            if (map[cha])
                return false;
            map[cha] = true;
        }
        return true;
    }

    public boolean isUnique2(char[] chas) {
        if (chas == null)
            return true;
        heapSort(chas);
        for (int i = 1; i < chas.length; i++) {
            if (chas[i] == chas[i - 1])
                return false;
        }
        return true;
    }

    private void heapSort(char[] chas) {
        for (int i = 0; i < chas.length; i++) {
            heapInsert(chas,i);
        }
        for (int i = chas.length-1; i < chas.length; i++) {
            swap(chas,0,i);
            heapify(chas,0,i);
        }
    }

    private void heapInsert(char[] chas, int i) {
        int parent = 0;
        while (i != 0) {
            parent = (i - 1) / 2;
            if (chas[parent] < chas[i]) {
                swap(chas,parent,i);
                i = parent;
            }else
                break;
        }
    }

    private void heapify(char[] chas, int i, int size) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        while (left < size) {
            if (chas[left] > chas[i]) {
                largest = right;
            }
            if (right < size && chas[right] > chas[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(chas, largest, i);
            } else {
                break;
            }
            i = largest;
            left = i *2 + 1;
            right = i *2 + 2;
        }
    }

    private void swap(char[] chas, int parent, int i) {
        char temp = chas[parent];
        chas[parent] = chas[i];
        chas[i] = temp;
    }


}
