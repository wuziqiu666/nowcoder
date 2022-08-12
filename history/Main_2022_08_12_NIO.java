import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_2022_08_12_NIO {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String target = in.nextLine();
        int sitel = 0, siter = 0;
        char[] charArray = str.toCharArray();
        char[] targetArray = target.toCharArray();
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> nowMap = new HashMap<>();
        for (int i = 0; i < targetArray.length; i++) {
            targetMap.put(targetArray[i], targetMap.getOrDefault(targetArray[i], 0) + 1);
        }
        int left = 0, right = charArray.length;
        while (siter < charArray.length) {
            boolean ans = true;
            for (char c : targetMap.keySet()) {
                if (nowMap.getOrDefault(c, 0) < targetMap.get(c)) {
                    ans = false;
                    break;
                }
            }
            if (!ans) {
                if (targetMap.containsKey(charArray[siter])) {
                    nowMap.put(charArray[siter], nowMap.getOrDefault(charArray[siter], 0) + 1);
                }
                siter++;
            }
            if (ans) {
                left = left > sitel ? left : sitel;
                right = right < siter ? right : siter;
                if (nowMap.containsKey(charArray[sitel])) {
                    nowMap.put(charArray[sitel], nowMap.get(charArray[sitel]) - 1);
                }
                sitel++;
            }
        }
        System.out.println(str.substring(left, right));
        return;

    }
}
