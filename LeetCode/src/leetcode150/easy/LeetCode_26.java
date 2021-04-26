package leetcode150.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 删除有序数组中的重复项
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class LeetCode_26 {

    /**
     * 用异或来处理，相同为0
     * 1、cursor来标记已处理的元素，遇到不同的元素就将它放到cursor的位置
     * 2、每一个元素与下一个元素异或，当不为0则说明遇到了不重复的元素，放到cursor处
     * 3、返回cursor
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int cursor = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] ^ nums[i + 1]) != 0) {
                nums[cursor++] = nums[i+1];
            }
        }
        return cursor;
    }
}
