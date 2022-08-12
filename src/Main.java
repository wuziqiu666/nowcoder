import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution solution = new Solution();
        int a = in.nextInt();
        int b = in.nextInt();
        int num = solution.add(a, b);
        System.out.println(num);
        in.close();
        

    }
}

class Solution {
    public int  add(int a, int b) {
        return a + b;
    }

}
