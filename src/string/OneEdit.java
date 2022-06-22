package string;

public class OneEdit {
    public boolean oneEditAway(String first, String second) {
        int p1 = 0, p2 = 0, m = first.length(), n = second.length();
        if (Math.abs(m - n) >= 2) return false;
        boolean oneEdit = false;
        while (p1 < m && p2 < n) {
            if (first.charAt(p1) == second.charAt(p2)) {
                p1++;
                p2++;
            } else {
                if (m == n) {
                    if (!oneEdit) {
                        p1++;
                        p2++;
                        oneEdit = true;
                    } else {
                        return false;
                    }
                } else if (m < n) {
                    if (!oneEdit) {
                        p2++;
                        oneEdit = true;
                    } else {
                        return false;
                    }
                } else {
                    if (!oneEdit) {
                        p1++;
                        oneEdit = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
