package arr;

import java.util.HashMap;

public class SnapshotArray1146 {

    HashMap<Integer, HashMap<Integer, Integer>> snapshots;
    HashMap<Integer, Integer> updateLog;
    int[] arr;
    int snap_id = 0;

    public SnapshotArray1146(int length) {
        arr = new int[length];
        updateLog = new HashMap<>();
        snapshots = new HashMap<>();
    }

    public void set(int index, int val) {
        updateLog.put(index, val);
    }

    public int snap() {
        snapshots.put(snap_id, updateLog);
        snap_id++;
        return snap_id;
    }

    public int get(int index, int snap_id) {
        HashMap<Integer, Integer> snapshot = snapshots.get(snap_id);
        if (snapshot.containsKey(index)) {
            return snapshot.get(index);
        }
        return 0;
    }
}
