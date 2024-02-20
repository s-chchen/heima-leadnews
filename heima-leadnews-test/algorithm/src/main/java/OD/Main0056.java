package OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/5/24
 * Time: 13:50
 * Description:
 */
public class Main0056 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int n = Integer.parseInt(scanner.nextLine());
      List<List<String>> days = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        String[] split = scanner.nextLine().split(" ");
        List<String> list = Arrays.stream(split)
            .collect(Collectors.toList());
        days.add(list);
      }
      solution(days);
    }


  }

  private static void solution(List<List<String>> days) {


    StringBuilder builder = new StringBuilder();

    for (List<String> day : days) {

      //1.缺勤超过1次
      long absent = day.stream()
          .filter(x -> x.equals("absent"))
          .count();
      if (absent > 1) {
        builder.append("false").append(" ");
        continue;
      }


      //2.没有连续的迟到/早退
      boolean flag = true;
      for (int i = 0; i < day.size() - 1; i++) {
        String cur = day.get(i);
        String next = day.get(i + 1);
        if (("late".equals(cur) ||
            "leaveearly".equals(cur)) &&
            ("late".equals(next) ||
                "leaveearly".equals(next))) {
          flag = false;
          break;
        }
      }
      if (!flag) {
        builder.append(flag).append(" ");
        continue;
      }


      //3.任意连续7次考勤 缺勤/迟到/早退 不超过3次
      int[] ints = new int[day.size()];
      for (int i = 0; i < day.size(); i++) {
        ints[i] = "present".equals(day.get(i)) ? 0 : 1;
      }
      if (ints.length <= 7 && Arrays.stream(ints).sum() >= 3) {
        builder.append("false").append(" ");
      } else {
        flag = true;
        for (int i = 0; i < ints.length - 7; i++) {
          int[] subArr = Arrays.copyOfRange(ints, i, i + 7);
          if (Arrays.stream(subArr).sum() >= 3) {
            flag = false;
            break;
          }
        }
        builder.append(flag).append(" ");
      }
    }

    System.out.print(builder.substring(0, builder.length() - 1));
  }
}