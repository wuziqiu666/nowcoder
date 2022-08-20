import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Main_0813_5{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int n = in.nextInt();
        int t = in.nextInt();
        TreeNode head = new TreeNode();
        int[] nums = new int[n];
        nums[0] = 1;
        for(int i = 1; i < nums.length; i++){
            nums[i] = in.nextInt();
        }
        int[][] server = new int[t][2];
        for (int i = 0; i < t; i++) {
            server[i][0] = in.nextInt();
            server[i][1] = in.nextInt();
        }
        List<TreeNode> nodeList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            nodeList.add(new TreeNode(i + 1));
        }
        for (int i = 1; i < n; i++){
            nodeList.get(i).next = nodeList.get(nums[i]);
        }
        
        for (int[] s : server) {
            List<Integer> road = new ArrayList<>();
            solution.solve(nodeList, road, s[0], s[1]);
            for (int a : road) {
                System.out.printf("" + a + " ");
            }
        }
        in.close();

    }
}

class TreeNode {
    int val;
    TreeNode next;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

}
class Solution {
    public void solve(List<TreeNode> nodeList, List<Integer> road,  int source, int target) {
        TreeNode node = nodeList.get(source);
        if (node.next.val != target) {
            road.add(node.next.val);
            solve(nodeList, road, node.next.val, target);
        }

    }


}
