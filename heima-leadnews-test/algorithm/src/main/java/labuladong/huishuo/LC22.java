package labuladong.huishuo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 括号生成
 *
 * **/


public class LC22 {

    public static void main(String[] args) {
        Integer n = 3;
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();

        backtrack(res, cur, 0 ,0, n);
        for (String re : res) {
            System.out.println(re);
        }

    }

    private static void backtrack(List<String> res, StringBuilder cur, int open, int close, Integer n) {
        if (cur.length() == n * 2) {
            res.add(cur.toString());
        }

        if (open < n) {
            cur.append("(");
            backtrack(res, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(")");
            backtrack(res, cur, open, close+1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}
