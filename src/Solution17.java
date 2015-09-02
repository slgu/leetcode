import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/3/15.
 */

import java.util.*;

public class Solution17 {
    static ArrayList<Integer> digit_arr = new ArrayList<Integer>();
    static ArrayList<Integer> map_digit_letter = new ArrayList<Integer>();
    static{
        for(int i = 0; i < 5; ++i) {
            map_digit_letter.add(i * 3);
            digit_arr.add(3);
        }
        map_digit_letter.add(15);
        map_digit_letter.add(19);
        map_digit_letter.add(22);
        digit_arr.add(4);
        digit_arr.add(3);
        digit_arr.add(4);
    }
    public List<String> letterCombinations(String digits){
        if (digits.compareTo("") == 0){
            return new ArrayList<String>();
        }
        int combine_num = 1;
        for(int i = 0; i < digits.length(); ++i){
            combine_num *= digit_arr.get(digits.charAt(i) - '2');
        }
        List <String> result_str_arr = new LinkedList<String>();
        for(int cnt = 0; cnt < combine_num; ++cnt){
            int now_str_num = cnt;
            StringBuilder str_builder = new StringBuilder();
            for(int i = digits.length() - 1; i >= 0; --i){
                int now_possible_num = digit_arr.get(digits.charAt(i) - '2');
                str_builder.append((char)(map_digit_letter.get(digits.charAt(i) - '2') + (now_str_num % now_possible_num) + 'a'));
                now_str_num /= now_possible_num;
            }
            str_builder.reverse();
            result_str_arr.add(str_builder.toString());
        }
        return result_str_arr;
    }
    public static void main(String [] args){
        Solution17 a = new Solution17();
        List <String> res = a.letterCombinations("23");
        for(String item: res){
            System.out.println(item);
        }
    }
}
