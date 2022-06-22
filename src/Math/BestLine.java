package Math;

import java.util.ArrayList;
import java.util.List;

public class BestLine {
    public int[] bestLine(int[][] points) {
        int[] arr = new int[2];
        int x1, x2, y1, y2;
        int a, b, c;
        int preCount = 0;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int count = 0;
                x1 = points[i][0];
                y1 = points[i][1];
                x2 = points[j][0];
                y2 = points[j][1];
                a = y2 - y1;
                b = x1 - x2;
                c = y1 * (x2 - x1) - x1 * (y2 - y1);
                for (int[] point : points) {
                    if (atLine(a, b, c, point[0], point[1])) {
                        count++;
                    }
                }
                if (count > preCount) {
                    preCount = count;
                    arr[0] = i;
                    arr[1] = j;
                } else if (count == preCount) {
                    if (i == arr[0] && j < arr[1]) {
                        arr[1] = j;
                    }
                }
            }
        }
        return arr;
    }

    public boolean atLine(int a, int b, int c, int x, int y) {
        return a * x + b * y + c == 0;
    }
}
