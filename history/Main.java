import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // String a = in.next();
        // String b = in.next();

        String a = "aba";
        String b = "ab";
        Solution solution = new Solution();
        int t = solution.maxMatch(a, b);
        System.out.println(t);

        in.close();
    }

}

class Solution {
    int[] next;

    public void makeNext(char[] charArray) {
        int n = charArray.length;
        next = new int[n];
        next[0] = -1;
        int j = 0;
        int k = 0;
        while (j < n - 1) {
            if (charArray[j] == charArray[k] || k == -1) {
                next[j + 1] = k + 1;
                k++;
                j++;
            } else {
                k = next[k];
            }
        }
    }

    public int maxMatch(String a, String b) {
        makeNext(b.toCharArray());
        int sitea = 0;
        int siteb = 0;
        int ans = 0;
        int tmp = 0;
        while (sitea < a.length()) {
            if (a.charAt(sitea) == b.charAt(siteb)) {
                sitea++;
                siteb++;
                tmp++;
            } else if(siteb >= 0){
                siteb = next[siteb];
                ans = Math.max(ans, tmp);
                tmp = siteb;
            } else {
                sitea++;
            }
            if (siteb == b.length()) {
                ans = Math.max(ans, tmp);
            }
            if (sitea == a.length()) {
                ans = Math.max(ans, tmp);
            }
        }
        return ans;
    }
}
