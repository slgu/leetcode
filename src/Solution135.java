import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by slgu1 on 9/22/15.
 */
//TODO write in the blog
public class Solution135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        ArrayList <Integer> updownlist = new ArrayList<Integer>();
        ArrayList <Integer> directlist = new ArrayList<Integer>();
        int down = 0;
        int up = 0;
        int middle = 0;
        for (int i = 1; i < n; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                if (down != 0) {
                    updownlist.add(down + 1);
                    //down
                    directlist.add(1);
                    down = 0;
                    up = 1;
                }
                else if (middle != 0) {
                    updownlist.add(middle + 1);
                    //middle
                    directlist.add(2);
                    middle = 0;
                    up = 1;
                }
                else {
                    ++up;
                }
            }
            else if (ratings[i] == ratings[i - 1]) {
                if (down != 0) {
                    updownlist.add(down + 1);
                    //down
                    directlist.add(1);
                    down = 0;
                    middle = 1;
                }
                else if (up != 0) {
                    updownlist.add(up + 1);
                    //up
                    directlist.add(0);
                    up = 0;
                    middle = 1;
                }
                else {
                    ++middle;
                }
            }
            else {
                if (up != 0) {
                    updownlist.add(up + 1);
                    //up
                    directlist.add(0);
                    up = 0;
                    down = 1;
                }
                else if (middle != 0) {
                    updownlist.add(middle + 1);
                    //middle
                    directlist.add(2);
                    middle = 0;
                    down = 1;
                }
                else {
                    ++down;
                }
            }
        }
        if (up != 0) {
            updownlist.add(up + 1);
            directlist.add(0);
        }
        else if (middle != 0) {
            updownlist.add(middle + 1);
            directlist.add(2);
        }
        else if (down != 0) {
            updownlist.add(down + 1);
            directlist.add(1);
        }
        int lastval = 1;
        int updown_n = updownlist.size();
        int interval;
        int total = 0;
        for (int i = 0; i < updown_n; ++i) {
            interval = updownlist.get(i);
            //System.out.println(String.format("%d %d", interval,directlist.get(i)));
            switch (directlist.get(i)) {
                //up
                case 0:
                    total += interval  * (interval + 2 * lastval - 1) / 2;
                    if (i != 0)
                        total -= lastval;
                    lastval = interval + lastval - 1;
                    break;
                //down
                case 1:
                    if (i == 0) {
                        total += interval * (interval + 1) / 2;
                        break;
                    }
                    if (lastval > interval) {
                        total += interval * (interval - 1) / 2;
                    }
                    else {
                        total -= lastval;
                        total += (interval + 1) * interval / 2;
                    }
                    lastval = 1;
                    break;
                //middle
                case 2:
                    lastval = 1;
                    total += interval;
                    if (i != 0)
                        --total;
                    break;
            }
        }
        return total;
    }
    public static void main(String [] args) {
        Solution135 a = new Solution135();
        int n = 20000;
        int [] b = new int[n];
        for (int i = 0; i < n; ++i)
            b[i] = n - i;
        System.out.println(a.candy(b));
    }
}
