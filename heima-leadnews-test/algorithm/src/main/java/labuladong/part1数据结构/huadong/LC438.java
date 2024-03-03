package labuladong.part1数据结构.huadong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * **/

public class LC438 {

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> res = findAnagrams(s, p);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int len = s.length() - p.length();

        int[] sc = new int[26];
        int[] pc = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sc[s.charAt(i) - 'a']++;
            pc[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sc, pc)) {
            res.add(0);
        }

        for (int i = 0; i < len; i++) {
            sc[s.charAt((i)) - 'a']--;
            sc[s.charAt((i + p.length())) - 'a']++;

            if (Arrays.equals(sc, pc)) {
                res.add(i+1);
            }
        }

        return res;
    }

}
