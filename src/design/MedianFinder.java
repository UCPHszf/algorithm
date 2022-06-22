package design;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

    public void addNum(int num) {
        if (min.isEmpty()) {
            min.add(num);
        } else {
            if (num < min.peek()) {
                max.add(num);
                if (max.size() > min.size() + 1) {
                    min.add(max.poll());
                }
            } else {
                min.add(num);
                if (min.size() > max.size() + 1) {
                    max.add(min.poll());
                }
            }
        }
    }

    public double findMedian() {
        if (max.isEmpty()) {
            return min.peek();
        } else {
            if (min.size() == max.size()) {
                double a = min.peek();
                double b = max.peek();
                return (a + b) / 2;
            } else {
                if (min.size() > max.size()) return min.peek();
                else return max.peek();
            }
        }
    }
}
