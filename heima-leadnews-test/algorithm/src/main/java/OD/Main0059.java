package OD;


/**
 * 有一种简易压缩算法：针对全部为小写英文字母组成的字符串，
 * 将其中连续超过两个相同字母的部分压缩为连续个数加该字母
 * 其他部分保持原样不变.
 * 例如字符串aaabbccccd 经过压缩变成字符串 3abb4cd
 * 请您编写解压函数,根据输入的字符串,
 * 判断其是否为合法压缩过的字符串
 * 若输入合法则输出解压缩后的字符串
 * 否则输出字符串!error来报告错误
 * */

public class Main0059 {

    public static void main(String[] args) {
        String s = "3dfg4r";

        String res = decode(s);
        System.out.println(res);


    }

    private static String decode(String s) {
        StringBuilder res = new StringBuilder();
        int count = 1;

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                if (i >= 2) {
                    if (c == res.charAt(res.length() - 1) && c == res.charAt(res.length() - 2)) {
                        return "err";
                    }
                }
                if (count == 2) {
                    return "err";
                }

                for (int i1 = 0; i1 < count; i1++) {
                    res.append(c);
                }
                count = 1;
            }

            int pos = i;
            while (Character.isDigit(c)) {
                i++;
                c = s.charAt(i);
            }

            if (i > pos) {
                count = Integer.parseInt(s.substring(pos, i--));
            }

        }

        return res.toString();
    }


}
