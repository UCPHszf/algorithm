package hashmap;

public class BullsandCows299 {
    public String getHint(String secret, String guess) {
        int numA = 0, numB = 0;
        int[] cnt = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            char ch = secret.charAt(i);
            if (ch == guess.charAt(i)) {
                numA++;
            } else {
                cnt[secret.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            char ch = guess.charAt(i);
            if (ch != secret.charAt(i)) {
                if (cnt[ch - '0'] > 0) {
                    cnt[ch - '0']--;
                    numB++;
                }
            }
        }
        return numA + "A" + numB + "B";
    }
}
