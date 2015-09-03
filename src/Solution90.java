/**
 * Created by slgu1 on 9/2/15.
 */
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //special judge
        if(nums.length == 0)
            return new LinkedList< List <Integer>>();
        //init
        Arrays.sort(nums);
        uniquenum.clear();
        uniquenumcount.clear();
        n = nums.length;
        resultlist.clear();

        //unique
        int count = 1;
        for(int i = 1; i < n; ++i){
            if(nums[i] != nums[i - 1]){
                uniquenum.add(nums[i - 1]);
                uniquenumcount.add(count);
                count = 1;
            }
            else{
                ++count;
            }
        }
        uniquenum.add(nums[n - 1]);
        uniquenumcount.add(count);
        n = uniquenum.size();
        //dfs
        dfs(0);
        return resultlist;
    }

    private void dfs(int x){
        if(x >= n){
            resultlist.add((List <Integer>)stacklist.clone());
            return;
        }
        int thisnum = uniquenumcount.get(x);
        dfs(x + 1);
        for(int i = 0; i < thisnum; ++i){
            stacklist.add(uniquenum.get(x));
            dfs(x + 1);
        }

        //backtracking
        for(int i = 0; i < thisnum; ++i)
            stacklist.removeLast();
    }

    private ArrayList <Integer> uniquenum = new ArrayList<Integer>();
    private ArrayList <Integer> uniquenumcount = new ArrayList<Integer>();
    private int n;
    private LinkedList <Integer> stacklist = new LinkedList<Integer>();
    private LinkedList <List<Integer>> resultlist = new LinkedList<List<Integer>> ();
    public static void main(String [] args){
        Solution90 a = new Solution90();
        System.out.println(a.subsetsWithDup(new int[]{1, 2, 2}));
    }
}