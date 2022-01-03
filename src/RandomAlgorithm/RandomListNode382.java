package RandomAlgorithm;

import datastructure.ListNode;

import java.util.Random;

public class RandomListNode382 {
    ListNode h;

    public RandomListNode382(ListNode head) {
        h = head;
    }

    public int getRandom() {
        int c=-1,n=0;
        for (ListNode l=h;h!=null;h=h.next){
            n++;
            if(new Random().nextInt(n+1)%n==0){
                c=l.val;
            }
        }
        return c;
    }
}
