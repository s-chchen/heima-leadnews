package OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main0025 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list.toString());

        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");

        Arrays.sort(arr, (o1, o2) -> {
            int n1 = o1.charAt(o1.length() - 1) - '0';
            int n2 = o2.charAt(o2.length() - 1) - '0';
            return n1 - n2;
        });

        for (String s : arr) {
            System.out.printf(s + " ");
        }
    }

}
