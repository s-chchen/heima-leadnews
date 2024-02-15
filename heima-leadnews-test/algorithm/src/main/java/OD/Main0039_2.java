package OD;

import java.util.LinkedList;
import java.util.Scanner;

public class Main0039_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];//装入阶乘的结果作为基
        LinkedList<Integer> list = new LinkedList<>();//装需要全排序的元素
        a[0] = 1;//0!=1
        for (int i = 1; i < n; i++) {//计算阶乘
            a[i] = a[i - 1] * i;
        }
        for (int i = 1; i <= n; i++) {//初始化全排序元素
            list.add(i);
        }
        k = k - 1;//相对于自然顺序的偏移量
        StringBuilder builder = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            //将第offset位元素提到第0位，偏移增长offset*(size - 1)!，其中size为当前余下的需要排列的元素总数
            int offset = k / a[i];
            k = k % a[i];//余下的偏移量
            builder.append(list.remove(offset));//从需要排列的元素中选择第offset个元素加入排列中
        }
        System.out.println(builder);
    }
}


/**
 * 1234
 * 1243
 * 1324
 * 1342
 * 1423
 * 1432
 *
 *
 * */