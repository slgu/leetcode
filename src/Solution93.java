/**
 * Created by slgu1 on 9/3/15.
 */
import java.util.LinkedList;
import java.util.List;
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        n = s.length();
        dfs(0);
        stacklist.clear();
        resultip.clear();
        dfs(0);
        System.out.println(resultip);
        return resultip;
    }
    public static void main(String[] args){
        Solution93 a = new Solution93();
        a.restoreIpAddresses("25525511135");
    }
    private LinkedList <String> stacklist = new LinkedList<String>();
    private LinkedList <String> resultip = new LinkedList<String>();
    private String makeip(List <String> strlist){
        return String.join(".", strlist);
    }
    private String s;
    private int n;
    private void dfs(int x){
        int nowsize = stacklist.size();
        //cut
        if((n - x) < (4 - nowsize) || (n - x) > 3 * (4 - nowsize))
            return;
        if(nowsize == 3){
            //all in

            //not valid digit
            if(s.charAt(x) == '0'  && x != n - 1)
                return;
            int next_int = Integer.parseInt(s.substring(x));
            if(next_int >= 0 && next_int <= 255){
                //valid
                stacklist.add(s.substring(x));
                resultip.add(makeip(stacklist));
                stacklist.removeLast();
                return;
            }
        }
        int nownum = 0;
        for(int i = x;i < n;++i){
            int digit = s.charAt(i) - '0';
            nownum = 10 * nownum + digit;
            //not valid digit
            if(s.charAt(x) == '0' && i != x)
                break;
            if(nownum >= 0 && nownum <= 255){
                stacklist.add(s.substring(x,i + 1));
                dfs(i + 1);
                stacklist.removeLast();
            }
        }
    }
}

