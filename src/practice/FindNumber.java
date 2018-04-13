package practice;

/**
 * 剑指offer
 * 二维数组中的查找
 *
 * 题目描述
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * */
public class FindNumber{

    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(findMin(16,new int[][]{}));
    }

    public static boolean findMin(int target,int[][] array) {
        if (array.length == 0)
            return false;
        boolean has = false;
        for (int[] row : array) {
            if (row.length > 0 && row[row.length - 1] >= target) {
                for (int column : row) {
                    if (column == target) {
                        has = true;
                        break;
                        }
                    }
                }
        }
        return has;
    }
}
