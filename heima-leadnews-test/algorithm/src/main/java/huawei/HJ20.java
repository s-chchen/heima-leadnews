package huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HJ20 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {

            String s = in.nextLine();
            if (s.length() <= 8) {
                System.out.println("NG");
                continue;
            }
            if (! matchKind(s)) {
                System.out.println("NG");
                continue;
            }
            if (repeat(s, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean repeat(String s, int l, int r) {
        if (r > s.length())
            return false;
        if (s.substring(r).contains(s.substring(l, r))) {
            return true;
        }
        return repeat(s, l+1, r+1);
    }

    private static boolean matchKind(String s) {
        int cnt = 0;
        /*Pattern pattern1 = Pattern.compile("[0-9]]");
        pattern1.matcher(s).find();*/
        if (s.matches(".*[0-9].*")) {
            cnt ++;
        }
        if (s.matches(".*[a-z].*")) {
            cnt++;
        }
        if (s.matches(".*[A-Z].*")) {
            cnt ++;
        }
        if (s.matches(".*[^0-9a-zA-z].*")) {
            cnt ++;
        }
        if (cnt >= 3) {
            return true;
        }
        return false;
    }

}
