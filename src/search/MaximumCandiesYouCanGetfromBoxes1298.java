package search;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumCandiesYouCanGetfromBoxes1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        int BOX_OPEN = 1;
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] isKeyGet = new boolean[n];
        boolean[] isBoxGet = new boolean[n];
        boolean[] isVisited = new boolean[n];
        for (int boxIdx : initialBoxes) {
            isBoxGet[boxIdx] = true;
            if (status[boxIdx] == BOX_OPEN) {
                q.add(boxIdx);
                isVisited[boxIdx] = true;
            }
        }
        while (!q.isEmpty()) {
            int idx = q.poll();
            //get candies
            res += candies[idx];
            //get keys
            int[] box_keys = keys[idx];
            for (int key : box_keys) {
                isKeyGet[key] = true;
                if (isBoxGet[key] && !isVisited[key]) {
                    q.add(key);
                    isVisited[key] = true;
                }
            }
            //get boxes
            int[] boxes = containedBoxes[idx];
            for (int box : boxes) {
                isBoxGet[box] = true;
                if ((isKeyGet[box] || status[box] == 1) && !isVisited[box]) {
                    q.add(box);
                    isVisited[box] = true;
                }
            }
        }
        return res;
    }
}
