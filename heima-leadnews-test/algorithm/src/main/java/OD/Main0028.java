package OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main0028 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            List<Integer> list = new ArrayList<>();
            Arrays.stream(line.split(",")).forEach(e -> {
                list.add(Integer.valueOf(e));
            });

            int tMax = 0;
            for (int j = 0; j < n; j++) {
                String numStr = list.toString().replaceAll("\\W+", "");
                Integer num = Integer.parseInt(numStr, 2);
                tMax = tMax > num ? tMax : num;
                list.add(list.remove(0));
            }

            res += tMax;
        }

        System.out.println(res);

    }

}
