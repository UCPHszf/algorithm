package Math;

public class Base7_504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        int abs = Math.abs(num);
        StringBuilder builder = new StringBuilder();
        for (int pow = 8; pow >= 0; pow--) {
            int m = (int) Math.pow(7, pow);
            int n = abs / m;
            abs -= m * n;
            builder.append(n);
        }
        int offset = 0;
        while (builder.charAt(offset) == '0') {
            offset++;
        }
        String res = num > 0 ? "" : "-";
        res += builder.substring(offset);
        return res;
    }
}
