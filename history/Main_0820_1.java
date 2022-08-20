// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Comparator;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Scanner;
// import java.util.Set;

// import javax.naming.ldap.SortControl;

// public class Main {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);

//         int m = in.nextInt();
//         int n = in.nextInt();
//         int[] possible = new int[m];
//         for (int i = 0; i < m; i++) {
//             possible[i] = in.nextInt();
//         }
//         int[] score = new int[m];
//         for (int i = 0; i < m; i++) {
//             score[i] = in.nextInt();
//         }
//         Solution solution = new Solution();
//         double ans = solution.solve(possible, score, n);
//         System.out.println(ans);

//         in.close();

//     }
// }

// class Solution {
//     public double solve(int[] possible, int[] score, int n) {
//         int m = score.length;
//         long[][] dp = new long[n + 1][m + 1];
//         for(int i = 0; i < n + 1; i++){
//             dp[i][0] = 0;
//         }
//         for (int i = 1; i < m + 1; i++) {
//             dp[0][i] = (long) score[i - 1] * (long) possible[i - 1] + dp[0][i - 1];
//         }
//         for (int i = 1; i < n + 1; i++) {
//             for (int j = 1; j < m + 1; j++) {
//                 long score1 = dp[i][j - 1] + (long)score[j - 1] * (long)possible[j -1];
//                 long score2 = dp[i - 1][j - 1] + (long)score[j - 1] * 100;
//                 dp[i][j] = Math.max(score1, score2);
//             }
//         }

//         return (double) dp[n][m] / 100;
//     }

// }

import java.util.Scanner;

public class Main_0820_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] arrayA = new int[m];
        int[] arrayB = new int[n];
        for (int i = 0; i < m; i++) {
            arrayA[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrayB[i] = in.nextInt();
        }
        Solution solution = new Solution();
        long ans = solution.solve(arrayA, arrayB, 0, 0, 0);
        System.out.println(ans);

        in.close();

    }
}

class Solution {
    public long solve(int[] arrayA, int[] arrayB, int la, int lb, long time) {
        int m = arrayA.length - la;
        int n = arrayB.length - lb;
        if (m == 0 && n == 0) {
            return time;
        }
        if (m == 0 && n != 0) {
            for (int i = lb; i < arrayB.length; i++) {
                time += (long)Math.abs(arrayB[i]);
            }
            return time;
        }
        if (m != 0 && n == 0) {
            for (int i = la; i < arrayA.length; i++) {
                time += (long)Math.abs(arrayA[i]);
            }
            return time;
        }

        long a = solve(arrayA, arrayB, la + 1, lb + 1, time + (long)Math.abs(arrayA[la] - arrayB[lb]));

        long b = solve(arrayA, arrayB, la + 1, lb, time + (long)Math.abs(arrayA[la]));
        long c = solve(arrayA, arrayB, la, lb + 1, time + (long)Math.abs(arrayB[lb]));
        return Math.min(a, Math.min(b, c));
    }

}
