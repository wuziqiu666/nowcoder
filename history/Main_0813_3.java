import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
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
        solution.solve(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("" + nums[i] + " ");
        }
        in.close();

    }
}

class Solution {
    public void solve(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int t = nums.length - 1;
        deque.addFirst(nums[t]);
        t--;
        while (t >= 0) {
            deque.addFirst(nums[t]);
            int a = deque.removeLast();
            deque.addFirst(a);
            a = deque.removeLast();
            deque.addFirst(a);
            t--;
        }
        for (int i = 0; i < nums.length; i++) {
            int a = deque.removeFirst();
            nums[i] = a;
        }
    }


}
