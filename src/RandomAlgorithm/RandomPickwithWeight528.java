package RandomAlgorithm;

import java.util.Random;

public class RandomPickwithWeight528 {


    int[] preSum;

    public RandomPickwithWeight528(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
    }


    public int pickIndex() {
        int x = (int) ((Math.random() * preSum[preSum.length - 1]) + 1);
        int l = 0, r = preSum.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (x <= preSum[mid]) r = mid;
            else l = mid + 1;
            if (l < preSum.length && preSum[l] < x) l++;
        }
        return l;
    }
}
