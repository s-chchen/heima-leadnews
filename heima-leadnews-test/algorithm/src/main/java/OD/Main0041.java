package OD;

import java.util.Scanner;


/**
 * 题目描述
 * 实现一个整数编码方法
 * 使得待编码的数字越小
 * 编码后所占用的字节数越小
 * 编码规则如下
 *
 * 编码时7位一组，每个字节的低7位用于存储待编码数字的补码
 * 字节的最高位表示后续是否还有字节，置1表示后面还有更多的字节，置0表示当前字节为最后一个字节
 * 采用小端序编码，低位和低字节放在低地址上
 * 编码结果按16进制数的字符格式进行输出，小写字母需要转化为大写字母
 * 输入描述
 * 输入的为一个字符串表示的非负整数
 *
 * 输出描述
 * 输出一个字符串表示整数编码的16进制码流
 *
 * 示例一
 * 输入
 * 0
 * 输出
 * 00
 * 说明
 * 输出的16进制字符不足两位的前面补零
 *
 * 示例二
 * 输入
 * 100
 * 输出
 * 64
 *
 * **/


public class Main0041 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String res = solution(n);
        System.out.println(res);
    }

    private static String solution(int n) {
        String binStr = Integer.toBinaryString(n);
        int len = binStr.length();

        StringBuilder sb = new StringBuilder();
        for (int i = len; i > 0; i -= 7) {
            int start = Math.max(i - 7, 0);

            String subStr = binStr.substring(start, i);
            int subLen = subStr.length();
            for (int i1 = 0; i1 < 7 - subLen; i1++) {
                subStr = "0" + subStr;
            }

            subStr = (i - 7 <= 0 ? "0" : "1") + subStr;
            String hexStr = Integer.toHexString(Integer.parseInt(subStr, 2)).toUpperCase();
            if (hexStr.length() == 1) {
                hexStr = "0" + hexStr;
            }
            sb.append(hexStr);
        }

        return sb.toString();
    }


}
