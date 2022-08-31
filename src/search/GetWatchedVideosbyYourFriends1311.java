package search;

import java.util.*;

public class GetWatchedVideosbyYourFriends1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        int n = watchedVideos.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        visited[id] = true;
        int curLevel = 0;
        while (!q.isEmpty()) {
            curLevel++;
            if (curLevel > level) break;
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int person = q.poll();
                int[] p_friends = friends[person];
                for (int friend : p_friends) {
                    if (!visited[friend]) {
                        q.add(friend);
                        visited[friend] = true;
                        if (curLevel == level) {
                            for (String movie : watchedVideos.get(friend)) {
                                cnt.put(movie, cnt.getOrDefault(movie, 0) + 1);
                            }
                        }
                    }
                }
            }
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(cnt.entrySet());
        entries.sort((o1, o2) -> {
            if (!Objects.equals(o1.getValue(), o2.getValue())) return o1.getValue().compareTo(o2.getValue());
            else {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        for (Map.Entry<String, Integer> entry : entries) {
            res.add(entry.getKey());
        }
        return res;
    }
}
