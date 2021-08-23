package linklist;

import datastructure.ListNode;

import java.util.PriorityQueue;

public class MergeKSortedList24 {
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        public Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

    PriorityQueue<Status> q = new PriorityQueue<>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node : lists) {
            if (node != null) {
                q.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!q.isEmpty()) {
            Status s = q.poll();
            tail.next = s.ptr;
            tail = tail.next;
            if (s.ptr.next != null) {
                q.offer(new Status(s.ptr.next.val, s.ptr.next));
            }
        }
        return head.next;
    }
}
