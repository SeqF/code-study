package queue.LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 *
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 题目链接：https://leetcode-cn.com/problems/sliding-window-maximum
 *
 */
public class LeetCode_239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Queue<Integer> window = new LinkedList<>();
        int[] max = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                window.poll();
            }
            window.offer(nums[i]);
            max[i]=findMax(window);
        }
        return max;
    }

    public static int findMax(Queue<Integer> queue){

        Iterator<Integer> iterator = queue.iterator();
        Integer max=iterator.next();
        while (iterator.hasNext()){
            Integer temp=iterator.next();
            if(max.compareTo(temp)<0){
                max=temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        for (int i : LeetCode_239.maxSlidingWindow(nums, 3)) {
            System.out.print(i+" ");
        }
    }

}
