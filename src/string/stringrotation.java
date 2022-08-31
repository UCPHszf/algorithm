package string;

public class stringrotation {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s3 = s1 + s1;
        return s3.contains(s2);
    }
}
