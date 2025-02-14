package easy;

public class Q383_canConstruct {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] record = new int[26];

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : magazine.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int num : record) {
            if (num > 0) return false;
        }
        return true;
    }

}
