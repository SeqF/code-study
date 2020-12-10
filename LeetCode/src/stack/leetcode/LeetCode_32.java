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
 */
public class LeetCode_32 {

    public int longestValidParentheses(String s) {

        if (s.isEmpty()) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (')'==chars[i] && !stack.isEmpty()) {
                stack.pop();
                count++;
            }else {
                stack.push(chars[i]);
            }
        }
        return count * 2;
    }
}
