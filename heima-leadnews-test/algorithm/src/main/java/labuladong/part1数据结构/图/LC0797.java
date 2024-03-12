package labuladong.part1数据结构.图;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
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
