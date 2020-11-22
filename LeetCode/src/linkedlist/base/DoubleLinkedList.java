package linkedlist.base;

/**
 * 实现双向链表，支持增删操作
 * https://www.cnblogs.com/782687539-nanfu/p/10333031.html
 */
public class DoubleLinkedList {

    private static DoubleNode pre;

    private static DoubleNode next;

    public static boolean empty(){
        if (pre.next==null){
            return true;
        }
        return false;
    }

    //找到指定下标的前一个节点
    public static DoubleNode findPreNode(int index){

    }
}
