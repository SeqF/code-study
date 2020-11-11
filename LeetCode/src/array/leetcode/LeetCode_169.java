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

    public static int majorityElement(int[] nums) {

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
//        int max=map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        Collection<Integer> counts = map.values();
        Object[] array = counts.toArray();
        Arrays.sort(array);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(array[array.length-1])){

            }
        }
    }
}
