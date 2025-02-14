package medium;

import java.util.HashMap;
import java.util.Map;

public class Q454_fourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int a : nums3) {
            for (int b : nums4) {
                res += map.getOrDefault(-a - b, 0);
            }
        }
        return res;
    }
}
