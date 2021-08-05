package linklist;

import datastructure.ListNode;

public class ReverseLinkedListII92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode iter=dummy;
        for(int i=0;i<left-1;i++){
            iter=iter.next;
        }
        ListNode a=iter.next;
        ListNode b=a.next;
        for(int i=0;i<right-left;i++){
            ListNode t=b.next;
            b.next=a;
            a=b;
            b=t;
        }
        iter.next.next=b;
        iter.next=a;
        return dummy.next;
    }
}
