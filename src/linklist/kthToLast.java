package linklist;

import datastructure.ListNode;

public class kthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode l1 = head, l2 = head;
        for (int i = 0; i < k - 1; i++) l2 = l2.next;
        while (l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1.val;
    }
}
