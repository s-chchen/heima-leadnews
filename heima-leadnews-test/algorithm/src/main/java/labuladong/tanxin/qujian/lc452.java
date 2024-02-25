package labuladong.tanxin.qujian;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * 中等
 * <p>
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 **/

public class lc452 {


    public static void main(String[] args) {
        int[][] arr = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int res = findMinArrowShots(arr);
        System.out.println(res);
    }

    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon : points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
