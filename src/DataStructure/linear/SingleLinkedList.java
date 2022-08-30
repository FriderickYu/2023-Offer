package DataStructure.linear;

import java.util.Iterator;

public class SingleLinkedList<T> implements Iterable<T>{
    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    public class SIterator implements Iterator<T>{
        private Node n;
        public SIterator() {
            n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }

    private class Node{
        // 存储数据
        T item;
        // 指针，指向下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    // 记录头结点
    private Node head;
    // 记录链表的长度
    private int N;

    public SingleLinkedList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    // 清空链表
    public void clear(){
        head.next = null;
        N = 0;
    }

    // 获取链表的长度
    public int length(){
        return N;
    }

    // 判断链表长度是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    // 获取指定位置i处的元素
    public T get(int i){
        Node n = head;
        for(int index = 0; index <= i; index ++)
        {
            n = n.next;
        }
        return n.item;
    }

    // 往链表中添加一个元素
    public void insert(T t){
        Node n = head;
        // 找到最后一个节点
        while(n.next != null){
            n = n.next;
        }
        // 创建新节点
        Node newNode = new Node(t, null);
        // 让最后一个结点指向新节点
        n.next = newNode;
        // 元素个数+1
        N ++;

    }

    // 往链表中的指定索引处添加一个元素
    public void insert(int i, T t)
    {
        Node n = head;
        // 找到i-1位置处的节点
        for(int index = 0; index <= i - 1; index ++){
            n = n.next;
        }
        // 创建新的节点
        Node newNode = new Node(t, null);
        // 将新节点的指针指向原i处的元素
        newNode.next = n.next;
        // 将i-1处的元素指针指向新节点
        n.next = newNode;
        // 节点个数+1
        N ++;
    }

    // 删除i位置上的元素，并返回该元素
    public T remove(int i){
        Node n = head;
        // 找到i-1位置处的节点
        for(int index = 0; index <= i - 1; index ++){
            n = n.next;
        }
        // 找到i位置处的节点
        Node current = n.next;
        // 找到i+1位置处的节点
        Node nextNode = current.next;
        // 将i-1元素的指针指向i+1元素
        n.next = nextNode;
        // 整体元素-1
        N --;
        return current.item;
    }

    // 查找元素t出现的第一个位置
    public int indexOf(T t){
        Node n = head;
        for(int index = 0; index < N; index ++){
            n = n.next;
            if(n.item.equals(t)){
                return index;
            }
        }
        return -1;
    }
}
