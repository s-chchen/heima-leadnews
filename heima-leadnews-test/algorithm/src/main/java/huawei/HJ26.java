package huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HJ26 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        char[] charArray = s.toCharArray();

        List<Character> letterList = new ArrayList<>();
        for (char c : charArray) {
            if (Character.isLetter(c)) {
                letterList.add(c);
            }
        }

        letterList.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1) - Character.toLowerCase(o2);
            }
        });

        String res = "";
        int i = 0, j = 0;
        while (i < s.length()) {
            if (Character.isLetter(s.charAt(i))) {
                res += letterList.get(j++);
            } else {
                res += s.charAt(i);
            }
            i++;
        }

        System.out.println(res);

    }

}
