package labuladong.part1数据结构.图;

import java.util.ArrayList;
import java.util.List;


/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 *
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * */


public class LC0207 {

    public static void main(String[] args) {
        int n = 2;
        int[][] arr = new int[][]{{1, 0}, {0, 1}};

        Solution solution = new Solution();
        boolean b = solution.canFinish(n, arr);
        System.out.println(b);
    }




}


class Solution {

    boolean valid = true;
    int[] visit;
    List<List<Integer>> dList = new ArrayList<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            dList.add(new ArrayList<Integer>());
        }

        for (int[] pre : prerequisites) {
            dList.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses && valid; i++) {
            if (visit[i] == 0) {
                dfs(i);
            }
        }

        return valid;
    }

    private void dfs(int i) {
        visit[i] = 1;

        for (Integer t : dList.get(i)) {
            if (visit[t] == 0) {
                dfs(t);
                if (! valid) {
                    return;
                }
            } else {
                valid = false;
                return;
            }
        }

        visit[i] = 2;
    }

}

