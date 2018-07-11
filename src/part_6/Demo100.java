package part_6;

/**
 * 位运算
 * 在其他数都出现k次的数组中找到只出现一次的数
 *
 * 题目：
 * 给定一个整型数组arr和一个大于1的整数k，已知arr中只有1个数出现1次，其他的数
 * 都出现了k次，请返回只出现了1次的数
 *
 * 要求：
 * 时间复杂度为O（N），额外空间复杂度为O（1）
 * */
public class Demo100 {

    public int onceNum(int[] arr, int k) {
        int[] eO = new int[32];
        for (int i = 0; i != arr.length; i++) {
            setExclusiveOr(eO,arr[i],k);
        }
        return getNumFromKSysNum(eO,k);
    }

    private void setExclusiveOr(int[] eO, int value, int k) {
        int[] curKSysNum = getKSysNumFromNum(value,k);
        for (int i = 0; i != eO.length; i++) {
            eO[i] = (eO[i] + curKSysNum[i]) % k;
        }
    }

    private int[] getKSysNumFromNum(int value,int k) {
        int[] res = new int[32];
        int index = 0;
        while (value != 0) {
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }

    private int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i != -1 ; i--) {
            res = res * k + eO[i];
        }
        return res;
    }

}
