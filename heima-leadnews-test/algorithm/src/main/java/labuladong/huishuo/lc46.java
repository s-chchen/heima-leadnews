package labuladong.huishuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * */
public class lc46 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Integer> arr = Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(arr, res, cur);

        res.forEach(e -> {
            System.out.println(e);
        });
    }

    private static void backtrack(List<Integer> arr, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == arr.size()) {
            res.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < arr.size(); i++) {
                if (!cur.contains(arr.get(i))) {
                    cur.add(arr.get(i));
                    backtrack(arr, res, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

}
