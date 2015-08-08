/**
 * Created by gsl on 8/8/15.
 */

import java.util.*;

public class Solution75 {
    public void sortColors(int[] nums) {
        int num_of_red = 0;
        int num_of_white = 0;
        int num_of_blue = 0;
        for(int i = 0; i < nums.length; ++i){
            switch (nums[i]){
                case 0: ++num_of_red;break;
                case 1: ++num_of_white;break;
                case 2: ++num_of_blue;break;
            }
        }
        for(int i = 0; i < nums.length; ++i){
            if(i < num_of_red) nums[i] = 0;
            else if(i < num_of_red + num_of_white) nums[i] = 1;
            else nums[i] = 2;
        }
    }
    public static void main(String[] args) {
    }
}
