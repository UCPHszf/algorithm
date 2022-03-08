package Math;

public class SuperPow372 {
    public int superPow(int a, int[] b) {
        if (a <= 1) return a;
        int MOD = 1337;
        int sumPow = 0;
        for (int i = b.length - 1, pow = 0; i >= 0; i--) {
            sumPow += b[i] * Math.pow(10, pow);
            pow++;
        }
        
    }
}
