package design;

import java.util.Stack;

public class SortedStack {

    Stack<Integer> tmp;
    Stack<Integer> s;

    public SortedStack() {
        tmp = new Stack<>();
        s = new Stack<>();
    }

    public void push(int val) {
        if (isEmpty() || val < peek()) s.add(val);
        else {
            while (!isEmpty() && peek() < val) {
                tmp.add(s.pop());
            }
            s.add(val);
            while (!tmp.isEmpty()) s.add(tmp.pop());
        }
    }

    public void pop() {
        if (!isEmpty()) s.pop();
    }

    public int peek() {
        if (!s.isEmpty()) return s.peek();
        return -1;
    }

    public boolean isEmpty() {
        return s.isEmpty();
    }
}
