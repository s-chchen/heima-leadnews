package cch.huisu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

public class Lc0046 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        Solution solution = new Solution();
        List<List<Integer>> res = solution.permute(nums);

        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

}


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        backtrack(len, list, res, 0);
        return res;
    }

    private void backtrack(int len, List<Integer> list, List<List<Integer>> res, int start) {

        if (start == len) {
            res.add(new ArrayList<>(list));
        }

        for (int i = start; i < len; i++) {
            Collections.swap(list, start, i);
            backtrack(len, list, res, start + 1);
            Collections.swap(list, start, i);
        }

    }


}




