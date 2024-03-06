package OD;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/5/8
 * Time: 16:21
 * Description: 85%
 */
public class Main0054_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Map<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new TreeMap<>();
            int p = 0;
            String[] line = sc.nextLine().split(" ");
            for (int i1 = 0; i1 < line.length; i1++) {
                map.put(Integer.valueOf(line[i1]), i1);
            }
            list.add(map);
        }

        int res = solution(list);
        System.out.println(res);

    }

    private static int solution(List<Map<Integer, Integer>> list) {
        int res = 0;
        res += new ArrayList<>(list.get(0).keySet()).get(0);

        int last = 0;

        int size = list.size();
        for (int i = 1; i < size; i++) {
            ArrayList<Integer> integers = new ArrayList<>(list.get(i).keySet());
            Integer val = integers.get(0);
            Integer cur = list.get(i).get(val);

            if (last == cur) {
                res += integers.get(1);
                last = list.get(i).get(integers.get(i));
            } else {
                res += val;
                last = cur;
            }
        }
        return res;
    }
}