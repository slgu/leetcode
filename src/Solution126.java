/**
 * Created by slgu1 on 9/16/15.
 */

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)){
            //special judge
            LinkedList < List <String> > result = new LinkedList<List<String>>();
            List <String> item = new LinkedList<String>();
            item.add(beginWord);
            result.add(item);
            return result;
        }
        Queue <String> queue = new LinkedList<String>();

        //map transfer
        Map <String, Set <String> > mpTransfer =  new HashMap<String, Set <String> >();

        //map step
        Map <String, Integer> mpStep = new HashMap<String, Integer>();
        mpStep.put(beginWord, 1);
        queue.add(beginWord);
        wordList.remove(beginWord);
        wordList.add(endWord);
        while (!queue.isEmpty()){
            String nowword = queue.poll();
            if(nowword.equals(endWord))
                break;
            int l = nowword.length();
            int step = mpStep.get(nowword);
            //construct distance-1 new string
            for(int i = 0; i < l; ++i){
                for(int j = 'a'; j <= 'z'; ++j){
                    if(nowword.charAt(i) == j)
                        continue;
                    String moveword = nowword.substring(0,i);
                    moveword += (char)j;
                    moveword += nowword.substring(i + 1);
                    //make sure moveword is in the list
                    if(!wordList.contains(moveword))
                        continue;
                    if(mpStep.containsKey(moveword)){
                        if(mpStep.get(moveword) == step + 1)
                            //add transfer
                            mpTransfer.get(moveword).add(nowword);
                    }
                    else{
                        mpStep.put(moveword,step + 1);
                        mpTransfer.put(moveword, new HashSet<String>());
                        mpTransfer.get(moveword).add(nowword);
                        //in queue
                        queue.add(moveword);
                    }
                }
            }
        }
        if(mpStep.containsKey(endWord)){
            return getResult(endWord, mpTransfer, beginWord);
        }
        else{
            return new LinkedList<List<String>>();
        }
    }

    public static void main(String [] args){
        Solution126 a = new Solution126();
        Set <String> st = new HashSet<String>();
        st.add("hot");
        st.add("dot");
        st.add("dog");
        st.add("lot");
        st.add("log");
        System.out.println(a.findLadders("hit", "cog", st));
    }

    private LinkedList < List <String> > getResult(String word, Map <String, Set <String> > transfer, String start){
        if(word.equals(start)){
            LinkedList < List <String> > result = new LinkedList<List<String>>();
            LinkedList <String> item = new LinkedList<String>();
            item.add(word);
            result.add(item);
            return result;
        }
        LinkedList < List <String> > result = new LinkedList<List<String>>();
        for(String item: transfer.get(word)){
            LinkedList < List <String>> tmp_result = getResult(item,transfer,start);
            for(List <String> list: tmp_result) {
                list.add(word);
                //merge
                result.add(list);
            }
        }
        return result;
    }
}
