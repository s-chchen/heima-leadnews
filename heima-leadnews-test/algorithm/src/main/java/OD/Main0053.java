package OD;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 一个正整数数组 设为nums
 * 最大为100个成员
 * 求从第一个成员开始正好走到数组最后一个成员所使用的最小步骤数
 * 要求：
 *
 * 第一步 必须从第一元素起，且1 <= 第一步步长 < len/2 (len为数组长度)
 * 从第二步开始只能以所在成员的数字走相应的步数，不能多不能少，
 * 如果目标不可达返回-1
 * 只输出最小的步骤数量
 * 只能向数组的尾部走不能向回走
 * 输入描述
 * 一正整数数组 空格分割
 * 数组长度<100
 *
 * 输出描述
 * 正整数 最小步数
 * 不存在输出-1
 *
 * 示例一
 * 输入
 * 7 5 9 4 2 6 8 3 5 4 3 9
 * 输出
 * 2
 * **/


public class Main0053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int res = solution(list);
        System.out.println(res);
    }

    private static int solution(List<Integer> list) {
        int size = list.size();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < size/2; i++) {
            int step = 1;
            int cur = i;
            int dur = list.get(i);

            while (cur < size - 1) {
                step++;
                cur += dur;
                if (cur > size - 1) break;
                dur = list.get(cur);
            }

            if (cur == size - 1) {
                set.add(step);
            } else {
                set.add(-1);
            }
        }

        if (set.size() > 1) {
            set.pollFirst();
        }
        return set.first();
    }

}
