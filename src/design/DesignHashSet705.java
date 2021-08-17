package design;

import java.util.LinkedList;

public class DesignHashSet705 {
    /**
     * Initialize your data structure here.
     */
    LinkedList[] lists;
    static final int N = 19997;

    public DesignHashSet705() {
        lists=new LinkedList[N];
    }

    public void add(int key) {
        int t = key % N;
        if (lists[t] == null) {
            lists[t] = new LinkedList<>();
        } else {
            if (lists[t].contains(key)) return;
        }
        lists[t].add(key);
    }

    public void remove(int key) {
        int t = key % N;
        if (lists[t] == null) return;
        else {
            if (contains(key)){
                int index=lists[t].indexOf(key);
                lists[t].remove(index);
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int t = key % N;
        if (lists[t] == null) return false;
        return lists[t].contains(key);
    }
}
