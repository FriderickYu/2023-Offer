package DataStructure.linear;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T>{
    @Override
    public Iterator<T> iterator() {
        return new DIterator();
    }
    public class DIterator implements Iterator{

        private Node n;

        public DIterator() {
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
        Node pre;
        Node next;
        T item;

        public Node(Node pre, Node next, T item) {
            this.pre = pre;
            this.next = next;
            this.item = item;
        }
    }
    private Node head; // 头节点
    private Node last; // 尾节点
    private int N; // 元素个数
    public DoubleLinkedList(){
        // 初始化头节点和尾节点
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    // 清空链表
    public void clear(){
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.last = null;
    }

    // 获取链表长度
    public int length(){
        return N;
    }

    // 判断链表是否为空
    public boolean isEmpty(){
        return N==0;
    }

    // 获取第一个元素
    public T getFirst(){
        if(isEmpty())
        {
            return null;
        }
        return head.next.item;
    }

    // 获取最后一个元素
    public T getLast(){
        if(isEmpty())
        {
            return null;
        }
        return last.item;
    }

    // 在末尾插入元素t
    public void insert(T t){
        // 如果当前链表为空
        if(isEmpty()){
            // 创建一个新的节点
            Node newNode = new Node(head, null, t);
            // 新节点即为尾节点
            last = newNode;
            // 头结点尾指针指向尾节点
            head.next = last;
        }
        // 如果不为空
        else{
            // 创建一个新的节点
            Node newNode = new Node(last, null, t);
            // 尾元素指向新元素
            last.next = newNode;
            // 新元素成为新的尾元素
            last = newNode;
        }
        // 元素个数+1
        N ++;
    }

    // 在指定位置处插入元素t
    public void insert(int i, T t){
        // 找到i-1处的元素
        Node n = head;
        for(int index = 0; index <= i - 1; index ++){
            n = n.next;
        }
        // 找到i处的元素
        Node current = n.next;
        // 创建一个新元素，前驱指针指向i-1,后续指针指向i
        Node newNode = new Node(n, current, t);
        // 将i-1处的元素的后继指针指向新节点
        n.next = newNode;
        // 让原i处的元素的前驱指针指向新节点
        current.pre = newNode;
        // 元素个数+1
        N ++;
    }

    // 获取指定位置i处的元素
    public T get(int i){
        Node n = head;
        for(int index = 0; index <= i; index ++){
            n = n.next;
        }
        return n.item;
    }

    // 找到元素t在链表中第一次出现的位置
    public int indexOf(T t){
        Node n = head;
        for(int i = 0; n.next != null; i ++){
            n = n.next;
            if(n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    // 删除位置i处的元素，并返回该元素
    public T remove(int i){
        Node n = head;
        // 找到i-1处的元素
        for(int index = 0; index <= i - 1; index ++){
            n = n.next;
        }
        // 找到i处的元素
        Node current = n.next;
        // 找到i+1处的元素
        Node nextNode = current.next;
        // 让i-1处的元素的后继指针指向i+1处的元素
        n.next = nextNode;
        // 让i+1处元素的前序指针指向i-1处的元素
        nextNode.pre = n;
        // 元素的人数-1
        N --;
        return current.item;
    }

    // 对整个链表进行反转
    public void reverse(){
        if(isEmpty()){
            return;
        }
        // 否则从第一个元素开始进行递归反转
        revsere(head.next);
    }

    // 对单个节点进行反转
    public Node revsere(Node current){
        // 递归终止：如果到达尾元素，则让head指向尾元素，并返回尾元素
        if(current.next == null){
            head.next = current;
            return current;
        }
        else{
            // 创建一个元素，代表反转后当前元素的上一个节点
            Node pre = revsere(current.next);
            pre.next = current;
            current.next = null;
            return current;

        }
    }




}
