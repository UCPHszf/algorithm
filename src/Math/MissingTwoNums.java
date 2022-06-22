package Math;

public class MissingTwoNums {
    public int[] missingTwo(int[] nums) {
        int l = nums.length + 2;
        int s = ((l + 1) * l) / 2;
        int missingTwoSquareSum = 0;
        for (int num : nums) {
            s -= num;
            missingTwoSquareSum -= num * num;
        }
        for (int i = 1; i <= l; i++) {
            missingTwoSquareSum += i * i;
        }
        int p = (s * s - missingTwoSquareSum) / 2;
        double delta = Math.sqrt(s * s - 4 * p);
        int x1 = (int) ((s + delta) / 2), y1 = s - x1;
        int x2 = (int) ((s - delta) / 2), y2 = s - x2;
        if (x1 > 0 && y1 > 0) return new int[]{x1, y1};
        else return new int[]{x2, y2};
    }
}
