package leetcode150.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个数组的交集
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class LeetCode_350 {

    /**
     * 哈希法，用MAP存元素出现的次数
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                res[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode_350 code350 = new LeetCode_350();
        int[] nums1 = new int[]{43, 85, 49, 2, 83, 2, 39, 99, 15, 70, 39, 27, 71, 3, 88, 5, 19, 5, 68, 34, 7, 41, 84,
                2, 13, 85, 12, 54, 7, 9, 13, 19, 92};
        int[] nums2 = new int[]{10, 8, 53, 63, 58, 83, 26, 10, 58, 3, 61, 56, 55, 38, 81, 29, 69, 55, 86, 23, 91, 44,
                9, 98, 41, 48, 41, 16, 42, 72, 6, 4, 2, 81, 42, 84, 4, 13};
        System.out.println(Arrays.toString(code350.intersect(nums1, nums2)));
    }

}
