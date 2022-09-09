package leetcode.editor.cn;//设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针
///引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。 
//
// 在链表类中实现这些功能： 
//
// 
// get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。 
// addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。 
// addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。 
// addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val 的节点。如果 index 等于链表的长度，则该节点将附加
//到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。 
// deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。 
// 
//
// 
//
// 示例： 
//
// MyLinkedList linkedList = new MyLinkedList();
//linkedList.addAtHead(1);
//linkedList.addAtTail(3);
//linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
//linkedList.get(1);            //返回2
//linkedList.deleteAtIndex(1);  //现在链表是1-> 3
//linkedList.get(1);            //返回3
// 
//
// 
//
// 提示： 
//
// 
// 所有val值都在 [1, 1000] 之内。 
// 操作次数将在 [1, 1000] 之内。 
// 请不要使用内置的 LinkedList 库。 
// 
//
// Related Topics 设计 链表 👍 557 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class MyLinkedList {

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    Node head;

    public MyLinkedList() {
        head = null;
    }

    public int get(int index) {
        if (index < 0) return -1;
        Node iter = head;
        for (int i = 0; i < index && iter != null; i++) {
            iter = iter.next;
        }
        if (iter == null) return -1;
        return iter.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void addAtTail(int val) {
        if (head == null) head = new Node(val);
        else {
            Node iter = head;
            while (iter.next != null) iter = iter.next;
            iter.next = new Node(val);
        }
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) addAtHead(val);
        else {
            int len = 0;
            for (Node iter = head; iter != null; iter = iter.next) {
                len++;
            }
            if (index == len) addAtTail(val);
            else if (index < len) {
                Node iter = head;
                for (int i = 0; i < index - 1; i++) iter = iter.next;
                Node node = new Node(val);
                node.next = iter.next;
                iter.next = node;
            }
        }
    }

    public void deleteAtIndex(int index) {
        int len = 0;
        for (Node iter = head; iter != null; iter = iter.next) {
            len++;
        }
        if (index >= 0 && index < len) {
            if (index == 0) head = head.next;
            else {
                Node iter = head;
                for (int i = 0; i < index - 1; i++) {
                    iter = iter.next;
                }
                iter.next = iter.next.next;
            }
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
//leetcode submit region end(Prohibit modification and deletion)
