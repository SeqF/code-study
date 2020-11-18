package linkedlist.base;

/**
 * 实现单链表，支持增删操作
 */
public class SingleLinkedList {

    public static Node head = new Node();

    /**
     * 查询链表长度
     *
     * @return length 链表长度
     */
    public static int linkedListLength() {
        int length = 0;
        //长度不包含头结点
        Node temp = head.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 用头插法添加结点
     *
     * @param data 插入链表中的数据
     */
    public static void addNode(int data) {

        Node newNode = new Node(data);
        while (head.next != null) {
            newNode.next = head.next;
            head.next = newNode;
        }
        head.next = newNode;
    }

    /**
     * 在指定位置插入一个结点
     *
     * @param index 位置
     * @param data  数据
     */
    public static void insertNode(int index, int data) {

        if (index < 1 || index > linkedListLength() + 1) {
            return;
        }

        int currentPos = 0;
        Node temp = head;
        Node newNode = new Node(data);

        while (temp.next != null) {
            if ((index - 1) == currentPos) {
                newNode.next = temp.next;
                temp.next = newNode;
            }
            temp = temp.next;
            currentPos++;
        }
        temp.next = newNode;
    }

    /**
     * 删除一个指定位置的结点
     *
     * @param index 要删除的位置
     */
    public static void deleteNode(int index) {

        if (index < 1 || index > linkedListLength() + 1) {
            return;
        }

        int currentPos = 0;
        Node temp = head;

        while (temp.next != null) {
            if ((index - 1) == currentPos) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
            currentPos++;
        }
        return;
    }


}
