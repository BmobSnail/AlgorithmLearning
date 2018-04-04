package practice;

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
