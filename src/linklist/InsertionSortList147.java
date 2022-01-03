package linklist;

import datastructure.ListNode;

public class InsertionSortList147 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode iter = dummy.next;
        while (iter != null) {
            ListNode ne = iter.next;
            if (ne != null) {
                if (ne.val > iter.val) {
                    iter = iter.next;
                } else {
                    if (ne.val < dummy.next.val) {
                        iter.next = ne.next;
                        ne.next = dummy.next;
                        dummy.next = ne;
                    } else {
                        ListNode tmp = dummy.next;
                        while (!((tmp.val < ne.val) && (tmp.next.val > ne.val))) {
                            tmp = tmp.next;
                        }
                        ListNode nene = ne.next;
                        ne.next = tmp.next;
                        tmp.next = ne;
                        iter.next = nene;
                    }
                }
            } else {
                break;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 7, 4, 5, 3};
        ListNode iter = new ListNode(arr[0]);
        ListNode node = iter;
        for (int i = 1; i < arr.length; i++) {
            ListNode tmp = new ListNode(arr[i]);
            iter.next = tmp;
            iter = iter.next;
        }
        ListNode res = insertionSortList(node);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
