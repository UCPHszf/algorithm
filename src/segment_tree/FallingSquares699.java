package segment_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FallingSquares699 {
    List<Integer> res = new ArrayList<>();
    final int N = 3010;

    class Node {
        int l, r, max_value, c;
    }

    Node[] segment_tree = new Node[N << 2];
    List<Integer> discrete = new ArrayList<>();

    int get(){
        return 0;
    }

    public List<Integer> fallingSquares(int[][] positions) {
        for (int i = 0; i < positions.length; i++) {
            int a = positions[i][0], b = positions[i][1];
            discrete.add(a * 2);
            discrete.add(b * 2);
            discrete.add(a + b);
        }
        Collections.sort(discrete);
        List<Integer> unique_discrete = discrete.stream().distinct().collect(Collectors.toList());

        return res;
    }
}
