package OD;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * N进制减法
 * 题目描述
 * 实现一个基于字符串的N进制的减法
 * 需要对输入的两个字符串按照给定的N进制进行减法操作
 * 输出正负符号和表示结果的字符串
 *
 * 输入描述
 * 输入三个参数
 * 第一个参数是整数形式的进制N值
 * N值范围大小为 2 <= N <= 35
 * 第二个参数为被减数字符串
 * 第三个参数为减数字符串
 * 有效的字符包括0~9以及小写字母a~z
 * 字符串有效字符个数最大为100个字符
 * 另外还有结尾的\0
 * 限制：输入的被减数和减数除了单独的0以外 不能是以0开头的字符串
 * 如果输入有异常或计算过程中有异常 此时应当输出-1表示错误
 *
 * 输出描述
 * 结果是两个
 * 第一个是减法计算的结果
 * -1表示出错 0表示结果为整数 1表示结果为负数
 * 其二为表示结果的字符串
 *
 * 示例一
 * 输入
 * 2 11 1
 * 输出
 * 0 10
 * **/


public class Main0049 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");

        String res = solution(arr);
        System.out.println(res);


    }

    private static String solution(String[] arr) {
        int radix = Integer.parseInt(arr[0]);
        if (arr[1].length() >0 && arr[1].startsWith("0") ||
                arr[2].length() >0 && arr[2].startsWith("0")) {
            return "-1";
        }

        BigInteger bigInteger = new BigInteger(arr[1], radix);
        BigInteger bigInteger2 = new BigInteger(arr[2], radix);

        BigInteger subtract = bigInteger.subtract(bigInteger2);
        int signum = subtract.signum();
        String abs = subtract.abs().toString(radix);

        return (signum == 1 ? 0 : 1) + " " + abs;
    }


}
