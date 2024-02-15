package OD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created with IntelliJ IDEA.
 * Author: Amos
 * E-mail: amos@amoscloud.com
 * Date: 2021/4/1
 * Time: 15:26
 * Description:
 */
public class Main0039 {
    static TreeSet<String> set = new TreeSet<>();

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            solution(n, k);
        }

    }

    private static void solution(int n, int k) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        perm(arr, 0, n - 1);
        String res = new ArrayList<>(set).get(k - 1);
        System.out.println(res);
    }

    public static void perm(Integer[] array, int start, int end) {

        if (start == end) {
            String num = Arrays.toString(array).replaceAll("\\W+", "");
            set.add(num);
        } else {
            for (int i = start; i <= end; i++) {
                swap(array, start, i);
                perm(array, start + 1, end);
                swap(array, start, i);
            }
        }
    }

    public static void swap(Integer[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}