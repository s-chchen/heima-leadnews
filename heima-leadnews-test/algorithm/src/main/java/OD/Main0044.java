package OD;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/4/20
 * Time: 16:47
 * Description:
 */
public class Main0044 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        List<String> operators = Arrays.stream(line.split("\\w+"))   // 等价于 [A-Za-z0-9_]
                .filter(x -> !x.isEmpty())
                .collect(Collectors.toList());

        List<Integer> nums = Arrays.stream(line.split("\\W+"))   // 表示[^A-Za-z0-9_]
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int pos$ = operators.indexOf("$");
        while (pos$ != -1) {
            int tmp = dollar(nums.get(pos$), nums.get(pos$ + 1));
            nums.set(pos$, tmp);
            nums.remove(pos$ + 1);
            operators.remove(pos$);
            pos$ = operators.indexOf("$");
        }

        int res = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            res = sharp(res, nums.get(i));
        }

        System.out.print(res);
    }

    public static int sharp(int x, int y) {
        return 2 * x + 3 * y + 4;
    }

    public static int dollar(int x, int y) {
        return 3 * x + y + 2;
    }
}