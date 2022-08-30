package DataStructure.test;

import java.util.Iterator;
import java.util.Stack;

// 约瑟夫环问题
public class JosephCircleTest {
    public static void main(String[] args)
    {
        // 构建约瑟夫环，包含41个元素
        // 构建第一个节点
        Node<Integer> first = null;
        //
        Node<Integer> p = null;
        for(int i = 1; i <= 41; i ++){
            // 第一个节点如此处理
            if(i == 1){
                first = new Node<>(i, null);
                p = first;
                continue;
            }
            // 如果不是第一个节点
            Node<Integer> newNode = new Node<>(i, null);
            p.next = newNode;
            p = newNode;
            // 如果到最后一个节点了，则尾指针指向第一个节点，完成循环链表的构建
            if(i == 41){
                p.next = first;
            }
        }
        // 设置一个计数器。模拟报数
        int count = 0;
        // 记录每次拿到的节点，从首节点开始
        Node<Integer> n = first;
        // 记录当前节点的上一个节点，用作删除节点时使用
        Node<Integer> pre = null;
        // 设置循环条件，当只剩一个元素时，循环链表中n = n.next
        while(n != n.next.next){
            // 开始模拟报数
            count ++;
            // 判断是不是3
            // 如果是3，则删除该节点
            if(count == 3){
                pre.next = n.next;
                // 打印已删除的节点值
                System.out.println(n.item + ",");
                // 计数器重置
                count = 0;
                n = n.next;
            }
            else{
                // 如果不是3，则让pre指向当前节点，而当前节点向后走
                pre = n;
                n = n.next;
            }
        }
        // 打印最后两个元素

    }

    // 内部节点类
    private static class Node<T>{
        // 存储元素
        T item;
        // 指针
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }


    }
}
