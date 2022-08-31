import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ans = 0;
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            ans += 2;
<<<<<<< HEAD
            ans += 3;
=======
            ans -= 2;
            ans += 1;
            ans--;
>>>>>>> 47449ab (Update Test2.java)
        }
        System.out.println(ans);

        in.close();
    }
}
