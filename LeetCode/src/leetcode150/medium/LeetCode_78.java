package leetcode150.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/subsets/
 */
public class LeetCode_78 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.remove(Integer.valueOf(nums[i]));
        }
    }
}
