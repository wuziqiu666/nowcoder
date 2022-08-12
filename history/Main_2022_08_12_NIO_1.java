import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_2022_08_12_NIO_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        solution.confMap();
        for (int t = in.nextInt(); t > 0; t--) {
            long num = in.nextInt();
            int ans = solution.slove(num);
            
            System.out.println(ans);

        }
        in.close();
    }
}

class Solution {
    Map<Long, Integer> p = new HashMap<>();

    public void confMap() {
        long num = 1;
        while (num < Math.pow(10, 12)) {
            p.put(num, 1);
            num *= 6;
        }
        num = 1;
        while (num < Math.pow(10, 12)) {
            p.put(num, 1);
            num *= 9;
        }
    }

    public int slove(Long num) {
        if (p.containsKey(num)) {
            return p.get(num);
        }
        Long r6 = (long) 1;
        Long r9 = (long) 1;
        while (r6 * 6 < num) {
            r6 *= 6;
        }
        while (r9 * 9 < num) {
            r9 *= 9;
        }
        int ans = Math.min(slove(num - r6), slove(num - r9)) + 1; 
        p.put(num, ans);
        return ans;
    }
    
}
