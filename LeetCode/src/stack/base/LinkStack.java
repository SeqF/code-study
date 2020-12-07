package stack.base;

import java.util.Iterator;

/**
 * 用链表实现一个链式栈
 */
public class LinkStack {

    public class StackOfLinked<Item> implements Iterable<Item> {
        //定义一个内部类，就可以直接使用类型参数
        private class Node{
            Item item;
            Node next;
        }
        private Node first;
        private int N;
        //构造器
        public StackOfLinked(){}
        //添加
        public void push(Item item){
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            N++;
        }
        //删除
        public Item pop(){
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }
        //是否为空
        public boolean isEmpty(){
            return N == 0;
        }
        //元素数量
        public int size(){
            return N;
        }
        //返回栈中最近添加的元素而不删除它
        public Item peek(){
            return first.item;
        }
        @Override
        public Iterator<Item> iterator() {
            return new LinkedIterator();
        }
        //内部类：迭代器
        class LinkedIterator implements Iterator{
            int i = N;
            Node t = first;
            @Override
            public boolean hasNext() {
                return i > 0;
            }
            @Override
            public Item next() {
                Item item = (Item) t.item;
                t = t.next;
                i--;
                return item;
            }
        }
    }
}
