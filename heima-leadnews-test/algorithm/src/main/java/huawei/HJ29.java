package huawei;

import java.util.Scanner;

public class HJ29 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String src = in.nextLine();
        String tar = in.nextLine();

        src = encode(src);
        tar = ddcode(tar);

        System.out.println(src);
        System.out.println(tar);
    }

    private static String ddcode(String tar) {
        char[] chars = tar.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 'a' + 'A' - 1);
            } else if (chars[i] == 'a'){
                chars[i] = 'Z';
            } else if (chars[i] == 'A'){
                chars[i] = 'z';
            } else if (chars[i] > 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] - 'A' + 'a' - 1);
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                int num = ((chars[i] - '0') + 9) % 10;
                chars[i] = (char) ('0' + num);
            }
        }
        return String.valueOf(chars);
    }

    private static String encode(String src) {
        char[] chars = src.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] < 'z') {
                chars[i] = (char) (chars[i] - 'a' + 'A' + 1);
            }else if (chars[i] == 'z'){
                chars[i] = 'A';
            }else if (chars[i] >= 'A' && chars[i] < 'Z') {
                chars[i] = (char) (chars[i] - 'A' + 'a' +1);
            } else if (chars[i] == 'Z'){
                chars[i] = 'a';
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                int num = ((chars[i] - '0') + 1) % 10;
                chars[i] = (char) ('0' + num);
            }
        }
        return String.valueOf(chars);
    }

}
