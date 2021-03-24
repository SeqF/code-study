package leetcode150.easy;

import linkedlist.base.Node;

/**
 * 删除链表中的节点
 *
 * 链接:https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class LeetCode_237 {

    /**
     * 将被删除节点的下一个节点复制到被删除节点上，然后再把下一个节点删除
     * @param node
     */
    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
