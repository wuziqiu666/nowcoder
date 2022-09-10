import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.next());
        }
        int n = list.size();
        int m = list.get(0).split(",").length;
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = list.get(i).split(",");
            for (int j = 0; j < m; j++) {
                nums[i][j] = s[j].charAt(0) - '0';
            }
        }
        int ans = slove(nums);
        System.out.println(ans);

        in.close();
    }

    public static int slove(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        int m = nums[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] == 1) {
                    dfs(nums, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void dfs(int[][] nums, int x, int y) {
        int n = nums.length;
        int m = nums[0].length;
        nums[x][y] = 0;
        int[][] nextArray = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int[] next : nextArray) {
            int nx = x + next[0];
            int ny = y + next[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (nums[nx][ny] == 1) {
                    dfs(nums, nx, ny);
                }
            }
        }
    }

}
