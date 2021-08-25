package string;

import java.util.Arrays;

public class MultipleStrings43 {
    public String multiply(String num1, String num2) {
        String str1 = new StringBuilder(num1).reverse().toString();
        String str2 = new StringBuilder(num2).reverse().toString();
        String ans = "";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                res[i + j] += (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
            }
        }
        for (int i = 0, extra = 0; i < res.length; i++) {
            extra += res[i];
            res[i] = extra % 10;
            extra /= 10;
        }
        int k = res.length - 1;
        while (k > 0 && res[k] == 0) k--;
        while (k >= 0) {
            ans += (char)res[k--];
        }
        return ans;
    }
}
