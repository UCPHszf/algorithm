package greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> list = Arrays.stream(flowerbed).boxed().collect(Collectors.toList());
        list.add(0, 0);
        list.add(0, 1);
        list.add(0, 0);
        list.add(list.size(), 0);
        list.add(list.size(), 1);
        list.add(list.size(), 0);
        int sum = 0;
        for (int i = 3; i < flowerbed.length; i++) {
            if (list.get(i) == 0) {
                if (list.get(i - 1) == 0 && list.get(i + 1) == 0) sum++;
                list.set(i, 1);
                if (sum == n) return true;
            }
        }
        return sum >= n;
    }
}
