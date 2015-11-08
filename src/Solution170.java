import java.util.HashMap;

/**
 * Created by slgu1 on 10/23/15.
 */
class TwoSum {

    // Add the number to an internal data structure.
    public void add(int number) {
        if (mp.containsKey(number)) {
            mp.put(number, mp.get(number) + 1);
        }
        else {
            mp.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        boolean flg = false;
        for (Integer key: mp.keySet()) {
            int extra = value - key;
            if (extra == key) {
                if (mp.get(key) >= 2) {
                    flg = true;
                    break;
                }
            }
            else {
                if (mp.containsKey(extra)) {
                    flg = true;
                    break;
                }
            }
        }
        return flg;
    }
    HashMap <Integer, Integer> mp = new HashMap<Integer, Integer>();
}

public class Solution170 {
    public static void main(String [] args) {
        TwoSum a = new TwoSum();
        a.add(1);
        a.add(1);
        a.add(3);
        a.add(5);
        System.out.println(a.find(4));
        System.out.println(a.find(7));
        System.out.println(a.find(2));
        System.out.println(a.find(10));
    }
}
