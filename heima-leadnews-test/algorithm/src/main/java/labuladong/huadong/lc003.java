package labuladong.huadong;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * 无重复字符的最长子串
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * */

public class lc003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();

        Set<Character> set = new HashSet<>();
        int res = 0;

        for (int i = 0; i < len; i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }
            for (int j = i; j < len; j++) {
                if (set.contains(s.charAt(j))) {
                    res = Math.max(res, j - i);
                    break;
                }
                set.add(s.charAt(j));
            }
        }
        System.out.println(res);
    }

}
