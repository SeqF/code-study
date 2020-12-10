package stack.leetcode;

import java.util.Stack;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 示例 2:
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 * <p>
 * 题目链接：https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LeetCode_32 {

    /**
     * 跟用栈判断括号匹配类似的思路，再匹配成功出栈后进行计数
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {

        if (s.isEmpty()) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int count = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                if (')' == chars[i] && '(' == stack.peek()) {
                    count++;
                } else {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                }
                stack.push(chars[i]);
            }
        }
        max = count >= max ? count : max;
        return max * 2;
    }

    public static void main(String[] args) {
        LeetCode_32 leetCode32 = new LeetCode_32();
        String test = "(()";
        System.out.println(leetCode32.longestValidParentheses(test) == 2);
    }
}
