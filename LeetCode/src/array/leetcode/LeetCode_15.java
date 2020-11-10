package array.leetcode;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 思路：
 * 将三数之和转换为两数之和
 * 即：a+b+c=0 --> a+b=-c
 */
public class LeetCode_15 {

    /**
     * 暴力枚举，三层遍历
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int q = j + 1; q < nums.length; q++) {
                    if (nums[i] + nums[j] + nums[q] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[q]));
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }

    /**
     * 将值放入map中,变成两层循环
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(0-nums[i]-nums[j])){
                    result.add(Arrays.asList(nums[i],nums[j],-(nums[i]+nums[j])));
                }
            }
            map.put(nums[i],i);
        }
        HashSet set = new HashSet(result);
        result.clear();
        result.addAll(set);
        System.out.println(result);
        return result;
    }

}
