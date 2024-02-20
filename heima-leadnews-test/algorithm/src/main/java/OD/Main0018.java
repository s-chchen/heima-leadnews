package OD;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2022/7/11
 * Time: 22:19
 * Description:
 */
public class Main0018 {
  private static int[] ints = null;
  private static int step = 0;

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      String line = scanner.nextLine();
      solution(line);
    }
  }

  private static void solution(String line) {
    String[] split = line.split(" ");
    ints = new int[split.length];
    for (int i = 0; i < split.length; i++) {
      ints[i] = Integer.parseInt(split[i]);
    }
    int len = ints.length;

    TreeSet<Integer> set = new TreeSet<>();

    for (int i = 1; i < len / 2; i++) {
      step = 1;
      set.add(in(i, i));
    }

    if (set.size() != 1) {
      set.pollFirst();
    }
    System.out.println(set.first());
  }

  private static int in(int curPos, int lastPos) {
    int numStep = ints[curPos];
    if (lastPos == ints.length - 1) {
      return step;
    } else if (lastPos < ints.length - 1) {
      step++;
      return in(lastPos, lastPos + numStep);
    } else {
      return -1;
    }
  }
}