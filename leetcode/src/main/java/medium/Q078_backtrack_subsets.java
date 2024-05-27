package medium;

import java.util.ArrayList;
import java.util.List;

public class Q078_backtrack_subsets {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    public void backtrack(int[] nums, int start) {
        //base line
        if (start > nums.length) return;
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);  //do
            backtrack(nums, i + 1); //i+1回溯的时候不需要-，因为回到这一层还是i
            track.remove(track.size() - 1); //undo
        }
    }
}
