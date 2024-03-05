package labuladong.bfs;


import java.util.*;

/**
 * 打开转盘锁
 *
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * **/

public class LC752 {

    public static void main(String[] args) {
        String[] arr = new String[]{"0201","0101","0102","1212","2002"};
        String target = "0202";

        int i = openLock(arr, target);
        System.out.println(i);
    }

    public static int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }

        Set<String> deadSet = new HashSet<>();
        for (String deadend : deadends) {
            deadSet.add(deadend);
        }
        if (deadSet.contains(target)) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");

        Set<String> seen = new HashSet<>();
        seen.add("0000");

        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                List<String> nextStatus = getNext(status);
                for (String s : nextStatus) {
                    if (! deadSet.contains(s) && ! seen.contains(s)) {
                        if (s.equals(target)) {
                            return step;
                        }
                        queue.offer(s);
                        seen.add(s);
                    }
                }
            }
        }
        return -1;
    }

    private static List<String> getNext(String status) {
        List<String> res = new ArrayList<>();
        char[] chars = status.toCharArray();
        for (int i = 0; i < 4; ++i) {
            char num = chars[i];
            chars[i] = numPrev(num);
            res.add(new String(chars));
            chars[i] = numSucc(num);
            res.add(new String(chars));
            chars[i] = num;
        }
        return res;
    }

    public static char numPrev(char x) {
        return x == '0' ? '9' : (char) (x - 1);
    }

    public static char numSucc(char x) {
        return x == '9' ? '0' : (char) (x + 1);
    }



}
