package array.leetcode;

import java.util.*;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *  
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * <p>
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class LeetCode_169 {

    /**
     * 尝试用map存储对应的元素及其计数，然后用map来找出最大值
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        int count = 0;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i==0){
                count++;
            }else if (i>0 && nums[i-1] == nums[i]) {
                count++;
            }else {
                map.put(nums[i],count);
                count=0;
            }
        }
        int max=map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        return max;
    }

    /**
     * 摩尔投票法：
     *  就是选取一个数，默认为是众数，遇到相同的元素就+1，不同的元素就-1；当计数为0，将众数换为下一个元素
     *  思想就是，
     */
}
