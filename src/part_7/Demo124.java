package part_7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 数组和矩阵问题
 * 求最短通路值
 *
 * 题目：
 * 用一个整形矩阵matrix表示一个网络，1代表右路，0代表无路，每一个位置hi要不越界，
 * 都有上下左右4个方向，求从最左上角到最右下角的最短通路值。
 * 例如：
 * 1    0   1   1   1
 * 1    0   1   0   1
 * 1    1   1   0   1
 * 0    0   0   0   1
 * 通路只有一条，由12个1构成，所以返回12
 * */
public class Demo124 {

    public int minPathVaule(int[][] m) {
        if (m == null || m.length == 0 || m[0].length ==0
                || m[0][0] != 1 || m[m.length-1][m[0].length-1] != 1)
            return 0;
        int res = 0;
        int[][] map = new int[m.length][m[0].length];
        map[0][0] = 1;
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();
        rQ.add(0);
        cQ.add(0);
        int r = 0;
        int c = 0;
        while (!rQ.isEmpty()) {
            r = rQ.poll();
            c = cQ.poll();
            if (r == m.length - 1 && c == m[0].length - 1)
                return map[r][c];
            walkTo(map[r][c],r-1,c,m,map,rQ,cQ);//up
            walkTo(map[r][c],r+1,c,m,map,rQ,cQ);//down
            walkTo(map[r][c],r,c-1,m,map,rQ,cQ);//left
            walkTo(map[r][c],r,c+1,m,map,rQ,cQ);//right
        }
        return res;
    }

    private void walkTo(int pre, int toR, int toC, int[][] m, int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
        if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length
                || m[toR][toC] != 1 || map[toR][toC] != 0)
            return;
        map[toR][toC] = pre + 1;
        rQ.add(toR);
        cQ.add(toC);
    }
}
