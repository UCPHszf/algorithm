package hashmap;

public class RansomNote383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int n = ransomNote.length();
        int[] cnt = new int[26];
        for (char ch : ransomNote.toCharArray()) {
            cnt[ch - 'a']++;
        }
        for (char ch : magazine.toCharArray()) {
            if (cnt[ch - 'a'] > 0) {
                cnt[ch - 'a']--;
                n--;
                if (n == 0) return true;
            }
        }
        return false;
    }
}
