import java.util.*;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 采用单调递减栈，栈顶元素最小，因为前面楼层低，不会挡住后面；前面高，才会挡住后面，栈顶是最接近当前位置的楼，所以要最小，代表此时栈顶所在位置向某一方向能看到其它楼的楼顶。
     * 
     * @param heights int整型一维数组 n座楼的楼层高度
     * @return int整型一维数组
     */
    public int[] findBuilding(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = 1;
            int height = ans[i];
            Stack<Integer> l = new Stack<>();
            for(int site = i - 1; site > 0; site--){
                l.push(heights[site]);
            }
            int k = 0;
            while(l.size() != 0){
                if(l.peek() < height && l.peek() > k){
                    t++;
                }
                k = l.pop();
            }
            Stack<Integer> r = new Stack<>();
            k = 0;
            for(int site = i + 1; site < n; site++){
                r.push(heights[site]);
            }
            while(r.size() != 0){
                if(r.peek() < height && r.peek() > k){
                    t++;
                }
                k = r.pop();
            }
            ans[i] = t;
        }
        return ans;

    }
}
