import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solution = new Solution();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            long ans = solution.solve(a);
            System.out.println(ans);
        }
        in.close();
    }
}

class Solution {

    public long solve(int num) {
        if ((num & 1) == 0) {
            return num;
        }
        String s = Integer.toString(num);
        int site = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (((int) (c - '0') & 1) == 0) {
                site = i;
                break;
            }
        }
        if (site == 0) {
            return -1;
        }
        StringBuilder sBuilder = new StringBuilder(s);
        sBuilder.replace(s.length() - 1, s.length(), s.substring(site, site + 1));
        sBuilder.replace(site, site + 1, s.substring(s.length() - 1, s.length()));
        return Long.parseLong(sBuilder.toString());
    }
}
