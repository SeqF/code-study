package linkedlist.leetcode;

import linkedlist.base.Node;
import linkedlist.base.SingleLinkedList;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 题目链接:https://leetcode-cn.com/problems/merge-k-sorted-lists/comments/
 */
public class LeetCode_23 {

    /**
     * 多路归并
     * 参考文章（外部排序）:http://blog.itpub.net/31561269/viewspace-2564096/
     * 参考文章（priority_queue）:https://www.cnblogs.com/fightingcode/p/11616969.html
     * 思路：直接对Node[] lists 进行归并？
     * @param lists
     * @return
     */
    public SingleLinkedList mergeKLists(Node[] lists){

        for (int i = 0; i < lists.length; i++) {

        }
        return null;
    }

    public void merge(Node[] a,int low,int mid,int high){

        Node list = a[0];

        Node temp = new Node();

        if(list.next!=null){
            temp.next=list.next;
            list.next=null;
        }

        int count=0;
        Node p=temp.next;
        Node q=temp.next;
        Node m;
        Node r=list;
        while (p.next!=null){
            p=p.next;
            count++;
            if(count==mid){
                m=p;
            }
            if(count>mid){
                if(q.data<=p.data){
                    Node node = new Node();
                    node.data=q.data;
                    node.next=null;
                    r.next=node;
                }else {
                    Node node=new Node();
                    node.data=p.data;
                    node.next=null;
                    r.next=node;
                }
            }
        }

        while (q!=m){
            m.next=null;
            r.next=q;
        }

        while (p)

    }
}
