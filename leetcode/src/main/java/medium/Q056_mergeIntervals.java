package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q056_mergeIntervals {

    //贪心算法
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for (int[] interval : intervals) {
            if (res.isEmpty() || interval[0] > res.getLast()[1]) {
                res.add(interval);
            } else {
                //注意这里是max，因为存在（1，4）（2，3）case
                res.getLast()[1] = Math.max(interval[1], res.getLast()[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge1(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > right) {
                res.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
            } else {
                right = Math.max(intervals[i][1], right);//注意这里是max，因为存在（1，4）（2，3）case
            }
        }
        res.add(new int[]{left, right});//添加最后一个区间，for最后一次只赋值
        return res.toArray(new int[res.size()][]);
    }
}
