package linklist;

import datastructure.ListNode;

public class ReverseNodesinkGroup25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode p = dummy; ; ) {
            ListNode q = p;
            for (int i = 0; i < k && q != null; i++) {
                q=q.next;
            }
            if(q==null)break;
            ListNode a=p.next,b=a.next;
            for(int i=0;i<k-1;i++){
                ListNode c=b.next;
                b.next=a;
                a=b;
                b=c;
            }
            ListNode c=p.next;
            p.next=a;
            c.next=b;
            p=c;
        }
        return dummy.next;
    }
}
