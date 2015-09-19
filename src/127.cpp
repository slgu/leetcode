/*************************************************************************
    > File Name: 127.cpp
    > Author: Gu Shenlong
    > Mail: blackhero98@gmail.com
    > Created Time: Wed Sep 16 12:38:50 2015
 ************************************************************************/

#include <iostream>
#include <set>
#include <map>
#include <string>
#include <unordered_set>
using namespace std;
class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        if(beginWord == endWord)
            return 1;
        set <string> now_work;
        set <string> next_work;
        map <string, int> mp;
        now_work.insert(endWord);        
        mp[endWord] = 1;
        wordList.erase(endWord);
        now_work.insert(endWord);
        wordList.insert(beginWord);
        while(true){
            for(set <string>::iterator it = now_work.begin(); it != now_work.end(); ++it){
                int l = it->length();
                int step = mp[*it];
                for(int i = 0; i < l; ++i){
                    for(int j = 'a'; j <= 'z'; ++j){
                        if(j == (*it)[i])
                            continue;
                        string s1 = *it;
                        s1[i] = j;
                        //add
                        if(wordList.find(s1) != wordList.end()){
                            next_work.insert(s1);
                            mp[s1] = step + 1;
                            wordList.erase(s1);
                        }
                    }
                }
            }
            if(next_work.size() == 0)
                break;
            if(mp.find(beginWord) != mp.end())
                break;
            now_work.swap(next_work);
            next_work.clear();
        }
        if(mp.find(beginWord) != mp.end())
            return mp[beginWord];
        return 0;
    }
};
int main(){
    Solution a;
    unordered_set <string> st;
    st.insert("hot");
    st.insert("dot");
    st.insert("dog");
    st.insert("lot");
    st.insert("log");
    printf("%d\n", a.ladderLength("hit","cog",st));
}
