package string;

public class ReverseWordsinaStringIII557 {
    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        String[] reverse = new String[ss.length];
        for (int i = 0; i < reverse.length; i++) {
            reverse[i] = new StringBuffer(ss[i]).reverse().toString();
        }
        String res = "";
        for (int i = 0; i < ss.length; i++) {
            res += reverse[i];
            if (i != ss.length - 1) {
                res += " ";
            }
        }
        return res;
    }
}
