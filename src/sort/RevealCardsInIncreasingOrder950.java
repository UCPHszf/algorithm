package sort;

import java.util.*;

public class RevealCardsInIncreasingOrder950 {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            q.add(i);
        }
        int[] res = new int[deck.length];
        int k = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            res[i] = deck[k++];
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        return res;
    }
}
