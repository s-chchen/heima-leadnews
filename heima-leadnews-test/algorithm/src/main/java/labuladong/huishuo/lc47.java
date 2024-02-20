package labuladong.huishuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]*/
public class lc47 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Integer> arr = Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] use = new boolean[arr.size()];
        backtrack(arr, res, cur, use);

        res.forEach(e -> {
            System.out.println(e);
        });
    }

    private static void backtrack(List<Integer> arr, List<List<Integer>> res, List<Integer> cur, boolean[] use) {
        if (cur.size() == arr.size()) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (use[i] || (i > 0 && arr.get(i) == arr.get(i-1) && !use[i - 1])) {
                    continue;
                }
                if (true) {
                    cur.add(arr.get(i));
                    use[i] = true;
                    backtrack(arr, res, cur, use);
                    cur.remove(cur.size() - 1);
                    use[i] = false;
                }
            }
        }
    }

}
