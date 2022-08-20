import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] grp = s.split(" ");
        int[] m = new int[grp.length];
        int[] n = new int[grp.length];
        for (int i = 0; i < grp.length; i++) {
            String[] tmp = grp[i].split(",");
            m[i] = Integer.valueOf(tmp[0]);
            n[i] = Integer.valueOf(tmp[1]);
        }
        Solution solution = new Solution();
        int[] ans = new int[n.length + 1];
        ans = solution.solve(m, n, 0, 20 , ans);

        for (int i = 1; i < n.length + 1; i++) {
            System.out.printf("" + ans[i] + " ");

        }
        in.close();
    }
}

class Solution {
    public int[] solve(int[] m, int[] n, int site, int num, int[] ans) {
        if (site == n.length) {
            return ans;
        }
        if (num > m[site]) {
            int[] aList = ans.clone();
            aList[site + 1] = 1;
            aList[0] = ans[0] + n[site];
            aList = solve(m, n, site + 1, num - m[site], aList);
            int[] bList = ans.clone();
            bList = solve(m, n, site + 1, num, bList);
            if (aList[0] > bList[0]) {
                return aList;
            } else {
                return bList;
            }

        } else {
            return solve(m, n, site + 1, num, ans);
        }

    }
}
