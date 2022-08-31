package dp;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class NumberofPathswithMaxScore1301 {
    int MOD = (int) (1e9 + 7);

    public int[] pathsWithMaxScore(List<String> board) {
        //init board
        int n = board.get(0).length();
        char[][] Board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = board.get(i);
            for (int j = 0; j < n; j++) {
                Board[i][j] = s.charAt(j);
            }
        }

        //init cnt board
        Object[][] cnt = new Object[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[i][j] = new int[2];
            }
        }
        int[] start = (int[]) cnt[n - 1][n - 1];
        start[0] = 0;
        start[1] = 1;

        //init last row
        for (int i = n - 2, sum = 0; i >= 0; i--) {
            if (Board[n - 1][i] == 'X') {
                break;
            }
            int[] cur = (int[]) cnt[n - 1][i];
            int val = Board[n - 1][i] - '0';
            sum += val;
            cur[0] = sum;
            cur[1] = 1;
        }

        //init last column
        for (int i = n - 2, sum = 0; i >= 0; i--) {
            if (Board[i][n - 1] == 'X') {
                break;
            }
            int[] cur = (int[]) cnt[i][n - 1];
            int val = Board[i][n - 1] - '0';
            sum += val;
            cur[0] = sum;
            cur[1] = 1;
        }

        // dynamic process
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (Board[i][j] == 'X') continue;
                char ch = Board[i][j];
                int val;
                if (ch == 'E' || ch == 'S') val = 0;
                else val = ch - '0';
                int[] cur = (int[]) cnt[i][j];
                int[] right = (int[]) cnt[i + 1][j];
                int[] bottom = (int[]) cnt[i][j + 1];
                int[] rightBottom = (int[]) cnt[i + 1][j + 1];
                int[] pairUpdateFrom = compareAndGetMax(right, bottom, rightBottom);
                if (pairUpdateFrom[1] == 0) {
                    cur[0] = 0;
                } else {
                    cur[0] = pairUpdateFrom[0] + val;
                }
                cur[1] = pairUpdateFrom[1];
            }
        }
        int[] end = (int[]) cnt[0][0];
        return end;
    }

    public int[] compareAndGetMax(int[] right, int[] bottom, int[] rightBottom) {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        q.add(right);
        q.add(bottom);
        q.add(rightBottom);
        int[] res = q.poll();
        int maxVal = res[0];
        while (!q.isEmpty()) {
            int[] pair = q.peek();
            if (pair[0] == maxVal) {
                res[1] = (res[1] + pair[1]) % MOD;
            }
            q.poll();
        }
        return res;
    }
}
