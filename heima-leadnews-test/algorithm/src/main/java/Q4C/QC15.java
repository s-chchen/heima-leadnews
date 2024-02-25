package Q4C;

import java.util.Arrays;
import java.util.Scanner;

public class QC15 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(",");
        Arrays.sort(arr, (o1, o2) -> {
            return o1.compareTo(o2);
        });
        System.out.println(arr);

        /**
         * CA3385,CZ6678,SC6508,DU7523,HK4456,MK0987
         * CA,CZ,SC,DU,HK,MK
         * */
    }

}
