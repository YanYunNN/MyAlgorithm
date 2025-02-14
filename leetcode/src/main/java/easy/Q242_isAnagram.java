package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xcai
 * @date 2025/02/11
 * @see <a href=''>Conf<a/>
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 */
public class Q242_isAnagram {
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!countMap.containsKey(c)) return false;
            countMap.put(c, countMap.getOrDefault(c, 0) - 1);
            if (countMap.get(c) == 0) countMap.remove(c);
        }
        return countMap.isEmpty();

    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
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
