package OD;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/3/11
 * Time: 15:38
 * Description:
 */
public class Main0029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        solution(t);


    }

    private static void solution(int t) {

        System.out.println(t + "=" + t);
        List<String> res = new ArrayList<>();
        for (int n = 1; n < t; n++) {
            int sum = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = n; sum < t; i++) {
                sum += i;
                if (sum == t) {
                    builder.append(i);
                    res.add(t + "=" + builder);
                    break;
                }
                builder.append(i)
                        .append("+");
            }
        }
        res.sort(Comparator.comparingInt(String::length));
        res.forEach(System.out::println);

        System.out.println("Result:" + (res.size() + 1));
    }
}