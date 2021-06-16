package leetcode150.medium;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全排列
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutations/
 */
public class LeetCode_46 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Map<Integer, Boolean> map = new HashMap<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int num : nums) {
            map.put(num, Boolean.FALSE);
        }
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (Boolean.FALSE.equals(map.get(nums[i]))) {
                path.add(nums[i]);
                map.put(nums[i], Boolean.TRUE);
                backTracking(nums, i+1);
                path.remove(Integer.valueOf(nums[i]));
                map.put(nums[i], Boolean.FALSE);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode_46 code46 = new LeetCode_46();
        System.out.println(code46.permute(new int[] {1,2,3}).toString());
    }
}
