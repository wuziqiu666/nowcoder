// import java.util.Scanner;

// public class Main{
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         Solution solution = new Solution();
//         int n = in.nextInt();
//         int t = in.nextInt();
//         int[] times = new int[n];
//         for (int i = 0; i < n; i++) {
//             times[i] = in.nextInt();
//         }
//         int ans = solution.solve(t, times);
//         System.out.println(ans);
//         in.close();
        

//     }
// }

// class Solution {
//     int t;
//     int[] times;
//     public int solve(int t, int[] times) {
//         this.t = t;
//         this.times = times;
//         return expand(0, 0);
//     }

//     public int expand(int site, int num) {
//         if(site >= times.length - 1){
//             return num;
//         }
//         if (times[site + 1] - times[site] >= t) {
//             site++;
//             return expand(site, num);
//         } else {
//             num++;
//             int ans1 = expand(site+1, num);
//             int tmpSite = site + 2;
//             while(tmpSite < times.length && times[tmpSite] - times[site] < t){
//                 tmpSite++;
//                 num++;
//             }
//             int ans2 = expand(tmpSite, num);
//             return Math.min(ans1, ans2);
//         }
//     }

// }
