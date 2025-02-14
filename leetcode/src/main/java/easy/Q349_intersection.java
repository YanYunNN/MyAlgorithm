package easy;

import java.util.HashSet;

/**
 * @author xcai
 * @date 2025/02/11
 * @see <a href=''>Conf<a/>
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2] 输出：[2]
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出：[9,4]
 */
public class Q349_intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums1) {
            hashSet.add(num);
        }
        for (int num : nums2) {
            if (hashSet.contains(num)) {
                resultSet.add(num);
            }
        }

        return resultSet.stream().mapToInt(x -> x).toArray();

        /*int[] res = new int[hashSet.size()];
        int i = 0;
        for (Object num : resultSet.toArray()) {
            res[i++] = (int) num;
        }
        return res;*/
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int num : count) {
            if (num != 0) return false;
        }
        return true;
    }

}
