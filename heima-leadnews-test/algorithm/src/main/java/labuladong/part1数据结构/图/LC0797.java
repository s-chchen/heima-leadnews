package labuladong.part1数据结构.图;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * */

public class LC0797 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);

        int len = arr.length - 1;

        dfs(res, cur, 0, len, arr);
        for (List<Integer> r : res) {
            System.out.println(r);
        }

    }

    private static void dfs(List<List<Integer>> res, List<Integer> cur, int start, int end, int[][] arr) {
        if (start == end) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int t : arr[start]) {
            cur.add(t);
            dfs(res, cur, t, end, arr);
            cur.remove(cur.size() - 1);
        }

    }

}
