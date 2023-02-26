package leetcode.editor.cn;//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics 栈 链表 数学 👍 585 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//import datastructure.ListNode;

import datastructure.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddToNumber445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), s3 = new Stack<>();
        ListNode i1 = l1, i2 = l2;
        while (i1 != null) {
            s1.add(i1.val);
            i1 = i1.next;
        }
        while (i2 != null) {
            s2.add(i2.val);
            i2 = i2.next;
        }
        int extra = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int v1 = s1.pop(), v2 = s2.pop();
            int sum = v1 + v2 + extra;
            s3.add(sum % 10);
            extra = sum / 10;
        }
        while (!s1.isEmpty()) {
            int v1 = s1.pop();
            int sum = v1 + extra;
            s3.add(sum % 10);
            extra = sum / 10;
        }
        while (!s2.isEmpty()) {
            int v2 = s2.pop();
            int sum = v2 + extra;
            s3.add(sum % 10);
            extra = sum / 10;
        }
        if (extra != 0) s3.add(extra);
        ListNode res = new ListNode(s3.pop());
        ListNode iter = res;
        while (!s3.isEmpty()) {
            ListNode node = new ListNode(s3.pop());
            iter.next = node;
            iter = iter.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
