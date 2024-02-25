package Q4C;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * 部门准备举办一场王者荣耀表演赛，有 10 名游戏爱好者参与，分 5 为两队，每队 5 人。
 * 每位参与者都有一个评分，代表着他的游戏水平。
 * 为了表演赛尽可能精彩，我们需要把 10 名参赛者分为实力尽量相近的两队。一队的实力可以表示为这一队 5 名队员的评分总和。
 * 现在给你 10 名参与者的游戏水平评分，请你根据上述要求分队最后输出这两组的实力差绝对值。
 * 例: 10 名参赛者的评分分别为 5 1 8 3 4 6 7 10 9 2，分组为 (1 3 5 8 10) (2 4 6 7 9)，两组实力差最小，差值为 1。有多种分法，但实力差的绝对值最小为 1。
 *
 * **/
public class Q50 {

    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();


        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] use = new boolean[10];
        int sum = Arrays.stream(arr).sum();


        backtrack(arr, 0, 0, sum, 0, use);
        System.out.println(res);
    }

    private static void backtrack(int[] arr, int start, int cnt, int sum, int cur, boolean[] use) {

        if (cnt == 5) {
            res = Math.min(res, Math.abs(sum - cur - cur));
            return;
        }

        if (start == 10) {
            return;
        }

        for (int i = start; i < 10; i++) {
            if (! use[i]) {
                use[i] = true;
                backtrack(arr, i + 1, cnt+1, sum, cur + arr[i], use);
                use[i] = false;
            }
        }

    }

}
