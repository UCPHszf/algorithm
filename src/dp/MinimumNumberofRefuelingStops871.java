package dp;

import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int res = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] arr : stations) {
            int dist = arr[0], fuel = arr[1];
            while (!heap.isEmpty() && startFuel < dist) {
                
            }
        }
    }
}
