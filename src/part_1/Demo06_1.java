package part_1;

import java.util.Stack;

public class Demo06_1 {

    enum Action{
        No,LToM,MToL,MToR,RToM
    }

    public int hanoiProblem(int num, String left, String mid, String right) {
        Stack<Integer> lS = new Stack<>();
        Stack<Integer> mS = new Stack<>();
        Stack<Integer> rS = new Stack<>();
        lS.push(Integer.MAX_VALUE);
        mS.push(Integer.MAX_VALUE);
        rS.push(Integer.MAX_VALUE);
        for (int i = num; i >0 ; i--) {
            lS.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rS.size() != num + 1) {
            step += fStackToStack(record,Action.MToL,Action.LToM,lS,mS,left,mid);
            step += fStackToStack(record,Action.LToM,Action.MToL,mS,lS,mid,left);
            step += fStackToStack(record,Action.RToM,Action.MToR,mS,rS,mid,right);
            step += fStackToStack(record,Action.MToR,Action.RToM,rS,mS,right,mid);
        }
        return step;
    }

    private int fStackToStack(Action[] record, Action preNoAct,
                               Action nowAct, Stack<Integer> fStack,
                               Stack<Integer> tStack, String from, String to) {
        if (record[0] != preNoAct && fStack.peek() < tStack.peek()) {
            tStack.push(fStack.pop());
            System.out.println("Move "+tStack.peek() + " from " + from + " to "+to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }
}
