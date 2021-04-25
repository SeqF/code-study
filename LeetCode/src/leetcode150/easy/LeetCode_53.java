package leetcode150.easy;

/**
 * 最大子序和
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class LeetCode_53 {

    /**
     * 用动态规划解决
     * 1、状态：dp[i]表示到nums[i]结尾的最大的和
     * 2、状态转移方程：dp[i]=Math.max(dp[i-1]+nums[i],nums[i])
     * 3、初始化：dp[0]=nums[0]，第一序列之和和为数组第一个
     * 4、输出：返回最大值
     *
     * @param nums
     * @return
     */
    public int mxaSubArray(int[] nums) {
        int length = nums.length;
        //构建动态规划数组
        int[] dp = new int[length + 1];
        int result = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return Math.max(dp[0], result);
    }
}
