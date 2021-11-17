package Math;

public class ClosestDivisors1362 {
    public int[] closestDivisors(int num) {
        int num1 = num + 1, num2 = num + 2;
        int diff1 = Integer.MAX_VALUE, diff2 = Integer.MAX_VALUE;
        int[] res1 = new int[2], res2 = new int[2];
        for (double i = Math.ceil(Math.sqrt(num1)); i >= 1; i--) {
            if (num1 % i == 0) {
                diff1 = (int) Math.abs(Math.min(diff1, i - (num1 / i)));
                res1[0] = (int) i;
                res1[1] = (int) (num1 / i);
                break;
            }
        }
        for (double i = Math.ceil(Math.sqrt(num2)); i >= 1; i--) {
            if (num2 % i == 0) {
                diff2 = (int) Math.abs(Math.min(diff2, i - (num2 / i)));
                res2[0] = (int) i;
                res2[1] = (int) (num2 / i);
                break;
            }
        }
        return diff1 > diff2 ? res2 : res1;
    }
}
