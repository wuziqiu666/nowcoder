import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solution = new Solution();

        int r = in.nextInt();
        int l = in.nextInt();
        String a = in.next();
        String b = in.next();
        int ans = solution.solve(a, b);
        System.out.println(ans);

        in.close();

    }
}

class Solution {
    public int solve(String a, String b) {
        int ans = 0;
        int n = a.length();
        int m = b.length();
        for (int i = 0; i < n; i++) {
            int tmp = i;
            for (int j = 0; j < m && tmp < n; j++, tmp++) {
                if (!charEquals(a.charAt(tmp), b.charAt(j))) {
                    break;
                }
                if (j == m - 1) {
                    ans += 1;
                }
            }
        }
        return ans;

    }
    
    public boolean charEquals(char a, char b) {
        if (b == '*') {
            return true;
        }
        return a == b;
    }

}
