package labuladong.huishuo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class lc36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<Integer> arr = Arrays.stream(s.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        int n = scanner.nextInt();

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backtrack(arr, n, 0, res, cur);
        res.forEach(e -> {
            System.out.println(e);
        });
    }

    private static void backtrack(List<Integer> arr, int n, int start, List<List<Integer>> res, List<Integer> cur) {
        if (n == 0) {
            res.add(new ArrayList<>(cur));
        } else if(n > 0) {
            for (int i = start; i < arr.size(); i++) {
                cur.add(arr.get(i));
                backtrack(arr, n - arr.get(i), i, res, cur);
                cur.remove(cur.size() - 1);
            }
        }

    }

}
