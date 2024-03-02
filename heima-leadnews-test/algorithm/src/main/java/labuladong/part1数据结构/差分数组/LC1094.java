package labuladong.part1数据结构.差分数组;

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 *
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 *
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * **/


class LC1094 {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2,1,5},
                {3,3,7}
        };
        int capacity = 4;

        LC1094 lc1094 = new LC1094();
        lc1094.carPooling(arr, capacity);
    }

    public boolean carPooling(int[][] trips, int capacity) {
        int toMax = 0;
        for (int[] trip : trips) {
            toMax = Math.max(toMax, trip[2]);
        }

        int[] diff = new int[toMax + 1];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        int count = 0;
        for (int i = 0; i <= toMax; ++i) {
            count += diff[i];
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }
}

