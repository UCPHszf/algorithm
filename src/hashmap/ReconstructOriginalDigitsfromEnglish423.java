package hashmap;

public class ReconstructOriginalDigitsfromEnglish423 {

    String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public String originalDigits(String s) {
        int[] digits = new int[10];
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        if (cnt['z' - 'a'] > 0) {
            int numZ = cnt['z' - 'a'];
            minus(cnt, "zero", numZ);
            digits[0] = numZ;
        }

        if (cnt['w' - 'a'] > 0) {
            int numW = cnt['w' - 'a'];
            minus(cnt, "two", numW);
            digits[2] = numW;
        }

        if (cnt['x' - 'a'] > 0) {
            int numX = cnt['x' - 'a'];
            minus(cnt, "six", numX);
            digits[6] = numX;
        }

        if (cnt['s' - 'a'] > 0) {
            int numS = cnt['s' - 'a'];
            minus(cnt, "seven", numS);
            digits[7] = numS;
        }

        if (cnt['g' - 'a'] > 0) {
            int numG = cnt['g' - 'a'];
            minus(cnt, "eight", numG);
            digits[8] = numG;
        }

        if (cnt['h' - 'a'] > 0) {
            int numH = cnt['h' - 'a'];
            minus(cnt, "three", numH);
            digits[3] = numH;
        }

        if (cnt['v' - 'a'] > 0) {
            int numV = cnt['v' - 'a'];
            minus(cnt, "five", numV);
            digits[5] = numV;
        }

        if (cnt['f' - 'a'] > 0) {
            int numF = cnt['f' - 'a'];
            minus(cnt, "four", numF);
            digits[4] = numF;
        }

        if (cnt['i' - 'a'] > 0) {
            int numI = cnt['i' - 'a'];
            minus(cnt, "nine", numI);
            digits[9] = numI;
        }

        if (cnt['o' - 'a'] > 0) {
            int numO = cnt['o' - 'a'];
            digits[1] = numO;
        }
        String res = "";
        for (int i = 0; i < digits.length; i++) {
            while (digits[i] > 0) {
                res += String.valueOf(i);
                digits[i]--;
            }
        }
        return res;
    }

    void minus(int[] cnt, String word, int times) {
        for (char ch : word.toCharArray()) {
            cnt[ch - 'a'] -= times;
        }
    }
}
