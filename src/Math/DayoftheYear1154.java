package Math;

public class DayoftheYear1154 {
    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int[] dayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day = Integer.parseInt(date.substring(8));
        boolean isRunYear = false;
        if (year % 4 == 0 && year != 1900) isRunYear = true;
        int res = 0;
        for (int i = 0; i < month - 1; i++) {
            res += dayOfMonth[i];
        }
        if (month >= 3 && isRunYear)
            res += 1;
        res += day;
        return res;
    }
}
