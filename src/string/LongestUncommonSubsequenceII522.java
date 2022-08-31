package string;

public class LongestUncommonSubsequenceII522 {
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0; i < strs.length; i++) {
            boolean isSubsequence = false;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isSubsequence = true;
                    break;
                }
            }
            if (isSubsequence) res = Math.max(res, strs[i].length());
        }
        return res;
    }

    private boolean isSubsequence(String s1, String s2) {
        int k = 0;
        for (char c : s2.toCharArray()) {
            if (k < s1.length() && s1.charAt(k) == c) {
                k++;
            }
        }
        return k == s1.length();
    }
}
