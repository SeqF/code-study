package leetcode150.easy;

import tree.base.Node;

/**
 * 二叉树的最大深度
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class LeetCode_104 {

    int maxDepth;

    /**
     * 递归遍历，每次访问节点前深度+1，求max和depth的最大值
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return maxDepth;
    }

    public void dfs(Node node, int deepth) {
        if (node == null) {
            return;
        }
        deepth++;
        maxDepth = Math.max(deepth, maxDepth);
        dfs(node.left, deepth);
        dfs(node.right, deepth);
    }
}
