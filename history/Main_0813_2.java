import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int n = in.nextInt();
        int m = in.nextInt();
        int t = in.nextInt();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], 0);
        }
        String s = in.next();
        int ans = solution.solve(board, s, m, n);
        System.out.println(ans);
        in.close();

    }
}

class Solution {
    public int solve(int[][] board, String s, int m, int n) {
        char[] charArray = s.toCharArray();
        int cnt = m * n - 1;
        int x = 0, y = 0; 
        board[x][y] = 1;
        for (int i = 0; i < charArray.length; i++) {
            char tmp = charArray[i];
            if(tmp == 'W'){
                y--;
            }else if(tmp == 'A'){
                x--;
            }else if(tmp == 'S'){
                y++;
            }else if(tmp == 'D'){
                x++;
            }
            if (board[x][y] == 0) {
                cnt--;
                board[x][y] = 1;
            }
            if (cnt == 0) {
                System.out.println("YES");
                return i;
            }

        }
        System.out.println("No");
        return cnt;
    }


}
