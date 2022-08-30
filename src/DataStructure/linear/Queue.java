package DataStructure.linear;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{
    // 首节点
    private Node head;
    // 尾节点
    private Node last;
    // 队列内的元素个数
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }
    public class QIterator implements Iterator{
        private Node n;

        public QIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    private class Node{
        public T item;
        public Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
    public Queue(){
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

    //返回队列中元素的个数
    public int size(){
        return N;
    }

    // 向队列尾部插入元素
    public void enqueue(T t){
        // 如果尾节点为空
        if(last == null){
            // 新节点即为尾节点
            last = new Node(t, null);
            // 头节点指针指向尾节点
            head.next = last;
        }
        // 如果尾节点存在
        else{

            Node oldNode = last;
            // 新节点成为新的尾节点
            last = new Node(t, null);
            oldNode.next = last;
        }
        // 元素个数+1
        N ++;
    }

    // 从队列头部退出一个元素
    public T dequeue(){
        // 如果队列为空
        if(isEmpty()){
            return null;
        }
        // 原本排在队列前的元素
        Node oldFirst = head.next;
        head.next = oldFirst.next;
        // 元素个数-1
        N --;
        // 如果队列中元素被删除殆尽，则需将last重置尾null
        if(isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

    // 从队列头部找到第一个元素，并返回第一个元素
    public T peek(){
        if(head.next == null)
        {
            return null;
        }
        return head.next.item;
    }

}
