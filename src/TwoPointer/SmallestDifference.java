package TwoPointer;

import java.util.Arrays;

public class SmallestDifference {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int pa = 0, pb = 0;
        long diff = Math.abs(b[pb] - a[pa]);
        System.out.println(diff);
        while (pa < a.length && pb < b.length) {
            if (a[pa] < b[pb]) {
                pa++;
            } else {
                pb++;
            }
            System.out.println(Math.abs(b[pb] - a[pa]));
            diff = Math.min(diff, Math.abs(b[pb] - a[pa]));
        }
        while (pa < a.length) {
            pa++;
            diff = Math.min(diff, Math.abs(b[pb] - a[pa]));
        }
        while (pb < b.length) {
            pb++;
            diff = Math.min(diff, Math.abs(b[pb] - a[pa]));
        }
        return (int)diff;
    }
}
