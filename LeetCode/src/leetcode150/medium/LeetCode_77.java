package leetcode150.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/combinations/
 */
public class LeetCode_77 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 回溯算法====>暴力枚举
     * 1、构建出一颗树，树的宽度为问题的规模，深度即为递归的次数
     * 2、套路一般是在 for 循环中进行 递归
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, k, 1);
        return result;
    }

    private void backTracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //剪枝,把n换为n-(k-path.size())+1 ?
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n, k, i + 1);
            path.remove(Integer.valueOf(i));
        }
    }
}
