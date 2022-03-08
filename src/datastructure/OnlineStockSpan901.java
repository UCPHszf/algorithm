package datastructure;

import java.util.Stack;

public class OnlineStockSpan901 {

    int cur = 0;
    Stack<Integer> days = new Stack<>(), prices = new Stack<>();

    public OnlineStockSpan901() {
        days.add(-1);
        prices.add(1000010);
    }

    public int next(int price) {
        while (prices.peek() <= price) {
            days.pop();
            prices.pop();
        }
        int res = cur - days.peek();
        days.add(cur++);
        prices.add(price);
        return res;
    }
}
