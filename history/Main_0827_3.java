import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solution = new Solution();

        int n = in.nextInt();
        Process[] processes = new Process[n];
        for (int k = 0; k < n; k++) {
            Process tmp = new Process();
            int s1 = in.nextInt();
            int s2 = in.nextInt();
            char[][] img = new char[s1][s1];
            for (int i = 0; i < s1; i++) {
                img[i] = in.next().toCharArray();
            }
            tmp.s1 = s1;
            tmp.s2 = s2;
            tmp.img = img;
            processes[k] = tmp;
        }
        for (int k = 0; k < n; k++) {
            int s1 = processes[k].s1;
            int s2 = processes[k].s2;
            char[][] img = processes[k].img;
            char[][] ans = solution.solve(s1, s2, img);

            for (int i = 0; i < s2; i++) {
                System.out.println(new String(ans[i]));
            }
            System.out.println("");

        }
        in.close();

    }
}

class Process {
    int s1;
    int s2;
    char[][] img;
}

class Solution {
    char[][] wall;
    char[][] img;
    int s1, s2;

    public char[][] solve(int s1, int s2, char[][] img) {
        this.s1 = s1;
        this.s2 = s2;
        wall = new char[s2][s2];
        this.img = img;
        int center = s2 / 2;
        int[] anchor = new int[] { center - s1 / 2, center - s1 / 2 };
        int[] site = anchor.clone();
        while (site[1] < s2) {
            int[] site1 = site.clone();
            site1[0] = site[0] - 1;
            while (site1[0] >= 0) {
                fill(site1, 1);
                site1[0] -= s1;
            }
            site1 = site.clone();
            site1[0] = site[0] + s1;
            while (site1[0] < s2) {
                fill(site1, 0);
                site1[0] += s1;
            }
            fill(site, 0);
            site[1] += s1;

        }

        site = anchor.clone();
        site[1] = anchor[1] - 1;
        while (site[1] >= 0) {
            int[] site1 = site.clone();
            site1[0] = site[0] - 1;
            while (site1[0] >= 0) {
                fill(site1, 3);
                site1[0] -= s1;
            }
            site1 = site.clone();
            site1[0] = site[0] + s1;
            while (site1[0] < s2) {
                fill(site1, 2);
                site1[0] += s1;
            }
            fill(site, 2);
            site[1] -= s1;
        }
        return wall;

    }

    public void fill(int[] anchor, int status) {
        for (int i = 0; i < s1; i++) {
            for (int j = s1 - 1; j >= 0; j--) {
                int[] site = getSite(anchor, i, j, status);
                if (site[0] >= 0 && site[0] < s2 && site[1] >= 0 && site[1] < s2) {
                    wall[site[0]][site[1]] = img[i][j];
                }
            }
        }
    }

    /**
     * 
     * @param anchor
     * @param x
     * @param y
     * @param status 0 rd 1 ru 2 ld 3 lu
     * @return
     */
    public int[] getSite(int[] anchor, int x, int y, int status) {
        int[] ans = new int[2];
        if ((status & 1) == 1) { // up
            ans[0] = anchor[0] - s1 + 1 + x;
        } else { // down
            ans[0] = anchor[0] + x;
        }
        if ((status & 2) == 2) { // left
            ans[1] = anchor[1] - s1 + 1 + y;
        } else {// right
            ans[1] = anchor[1] + y;
        }
        return ans;
    }

}