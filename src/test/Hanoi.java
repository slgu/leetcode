package test;

import java.util.Stack;

/**
 * Created by slgu1 on 10/17/15.
 */
class Tower {
    public Tower(int idx) {
        this.idx = idx;
    }

    public int getIdx() {
        return idx;
    }

    public void moveToTower(Tower another) {
        int tmp = st.pop();
        another.push(tmp);
        //move details
        System.out.println(String.format("move from idx:%d to idx:%d\n", getIdx(), another.getIdx()));
    }

    public void push(Integer i) {
        st.push(i);
    }

    public void moveAll(int n, Tower des, Tower buff) {
        if (n == 0)
            return;
        moveAll(n - 1, buff, des);
        moveToTower(des);
        buff.moveAll(n - 1, des, this);
    }
    private int idx;
    private Stack <Integer> st = new Stack<Integer>();
}

public class Hanoi {
    public static void moveHanoi(int n) {
        Tower [] towers = new Tower[3];
        towers[0] = new Tower(0);
        towers[1] = new Tower(1);
        towers[2] = new Tower(2);
        for (int i = 0; i < n; ++i)
            towers[0].push(i);
        towers[0].moveAll(n, towers[2], towers[1]);
    }
    public static void main(String [] args) {
        moveHanoi(3);
    }
}
