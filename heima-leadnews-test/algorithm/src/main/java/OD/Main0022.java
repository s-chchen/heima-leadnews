package OD;

import java.util.Arrays;
import java.util.Scanner;

public class Main0022 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] hs = sc.nextLine().split(" ");
        String[] ws = sc.nextLine().split(" ");

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = i+1;
            arr[i][1] = Integer.parseInt(hs[i]);
            arr[i][2] = Integer.parseInt(ws[i]);
        }

        /*Arrays.stream(arr).sorted((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[2] - o2[2];
            } else {
                return o1[1] - o2[1];
            }
        });*/

        Arrays.sort(arr, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[2] - o2[2];
            } else {
                return o1[1] - o2[1];
            }
        }));

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][0]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

    }

}
