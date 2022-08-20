import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int ans = solution.solve(nums);
        System.out.println(ans);
        in.close();

    }
}

class Solution {
    public int solve(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                int key = 2 * nums[j] - nums[k];
                int[] site = {j, k};
                List<int[]> value = map.getOrDefault(key, new ArrayList<>());
                value.add(site);
                map.put(key, value);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int key = nums[i] - nums[j];
                if (map.containsKey(key)) {
                    for (int[] site : map.get(key)) {
                        if(site[0] == j){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }


}
