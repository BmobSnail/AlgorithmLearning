package part_1;

/**
 * 栈和队列
 * 求解汉诺塔问题,先修改一下游戏规则:线则限制不能从最左侧直接移到最右侧
 * 也不能从最右侧直接移到最左侧,而是必须经过中间.求当塔又N层时,最优移动过程和总步数
 *
 * 解题思路:递归的方法
 * */

public class Demo06 {

    public int hanoiProblem(int num, String left, String mid, String right) {
        if (num < 1)
            return 0;
        return process(num,left,mid,right,left,right);
    }

    public int process(int num, String left, String mid, String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from "+from + " to " +mid);
                System.out.println("Move 1 from "+mid+" to "+to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String anther = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, anther);
            int part2 = 1;
            System.out.println("Move " + num + " from " + from + " to " + to);
            int part3 = process(num - 1, left, mid, right, anther, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num-1,left,mid,right,from,to);
            int part2 = 1;
            System.out.println("Move "+num+ " from "+from+" to "+mid);
            int part3 = process(num-1,left,mid,right,to,from);
            int part4 = 1;
            System.out.println("Move "+num+" from "+mid+" to "+to );
            int part5 = process(num-1,left,mid,right,from,to);
            return part1+part2+part3+part4+part5;
        }
    }

}
