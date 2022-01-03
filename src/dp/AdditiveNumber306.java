package dp;

import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber306 {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j + 1 < num.length(); j++) {
                int a = -1, b = i, c = j;
                while (true) {
                    if (b - a > 1 && num.charAt(a + 1) == '0' || c - b > 1 && num.charAt(b + 1) == '0') break;
                    String first = num.substring(a + 1, b - a);
                    String second = num.substring(b + 1, c - b);
                    String sum = add(first, second);
                    if(c+1+sum.length()>num.length())break;
                    if (!num.substring(c + 1, c + 1 + sum.length()).equals(sum)) break;
                    a = b;
                    b = c;
                    c += sum.length();
                    if (c + 1 == num.length()) return true;
                }
            }
        }
        return false;
    }

    private String add(String first, String second) {
        List<Integer> A = new ArrayList<>(), B = new ArrayList<>(), C = new ArrayList<>();
        for (int i = first.length() - 1; i >= 0; i--) {
            A.add(first.charAt(i) - '0');
        }
        for (int i = second.length() - 1; i >= 0; i--) {
            B.add(second.charAt(i) - '0');
        }
        for (int i = 0, t = 0; i < A.size() || i < B.size() || t > 0; i++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }
        String res = "";
        for (int i = C.size() - 1; i >= 0; i--) res += String.valueOf(C.get(i));
        return res;
    }
}
