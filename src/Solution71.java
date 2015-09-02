import util.ListNode;
import util.ListUtil;
/**
 * Created by gsl on 7/21/15.
 */

import java.util.*;
public class Solution71 {
    public String simplifyPath(String path) {
        Stack <String> path_stack = new Stack<String>();
        int len = path.length();
        if(path.charAt(len - 1) != '/')
            path = path + '/';
        int last = 1;
        while(true){
            //get next path_dir
            int idx = path.indexOf('/', last);
            if(idx == -1){
                //end
                break;
            }
            String path_dir = path.substring(last, idx);
            if(path_dir.equals("..")){
                //nothing to do for arrive root
                if(path_stack.empty()){

                }
                else {
                    //pop
                    path_stack.pop();
                }
            }
            else if(path_dir.equals(".") || path_dir.equals("")){
                //nothing to do
            }
            else{
                path_stack.push(path_dir);
            }
            last = idx + 1;
        }
        //special judge for root
        if(path_stack.empty()){
            return "/";
        }
        StringBuilder result_path_builder = new StringBuilder();
        while(!path_stack.empty()){
            String path_dir = path_stack.pop();
            int tmp_len = path_dir.length();
            for(int i = tmp_len - 1; i >= 0; --i)
                result_path_builder.append(path_dir.charAt(i));
            result_path_builder.append('/');
        }
        return result_path_builder.reverse().toString();
    }
    public static void main(String[] args) {
        Solution71 a = new Solution71();
        System.out.println(a.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
    }
}