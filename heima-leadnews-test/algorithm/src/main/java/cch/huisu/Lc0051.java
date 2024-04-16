package cch.huisu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 */

public class Lc0051 {

    public static void main(String[] args) {
        int n = 4;
        Solution0051 solution = new Solution0051();
        List<List<String>> res = solution.solveNQueens(n);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

}

class Solution0051 {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        List<Integer> diagonal1 = new ArrayList<>();
        List<Integer> diagonal2 = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        backtrack(res, cur, 0, n, cols, diagonal1, diagonal2);
        return res;
    }

    private void backtrack(List<List<String>> res, List<Integer> cur, int row, int n, List<Integer> cols, List<Integer> diagonal1, List<Integer> diagonal2) {
        if (n == row) {
            List<String> board = generateBoard(cur, n);
            res.add(board);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (cols.contains(i)) {
                continue;
            }
            if (diagonal1.contains(row - i)) {
                continue;
            }
            if (diagonal2.contains(row + i)) {
                continue;
            }

            cur.add(i);
            cols.add(i);
            diagonal1.add(row - i);
            diagonal2.add(row + i);
            backtrack(res, cur, row + 1, n, cols, diagonal1, diagonal2);
            cur.remove(cur.size() - 1);
            cols.remove(cols.size() - 1);
            diagonal1.remove(diagonal1.size() - 1);
            diagonal2.remove(diagonal2.size() - 1);
        }
    }

    public List<String> generateBoard(List<Integer> queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens.get(i)] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}

