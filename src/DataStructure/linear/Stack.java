package DataStructure.linear;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {
    // 记录首节点
    private Node head;
    // 记录栈中元素的个数
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    public class SIterator implements Iterator{
        private Node n;

        public SIterator() {
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
    public Stack(){
        this.head = new Node(null, null);
        this.N = 0;
    }

    // 判断栈内是否为空
    public boolean isEmpty(){
        return N == 0;
    }

    // 判断栈内的元素个数
    public int size(){
        return N;
    }

    // 压栈
    // 让首节点指向新的节点
    public void push(T t){
        // 找到原先头结点指向的节点
        Node oldNode = head.next;
        // 创建新的节点t
        Node newNode = new Node(t, null);
        // 让头结点指向新的节点
        head.next = newNode;
        // 让新节点指向老节点
        newNode.next = oldNode;
        // 元素个数+1
        N ++;
    }

    // 弹栈
    public T pop(){
        // 先找到头结点指向的第一个节点
        Node oldNode = head.next;
        // 如果第一个节点不存在，则证明栈内没有元素，直接返回null
        if(oldNode == null){
            return null;
        }
        // 让头结点指向原来第一个节点的后续节点
        head.next = oldNode.next;
        // 释放掉旧有的第一个节点
        oldNode.next = null;
        // 元素个数-1
        N --;
        return oldNode.item;
    }

    // 返回栈顶元素
    public T peek(){
        if(head.next == null){
            return null;
        }
        return head.next.item;
    }
}
