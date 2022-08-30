import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Solution solution = new Solution();
        int n = in.nextInt();
        int moveLength = in.nextInt();
        int[] moveArray = new int[moveLength];
        for (int i = 0; i < moveLength; i++) {
            moveArray[i] = in.nextInt();
        }
        int[] ans = solution.solve(n, moveArray);
        for (int i : ans) {
            System.out.print("" + i + " ");
        }

        in.close();

    }
}

class Solution {
    Map<Integer, ListNode> map = new HashMap<>();

    public ListNode confMap(int n) {
        ListNode head = new ListNode();
        ListNode node = head;
        for (int i = 1; i <= n; i++) {
            ListNode tmp = new ListNode();
            tmp.val = i;
            node.next = tmp;
            map.put(i, node);
            node = node.next;
        }
        return head;
    }

    public int[] solve(int n, int[] moveArray) {
        ListNode head = confMap(n);
        for (int i : moveArray) {
            moveToHead(head, map.get(i));
        }
        int[] ans = new int[n];
        ListNode node = head;
        int ansSite = 0;
        while (node.next != null) {
            node = node.next;
            ans[ansSite] = node.val;
            ansSite++;
        }
        return ans;
    }

    public void moveToHead(ListNode head, ListNode preA) {
        ListNode a = preA.next;
        preA.next = preA.next.next;
        if(preA.next != null){
            map.put(preA.next.val, preA);
        }
        a.next = head.next;
        map.put(a.next.val, a);
        head.next = a;
        map.put(a.val, head);
    }
}

class ListNode {
    int val;
    ListNode next;
}
