package leetcode.editor.cn;//请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
//
// 请你完成 FrontMiddleBack 类： 
//
// 
// FrontMiddleBack() 初始化队列。 
// void pushFront(int val) 将 val 添加到队列的 最前面 。 
// void pushMiddle(int val) 将 val 添加到队列的 正中间 。 
// void pushBack(int val) 将 val 添加到队里的 最后面 。 
// int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。 
// 
//
// 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说： 
//
// 
// 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。 
// 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", 
//"popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
//[[], [1], [2], [3], [4], [], [], [], [], []]
//输出：
//[null, null, null, null, null, 1, 3, 4, 2, -1]
//
//解释：
//FrontMiddleBackQueue q = new FrontMiddleBackQueue();
//q.pushFront(1);   // [1]
//q.pushBack(2);    // [1, 2]
//q.pushMiddle(3);  // [1, 3, 2]
//q.pushMiddle(4);  // [1, 4, 3, 2]
//q.popFront();     // 返回 1 -> [4, 3, 2]
//q.popMiddle();    // 返回 3 -> [4, 2]
//q.popMiddle();    // 返回 4 -> [2]
//q.popBack();      // 返回 2 -> []
//q.popFront();     // 返回 -1 -> [] （队列为空）
// 
//
// 
//
// 提示： 
//
// 
// 1 <= val <= 10⁹ 
// 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。 
//
// 
//
// Related Topics 设计 队列 数组 链表 数据流 👍 29 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class FrontMiddleBackQueue {

    class LN {
        int val;
        LN next;

        LN(int val) {
            this.val = val;
        }

        LN(int val, LN next) {
            this.val = val;
            this.next = next;
        }
    }

    LN head;
    int size;

    public FrontMiddleBackQueue() {
        head = new LN(-1);
        size = 0;
    }

    public void pushFront(int val) {
        LN ne = head.next;
        LN newLN = new LN(val, ne);
        head.next = newLN;
        newLN.next = ne;
        size++;
    }

    public void pushMiddle(int val) {
        int mid = size / 2;
        LN cur = head;
        while (mid > 0) {
            cur = cur.next;
            mid--;
        }
        LN ne = cur.next;
        LN newLN = new LN(val);
        cur.next = newLN;
        newLN.next = ne;
        size++;
    }

    public void pushBack(int val) {
        LN newLN = new LN(val);
        LN cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newLN;
        size++;
    }

    public int popFront() {
        if (head.next == null) {
            return -1;
        }
        LN ne = head.next;
        head.next = ne.next;
        size--;
        return ne.val;
    }

    public int popMiddle() {
        if (head.next == null) return -1;
        LN cur = head;
        int mid = size % 2 == 0 ? (size / 2) - 1 : size / 2;
        while (mid > 0) {
            mid--;
            cur = cur.next;
        }
        LN ne = cur.next;
        cur.next = ne.next;
        size--;
        return ne.val;
    }

    public int popBack() {
        if (head.next == null) {
            return -1;
        }
        LN cur = head;
        while (cur.next.next != null) {
            cur = cur.next;
        }
        int val = cur.next.val;
        cur.next = null;
        size--;
        return val;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
//leetcode submit region end(Prohibit modification and deletion)
