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
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7      3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * <p>
 * 题目链接：https://leetcode-cn.com/problems/sliding-window-maximum
 */
public class LeetCode_239 {

    /**
     * 思路：利用队列，尾部进入，头部弹出，每次移动一个位置，直到到达数组底部，
     * 窗口内获取最大值，在窗口填满时，计算一次最大值，在之后加入窗口的元素与这个最大值比较并进行更新
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        Queue<Integer> window = new LinkedList<>();
        //最值的个数=数组长度-滑动窗口大小+1
        int[] maxs = new int[nums.length - k + 1];
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                if (count == 0) {
                    max = findMax(window);
                }
                maxs[count++] = max;
                window.poll();
            }
            if (nums[i] > max) {
                max = nums[i];
            }
            window.offer(nums[i]);
        }
        //窗口到达数组底部后找出最大值
        maxs[count++] = findMax(window);

        return maxs;
    }


    /**
     * 窗口维持成一个单调递减的双向队列，
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length < 2) {
            return nums;
        }

        LinkedList<Integer> queue = new LinkedList<>();

        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);

            if (queue.peek() <= i - k) {
                queue.poll();
            }

            if(i+1>=k){
                result[i+1-k]=nums[queue.peek()];
            }
        }
        return result;
    }

    public static int findMax(Queue<Integer> queue) {

        Iterator<Integer> iterator = queue.iterator();
        Integer max = iterator.next();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
            if (max.compareTo(temp) < 0) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // expect: 3 3 5 5 6 7
        int[] test1 = {1, 3, -1, -3, 5, 3, 6, 7};
        // expect: 5 3 4
        int[] test2 = {5, 3, 4};
        int windowSize = 1;
        for (int i : LeetCode_239.maxSlidingWindow(test2, windowSize)) {
            System.out.print(i + " ");
        }
    }

}
