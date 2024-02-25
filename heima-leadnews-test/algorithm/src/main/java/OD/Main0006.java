package OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main0006 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int h = Integer.valueOf(s1.split(" ")[0]);
        Integer n = Integer.valueOf(s1.split(" ")[1]);

        List<Integer> list = new ArrayList<>();
        Arrays.stream(sc.nextLine().split(" ")).forEach(e -> {
            list.add(Integer.valueOf(e));
        });


        list.sort(((o1, o2) -> {
            int d1 = Math.abs(o1 - h);
            int d2 = Math.abs(o2 - h);
            return d2 == d1 ? o1 -o2 : d1 - d2;
        }));

        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i) + " ");
        }
    }

}
