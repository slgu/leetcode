import util.ListNode;
import util.ListUtil;
import org.omg.CORBA.DATA_CONVERSION;

import java.util.*;

class LRUCache {

    static class Datanode{
        Datanode prev = null;
        Datanode next = null;
        int value;
        int key;
        Datanode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    static class Mylinkedlist{
        Datanode head = null;
        Datanode last = null;
        void addLast(Datanode datanode){
            if(head == null){
                head = datanode;
                last = datanode;
                return;
            }
            last.next = datanode;
            datanode.prev = last;
            datanode.next = null;
            last = datanode;
        }
        void debug(){
            Datanode tmp = head;
            while(tmp != null){
                System.out.print(tmp.value);
                System.out.print(' ');
                tmp = tmp.next;
            }
            System.out.println("");
        }
        void addFirst(Datanode datanode){
            if(head == null){
                head = datanode;
                last = datanode;
                return;
            }
            datanode.prev = null;
            datanode.next = head;
            head.prev = datanode;
            head = datanode;
        }
        void remove(Datanode datanode){
            if(datanode.prev != null){
                datanode.prev.next = datanode.next;
            }
            else{
                //IMPORTANT TO SET
                head = datanode.next;
            }
            if(datanode.next != null){
                datanode.next.prev = datanode.prev;
            }
            else {
                //IMPORTANT TO SET
                last = datanode.prev;
            }
        }
        Datanode popLast(){
            Datanode result = last;
            if(last != null){
                if(head == last) {
                    head = null;
                    last = null;
                }
                else{
                    last = last.prev;
                    last.next = null;
                }
            }
            return result;
        }
        Datanode popFirst(){
            Datanode result = head;
            if(head != null){
                if(head == last){
                    head = null;
                    last = null;
                }
                else{
                    head = head.next;
                    head.prev = null;
                }
            }
            return result;
       }
    }
    int capacity;
    int usage = 0;
    Mylinkedlist lru_list = new Mylinkedlist();
    HashMap <Integer, Datanode> dict = new HashMap<Integer, Datanode>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(dict.containsKey(key)){
            Datanode data = dict.get(key);
            lru_list.remove(data);
            lru_list.addLast(data);
            return data.value;
        }
        return -1;
    }
    public static void test(){
        Mylinkedlist a = new Mylinkedlist();
        a.addLast(new Datanode(2,4));
        a.addLast(new Datanode(3,3));
        a.addLast(new Datanode(4,5));
        a.popFirst();
        a.debug();
        a.popFirst();
        a.debug();
        a.popFirst();
        a.debug();
    }
    public void set(int key, int value) {
        if(dict.containsKey(key)){
            //reorder lru_list
            Datanode datanode = dict.get(key);
            lru_list.remove(datanode);
            //set new value
            datanode.value = value;
            lru_list.addLast(datanode);
        }
        else{
            if(usage == capacity){
                Datanode node_delete = lru_list.popFirst();
                dict.remove(node_delete.key);
                --usage;
            }
            Datanode new_data = new Datanode(key, value);
            dict.put(key, new_data);
            lru_list.addLast(new_data);
            ++usage;
        }
    }
}

public class Solution146{
    public static void main(String [] args){
        LRUCache cache = new LRUCache(2);
        cache.set(2,1);
        cache.set(2,2);
        System.out.println(cache.get(2));
        cache.set(1, 1);
        cache.set(4, 1);
        cache.get(2);
        System.out.println(cache.get(2));
    }
}