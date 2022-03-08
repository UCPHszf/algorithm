package greedy;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestHappyString1405 {

    class Pair {
        int cnt;
        char ch;

        Pair(int cnt, char ch) {
            this.cnt = cnt;
            this.ch = ch;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> q = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
        String res = "";
        Pair pa = new Pair(a, 'a');
        Pair pb = new Pair(b, 'b');
        Pair pc = new Pair(c, 'c');
        q.add(pa);
        q.add(pc);
        q.add(pb);
        int continuous = 0;
        while (!q.isEmpty()) {
            Pair max = q.poll();
            if (max.cnt == 0) {
                return res;
            }
            if (res.length() == 0) {
                //长度为0 直接加上
                res += max.ch;
                continuous++;
                q.add(new Pair(max.cnt - 1, max.ch));
            } else {
                //长度不为0 分别判断
                char last = res.charAt(res.length() - 1);
                //如果res末尾与剩余最多的相同
                if (max.ch == last) {
                    if (continuous < 2) {
                        res += max.ch;
                        continuous++;
                        q.add(new Pair(max.cnt - 1, max.ch));
                    } else {
                        Pair second = q.peek();
                        if (second.cnt == 0) {
                            return res;
                        } else {
                            q.poll();
                            res += second.ch;
                            continuous = 1;
                            q.add(new Pair(second.cnt - 1, second.ch));
                            q.add(max);
                        }
                    }
                } else {
                    res += max.ch;
                    continuous = 1;
                    q.add(new Pair(max.cnt - 1, max.ch));
                }
            }

        }
        return res;
    }

    @Test
    public void testCase1() {
        System.out.println(longestDiverseString(1, 1, 7));
    }
}
