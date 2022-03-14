package dp;


/*
 * 552解法:使用状态机
 * f[i][j][k]:i表示当前位数 j表示当前A的个数 k表示连续的l的个数 每一次考虑三种状态转移
 * */

public class StudentAttendanceRecordII552 {

    double MOD = 1e9 + 7;

    public int checkRecord(int n) {
        int[][][] f = new int[n + 1][2][3];
        f[0][0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == 0) f[i + 1][j + 1][0] = (int) ((f[i + 1][j + 1][0] + f[i][j][k]) % MOD);
                    if (k + 1 <= 2) f[i + 1][j][k + 1] = (int) ((f[i + 1][j][k + 1] + f[i][j][k]) % MOD);
                    f[i + 1][j][0] = (int) ((f[i + 1][j][0] + f[i][j][k]) % MOD);
                }
            }
        }
        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (int) ((res + f[n][j][k]) % MOD);
            }
        }
        return res;
    }
}
