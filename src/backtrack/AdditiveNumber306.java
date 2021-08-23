package backtrack;

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
                    if (!num.substring(c + 1, c + 1 + sum.length()).equals(sum)) break;
                    a = b;
                    b = c;
                    c += sum.length();
                    if(c+1==num.length())return true;
                }
            }
        }
        return false;
    }

    private String add(String first, String second) {

    }
}
