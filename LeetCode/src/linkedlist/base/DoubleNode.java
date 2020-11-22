package linkedlist.base;

/**
 * 双向链表节点
 */
public class DoubleNode {

    public DoubleNode pre;
    public DoubleNode next;
    public int data;

    public DoubleNode() {

    }

    public DoubleNode(DoubleNode pre, DoubleNode next, int data) {
        this.pre = pre;
        this.next = next;
        this.data = data;
    }

    public DoubleNode(int data){
        this.data=data;
    }


}
