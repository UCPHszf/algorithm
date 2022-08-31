package string;

public class DetectCapital520 {
    public boolean detectCapitalUse(String word) {
        return isFirstUpperCase(word) || word.equals(word.toUpperCase()) || word.equals(word.toLowerCase());
    }

    public boolean isFirstUpperCase(String word) {
        char first = word.charAt(0);
        if (first < 'A' || first > 'Z') return false;
        for (int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch < 'a' || ch > 'z') return false;
        }
        return true;
    }
}
