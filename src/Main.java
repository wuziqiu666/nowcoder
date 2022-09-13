import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] food1 = new int[n];
        int[] food2 = new int[n];
        for(int i = 0; i < n; i++){
            food1[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++){
            food2[i] = in.nextInt();
        }
        Solution solution = new Solution();
        System.out.println(solution.slove(food1, food2));


        in.close();
    }

    static class Solution{
        public long slove(int[] food1, int[] food2){
            int n = food1.length;
            long a = food1[0], b = food2[0];
            for(int i = 1; i < n; i++){
                long na = Math.max(a, food1[i] + b);
                long nb = Math.max(b, food2[i] + a);
                a = na;
                b = nb;
            }
            return Math.max(a, b);
            
        }
    }

}


