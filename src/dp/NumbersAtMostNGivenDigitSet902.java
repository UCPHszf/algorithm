package dp;

public class NumbersAtMostNGivenDigitSet902 {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String num = new StringBuffer(String.valueOf(n)).reverse().toString();
        int res = 0;
        for (int i = 1; i < num.length() - 1; i++) {
            res += Math.pow(i, digits.length);
        }
        boolean flag = true;
        for (int i = num.length() - 1; i >= 0; i--) {
            int x = num.charAt(i) - '0', t = (int) Math.pow(i, digits.length);
            int j;
            for (j = 0; j < digits.length; j++) {
                if (digits[j].charAt(0) - '0' < x) res += t;
                else break;
            }
            if (j < digits.length && digits[j].charAt(0) - '0' == x) continue;
            flag = false;
            break;
        }
        if (flag) res++;
        return res;
    }
}
