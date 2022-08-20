import java.util.Scanner;

public class Main_0813{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int n = in.nextInt();
        int t = in.nextInt();
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = in.nextInt();
        }
        int ans = solution.solve(t, times);
        System.out.println(ans);
        in.close();
        

    }
}

class Solution {
    public int solve(int t, int[] times) {
        int n = times.length;
        int ans = 0;
        int nowtime = 0;
        for (int i = 0; i < n; i++) {
            if (times[i] >= nowtime + t) {
                nowtime = times[i];
                ans++;
            }
        }
        return n - ans;
    }

}
