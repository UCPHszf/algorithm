package search;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutation433 {
    public int minMutation(String start, String end, String[] bank) {
        boolean[] visit = new boolean[bank.length];
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int res = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String str = q.poll();
                if (str.equals(end)) {
                    return res;
                }
                for(int j=0;j< bank.length;j++){
                    if(isReachable(str,bank[j])&&!visit[j]){
                        visit[j]=false;
                        q.add(bank[j]);
                    }
                }
            }
            res++;
        }
        return -1;
    }

    boolean isReachable(String a, String b) {
        int tmp = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                tmp++;
                if (tmp == 2) return false;
            }
        }
        return tmp == 1;
    }
}
