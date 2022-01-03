package linklist;

import datastructure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class CodeInterview6_ReversedPrintLinkList {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> q = new ArrayDeque<>();
        while (head != null) {
            q.addFirst(head.val);
            head = head.next;
        }
        return q.stream().mapToInt(Integer::intValue).toArray();
    }
}
