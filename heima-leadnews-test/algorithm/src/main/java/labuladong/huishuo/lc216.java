package labuladong.huishuo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * */
public class lc216 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(k, n, 1, res, cur);
        res.forEach(e -> {
            System.out.println(e);
        });
    }

    private static void backtrack(int k, int n, int start, List<List<Integer>> res, List<Integer> cur) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(cur));
        } else if (k > 0 && n > 0) {
            for (int i = start; i <= 9; i++) {
                if (!cur.contains(i)) {
                    cur.add(i);
                    backtrack(k - 1, n - i, i+1, res, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }


}
