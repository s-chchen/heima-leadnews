package OD;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2020/12/5
 * Time: 18:41
 * Description:
 */
public class Main0016 {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      String line = scanner.nextLine();
      solution(line);
    }
  }

  private static void solution(String line) {
    String[] split = line.split(" ");
    int sum = 0;
    for (String s : split) {
      sum += Integer.parseInt(s);
    }

    int[] res = new int[split.length];

    int j = 0;
    int sum1 = 0;
    for (int i = 1; i < 300; i++, j++) {
      if (j == split.length) j = 0;
      if (i % 7 == 0 || (i + "").contains("7")) {
        res[j] += 1;
        sum1++;
      }
      if (sum == sum1) break;
    }

    for (int i = 0; i < res.length; i++) {
      System.out.print(res[i]);
      if (i != res.length - 1) {
        System.out.print(" ");
      }
    }
  }
}