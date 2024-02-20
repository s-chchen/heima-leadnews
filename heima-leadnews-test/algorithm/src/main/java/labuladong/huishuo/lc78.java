package labuladong.huishuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * */
public class lc78 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        List<Integer> arr = Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        boolean[] use = new boolean[arr.size()];


        res.add(new ArrayList<>());
        for (int i = 1 ; i<arr.size(); i++) {
            backtrack(i, arr, 0, res, cur, use);
        }
        res.add(new ArrayList<>(arr));

        res.forEach(e -> {
            System.out.println(e);
        });
    }

    private static void backtrack(int len, List<Integer> arr, int start, List<List<Integer>> res, List<Integer> cur, boolean[] use) {
        if (cur.size() == len) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = start; i < arr.size(); i++) {
            if (!use[i]) {
                cur.add(arr.get(i));
                use[i] = true;
                backtrack(len, arr, i+1, res, cur, use);
                cur.remove(cur.size() - 1);
                use[i] = false;
            }
        }

    }

}
