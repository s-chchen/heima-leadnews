package Q4C;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QC11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        Map<Integer, int[]> dic = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = grid[i][j];
                if (color == 0) {
                    continue;
                }
                if (! dic.containsKey(color)) {
                    dic.put(color, new int[]{i, i, j, j});
                } else {
                    int[] boundaries = dic.get(color);

                    if (i < boundaries[0]) {
                        boundaries[0] = i;
                    }
                    if (i > boundaries[1]) {
                        boundaries[1] = i;
                    }
                    if (j < boundaries[2]) {
                        boundaries[2] = j;
                    }
                    if (j > boundaries[3]) {
                        boundaries[3] = j;
                    }
                }


            }
        }

        int maxArea = 0;
        for (int[] boundary : dic.values()) {
            int top = boundary[0];
            int bottom = boundary[1];
            int left = boundary[2];
            int right = boundary[3];

            int area = (bottom - top + 1) * (right - left + 1);
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);

    }

}
